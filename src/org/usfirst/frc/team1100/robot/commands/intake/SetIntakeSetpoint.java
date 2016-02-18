package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetIntakeSetpoint extends Command{

	private double pos;
	private boolean isFinished;
	
	public SetIntakeSetpoint(double pos){
		requires(Intake.getInstance());
		this.pos = pos;
	}
	
	@Override
	protected void initialize() {
		isFinished = false;
		setTimeout(1);		
	}

	@Override
	protected void execute() {
		SmartDashboard.putString("Command", "yeas");
		Intake.getInstance().setPosition(pos);
		Intake.getInstance().enable();
				
		SmartDashboard.putBoolean("On target", Intake.getInstance().target());
		SmartDashboard.putNumber("Motor speed", Intake.getInstance().getLiftSpeed());
		SmartDashboard.putNumber("Potentiometer", Intake.getInstance().getAnalog());
	}

	@Override
	protected boolean isFinished() {
		if(isTimedOut())isFinished = true;
		if(Intake.getInstance().target())isFinished = true;
		return isFinished;
	}

	@Override
	protected void end() {
		Intake.getInstance().disable();
	}

	@Override
	protected void interrupted() {
		end();
	}

}