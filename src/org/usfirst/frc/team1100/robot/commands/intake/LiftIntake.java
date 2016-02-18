package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class LiftIntake extends Command{

	double timeout;
	double value;


	public LiftIntake(double timeout, double value){
		this.timeout = timeout;
		this.value = value;
		
		requires(Intake.getInstance());
	}
	
	@Override
	protected void initialize() {
		setTimeout(timeout);
		
	}

	@Override
	protected void execute() {
		Intake.getInstance().setLift(value);
		
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Intake.getInstance().setLift(0);
		
	}

	@Override
	protected void interrupted() {
		end();
		
	}

}
