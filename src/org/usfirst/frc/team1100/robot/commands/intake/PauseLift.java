package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class PauseLift extends Command{

	public PauseLift(){
		requires(Intake.getInstance());
	}
	
	@Override
	protected void initialize() {
		setTimeout(.5);
	}

	@Override
	protected void execute() {
		Intake.getInstance().blindDrive(0);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
		
	}
	
}
