package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleRollerCommand extends Command{

	private boolean isDone;
	
	public ToggleRollerCommand(){
		requires(Intake.getInstance());
	}
	
	@Override
	protected void initialize() {
		isDone = false;
	}

	@Override
	protected void execute() {
		Intake.getInstance().toggleRollers();
		isDone = true;
	}

	@Override
	protected boolean isFinished() {
		return isDone;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
	
	}

}
