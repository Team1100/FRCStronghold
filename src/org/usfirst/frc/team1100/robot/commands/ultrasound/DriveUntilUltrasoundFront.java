package org.usfirst.frc.team1100.robot.commands.ultrasound;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Ultrasound;

import edu.wpi.first.wpilibj.command.Command;

public class DriveUntilUltrasoundFront extends Command{

	private double distance;
	private double left;
	private double right;
	
	private boolean isFinished;
	
	public DriveUntilUltrasoundFront(double distance, double left, double right){
		requires(Drive.getInstance());
		
		this.distance = distance;
		this.left = left;
		this.right = right;
	}
	
	@Override
	protected void initialize() {
		isFinished = false;
	}

	@Override
	protected void execute() {
		Drive.getInstance().driveTank(left, right);
		if(Ultrasound.getInstance().getEZ3Distance()<=distance){
			isFinished = true;
			Drive.getInstance().driveTank(0, 0);
		}
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		Drive.getInstance().driveTank(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}
	
}