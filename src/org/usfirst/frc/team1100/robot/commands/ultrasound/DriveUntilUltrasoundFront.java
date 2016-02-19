package org.usfirst.frc.team1100.robot.commands.ultrasound;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Ultrasound;

import edu.wpi.first.wpilibj.command.Command;

public class DriveUntilUltrasoundFront extends Command{

	private double distance;
	private double left;
	private double right;
	
	private boolean isFinished;
	
	/**
	 * Drives until the ultrasonic returns a value within distance
	 * @param distance the distance in inches we should be going until
	 * @param left Speed of left motor
	 * @param right Speed of right motor
	 */
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