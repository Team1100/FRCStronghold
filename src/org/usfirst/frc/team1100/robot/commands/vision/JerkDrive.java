package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public class JerkDrive extends Command{
	
	private boolean right;
	private boolean isDone;
	private final double target = 130;
	
	
	public JerkDrive() {
		requires(Drive.getInstance());
	}
	
	@Override
	protected void initialize() {
		double x = Vision.getInstance().getX();
		if(x>target){
			right = false;
		}
		if(x<target){
			right = true;
		}
	}

	@Override
	protected void execute() {
		double x = Vision.getInstance().getX();
		//See if we are at the center yet...
		if(x<target+2&&x>target-2)
			isDone = true;
		right = x < target; //It's the same as the if statement in the init
		if(right){
			Drive.getInstance().driveTank(-.7, .7);
		}
		else if(!right){
			Drive.getInstance().driveTank(.7, -.7);
		}
	}

	@Override
	protected boolean isFinished() {
		return isDone;
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
