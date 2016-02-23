package org.usfirst.frc.team1100.robot.commands.drive;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command{

	private final double kp = .03; 
	private double speed;
	private double timeout;
	
	public DriveStraight(double speed, double timeout){
		requires(Drive.getInstance());
		this.speed = speed;
		this.timeout = timeout;
	}
	
	@Override
	protected void initialize() {
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
		double angle = Drive.getInstance().getAngle();
		Drive.getInstance().driveAngle(speed, angle*kp);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Drive.getInstance().stop();
	}

	@Override
	protected void interrupted() {
		end();		
	}
}