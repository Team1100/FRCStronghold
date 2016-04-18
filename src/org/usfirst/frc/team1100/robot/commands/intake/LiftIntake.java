package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Used to move the intake manualy in auto. Don't use this.
 * Use "SetIntakeSetpoint" for PID support
 */
public class LiftIntake extends Command{

	private double timeout;
	private double value;

	public LiftIntake(double timeout, double value){
		this.timeout = timeout;
		this.value = value;
		setTimeout(timeout);
		requires(Intake.getInstance());
	}
	
	public LiftIntake(double value){
		this.value = value;
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Intake.getInstance().moveIntake(value);
		
	}

	@Override
	protected boolean isFinished() {
		if(timeout!=0)return isTimedOut();
		else return false;
	}

	@Override
	protected void end() {
		Intake.getInstance().moveIntake(0);
		
	}

	@Override
	protected void interrupted() {
		end();
		
	}

}
