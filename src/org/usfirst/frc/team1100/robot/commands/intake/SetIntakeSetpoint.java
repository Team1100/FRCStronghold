package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class SetIntakeSetpoint extends Command{

	//Declare variables
	private double pos;
	private boolean isFinished;
	
	/**
	 * Moves the intake
	 * @param pos Desired setpoint from Intake
	 */
	public SetIntakeSetpoint(double pos){
		requires(Intake.getInstance());
		this.pos = pos;
	}
	
	//Set timeout to one second, initialize isFinished
	@Override
	protected void initialize() {
		isFinished = false;
		setTimeout(1);		
	}

	//Use PID to move to desired position
	@Override
	protected void execute() {
		Intake.getInstance().setPosition(pos);
		Intake.getInstance().enable();
	}

	//Ends the command when either the command times out
	//Or (in theory) it ends up within the tolerance/errors.
	@Override
	protected boolean isFinished() {
		if(isTimedOut())isFinished = true;
		if(Intake.getInstance().target())isFinished = true;
		return isFinished;
	}

	//Disables the PID and motor upon completion
	@Override
	protected void end() {
		Intake.getInstance().disable();
		Intake.getInstance().setLift(0);
	}

	//Ends the command if interrupted
	@Override
	protected void interrupted() {
		end();
	}

}