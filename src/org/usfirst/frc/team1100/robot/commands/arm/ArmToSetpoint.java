package org.usfirst.frc.team1100.robot.commands.arm;

import org.usfirst.frc.team1100.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class ArmToSetpoint extends Command{

	double pos;
	
	public ArmToSetpoint(double pos){
		requires(Arm.getInstance());
		this.pos = pos;
	}
	
	@Override
	protected void initialize() {
		setTimeout(2.5);
	}

	@Override
	protected void execute() {
		Arm.getInstance().setSetpoint(pos);
		Arm.getInstance().enable();
	}

	@Override
	protected boolean isFinished() {
		return Arm.getInstance().onTarget()||isTimedOut();
	}

	@Override
	protected void end() {
		Arm.getInstance().disable();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
