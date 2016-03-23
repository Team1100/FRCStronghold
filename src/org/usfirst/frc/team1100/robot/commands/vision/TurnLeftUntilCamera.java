package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public class TurnLeftUntilCamera extends Command{

	private boolean isFinished;
	
	public TurnLeftUntilCamera(){
		requires(Drive.getInstance());
	}
	
	@Override
	protected void initialize() {
		if(Shooter.getInstance().isInAuto()&&!Shooter.getInstance().shootInAuto())
			this.cancel();
		isFinished = false;
	}

	@Override
	protected void execute() {
		Drive.getInstance().driveTank(-.6, .6);
		if(Vision.getInstance().getA()!=0) isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
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
