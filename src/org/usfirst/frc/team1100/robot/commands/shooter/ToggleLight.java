package org.usfirst.frc.team1100.robot.commands.shooter;

import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleLight extends Command{

	private boolean isFinished;
	
	public ToggleLight(){
		requires(Shooter.getInstance());
	}
	
	@Override
	protected void initialize() {
		isFinished = false;
	}

	@Override
	protected void execute() {
		Shooter.getInstance().toggleLight();
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
