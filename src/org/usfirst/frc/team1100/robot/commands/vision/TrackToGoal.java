package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrackToGoal extends Command {

	private NetworkTable table;
	double[] defaultValue;

	private double initialY;
	private double finalY;
	private double deltaY;
	private double yToEncoderRatio;
	private double encoderTarget;
	private double encoderStart;
	private double encoderStart2;
	
	private final double ENCODER_DELTA = 0;
	
	private boolean isFinished;
	
	private boolean firstStageFinishedY;
	private boolean targetYCalculated;

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

		isFinished = false;
		firstStageFinishedY = false;
		targetYCalculated = false;
		
		double[] area = table.getNumberArray("area", defaultValue);
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		double[] centerY = table.getNumberArray("centerY", defaultValue);
		int index = 0;
		double max_area = 0;
		for (int i = 0; i < area.length; i++) {
			if (area[i] > max_area) {
				max_area = area[i];
				index = i;
			}
		}
		double x = centerX[index];
		double y = centerY[index];
		initialY = y;
		encoderStart = Lift.getInstance().getPosition();
		}

	@Override
	protected void execute() {
		if(!firstStageFinishedY){
			Lift.getInstance().setSetpoint(encoderStart+ENCODER_DELTA);
			Lift.getInstance().enable();
			if(Lift.getInstance().onTarget())
				firstStageFinishedY = true;
			Lift.getInstance().disable();
		}
		else if(firstStageFinishedY && !targetYCalculated){
			double[] area = table.getNumberArray("area", defaultValue);
			double[] centerY = table.getNumberArray("centerY", defaultValue);
			int index = 0;
			double max_area = 0;
			for (int i = 0; i < area.length; i++) {
				if (area[i] > max_area) {
					max_area = area[i];
					index = i;
				}
			}
			double y = centerY[index];
			finalY = y;
			deltaY = finalY-initialY;
			yToEncoderRatio = deltaY/ENCODER_DELTA;
			double yToMove = centerYtarget-finalY;
			encoderTarget = yToMove/yToEncoderRatio;
			encoderStart2 = Lift.getInstance().getPosition();
			targetYCalculated = true;
		}
		else if(targetYCalculated){
			Lift.getInstance().setSetpoint(encoderStart2+encoderTarget);
			Lift.getInstance().enable();
		}
		if(targetYCalculated&&Lift.getInstance().onTarget()){
			Lift.getInstance().disable();
			isFinished = true;
		}
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		Lift.getInstance().moveArm(0);
		Lift.getInstance().disable();
		Drive.getInstance().driveTank(0, 0);
		Drive.getInstance().disable();
	}

	@Override
	protected void interrupted() {
		end();
	}

}