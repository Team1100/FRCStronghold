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
		
	}

	@Override
	protected void execute() {
		//Intake.getInstance().moveLift(.2);
		SmartDashboard.putNumber("Analog", Intake.getInstance().getAnalog());
		Intake.getInstance().setPosition(pos);
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