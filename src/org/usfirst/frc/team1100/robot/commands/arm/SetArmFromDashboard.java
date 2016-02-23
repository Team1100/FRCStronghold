package org.usfirst.frc.team1100.robot.commands.arm;

import org.usfirst.frc.team1100.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetArmFromDashboard extends Command{
	
	public SetArmFromDashboard(){
		requires(Lift.getInstance());
	}
	
	@Override
	protected void initialize() {
		SmartDashboard.putNumber("Set Arm Location", Lift.getInstance().getPosition());
	}

	@Override
	protected void execute() {
		
		Lift.getInstance().setSetpoint(SmartDashboard.getNumber("Set Arm Location", Lift.getInstance().getPosition()));
		Lift.getInstance().enable();
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Lift.getInstance().disable();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
