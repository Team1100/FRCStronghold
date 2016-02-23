package org.usfirst.frc.team1100.robot.commands.drive;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleDirection extends Command{

	private boolean isFinished;
	
	public ToggleDirection(){
		requires(Drive.getInstance());
	}
	
	@Override
	protected void initialize() {
		isFinished = false;
		
	}

	@Override
	protected void execute() {
		Drive.getInstance().toggleDriveReverse();
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
		end();
	}

}
