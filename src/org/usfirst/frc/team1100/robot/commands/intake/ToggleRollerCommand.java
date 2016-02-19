package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles the intake rollers
 *
 */
public class ToggleRollerCommand extends Command{

	//Declare isDone boolean
	private boolean isDone;
	
	/**
	 * Toggles the roller wheels on or off
	 */
	public ToggleRollerCommand(){
		requires(Intake.getInstance());
	}
	
	//Set isDone to false at start
	@Override
	protected void initialize() {
		isDone = false;
	}

	//Toggle rollers, then end command
	@Override
	protected void execute() {
		Intake.getInstance().toggleRollers();
		isDone = true;
	}

	//Checks for when command is complete
	@Override
	protected boolean isFinished() {
		return isDone;
	}

	//Called at end, empty
	@Override
	protected void end() {
	}

	//Called if interrupted, empty
	@Override
	protected void interrupted() {
	}
}