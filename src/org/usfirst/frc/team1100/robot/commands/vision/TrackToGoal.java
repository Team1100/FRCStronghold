package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrackToGoal extends Command {

	private NetworkTable table;
	double[] defaultValue;

	private final double DRIVE_SPEED = .5;
	private final double ANGLE_SPEED = .4;// TODO: utilize PID instead
	private boolean isFinishedY;
	private boolean isFinishedX;
	private boolean isFinished;

	private double centerYtarget = 120; //TODO: find real values
	private double centerXtarget = 160;
	
	/**
	 * Moves the drive and intake to face the goal based
	 * off of what the camera sees.
	 */
	public TrackToGoal(){
		requires(Lift.getInstance());
		requires(Drive.getInstance());
	}
	
	@Override
	protected void initialize() {
		requires(Drive.getInstance());
		requires(Lift.getInstance());
		table = NetworkTable.getTable("GRIP/myContoursReport");
		defaultValue = new double[0];

		isFinishedY = false;
		isFinishedX = false;
		isFinished = false;
	}

	@Override
	protected void execute() {
		double[] area = table.getNumberArray("area", defaultValue);
		int index = 0;
		double max_area = 0;
		for (int i = 0; i < area.length; i++) {
			if (area[i] > max_area) {
				max_area = area[i];
				index = i;
				SmartDashboard.putNumber("Area", max_area);
			}
		}

		double[] centerX = table.getNumberArray("centerX", defaultValue);
		int ix = 0;
		if (!isFinishedX) {
			for (double x : centerX) {
				if (ix == index) {
					SmartDashboard.putNumber("X", x);
					if (x < centerXtarget) {
						Drive.getInstance().driveTank(-DRIVE_SPEED, DRIVE_SPEED);
					} else if (x > centerXtarget) {
						Drive.getInstance().driveTank(DRIVE_SPEED, -DRIVE_SPEED);
					} else {
						Drive.getInstance().driveTank(0, 0);
						isFinishedX = true;
					}
				}
				ix++;
			}
		}
		if (centerX.length == 0) {
			Drive.getInstance().driveTank(0, 0);
			SmartDashboard.putNumber("X", 0);
			isFinishedX = true;
		}

		double[] centerY = table.getNumberArray("centerY", defaultValue);
		int iy = 0;
		if (!isFinishedY) {
			for (double y : centerY) {
				if (iy == index) {
					SmartDashboard.putNumber("Y", y);
					if (y > centerYtarget) {
						Lift.getInstance().moveArm(ANGLE_SPEED);
					} else if (y < centerYtarget) {
						Lift.getInstance().moveArm(-ANGLE_SPEED);
					} else {
						Lift.getInstance().moveArm(0);
						isFinishedY = true;
					}
				}
				iy++;
			}
		}
		if (centerY.length == 0) {
			Lift.getInstance().moveArm(0);
			SmartDashboard.putNumber("Y", 0);
			isFinishedY = true;	
		}

	}

	@Override
	protected boolean isFinished() {
		if(isFinishedY&&isFinishedX){
			isFinished = true;
		}
		return isFinished;
	}

	@Override
	protected void end() {
		Lift.getInstance().moveArm(0);
		Drive.getInstance().driveTank(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
