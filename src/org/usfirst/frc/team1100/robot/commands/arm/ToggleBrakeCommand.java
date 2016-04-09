package org.usfirst.frc.team1100.robot.commands.arm;

import org.usfirst.frc.team1100.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleBrakeCommand extends Command{

	private boolean isFinished;
	
	public ToggleBrakeCommand(){
		requires(Arm.getInstance());
	}
	
	@Override
	protected void initialize() {
		isFinished = false;
	}

	@Override
	protected void execute() {
		Arm.getInstance().brakeToggle();
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFinished;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
