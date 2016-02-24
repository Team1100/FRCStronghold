package org.usfirst.frc.team1100.robot.commands.arm;

import org.usfirst.frc.team1100.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

public class SetArmSetpoint extends Command{

	private double pos;
	
	public SetArmSetpoint(double pos){
		requires(Lift.getInstance());
		this.pos = pos;
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Lift.getInstance().setSetpoint(pos);
		Lift.getInstance().enable();
	}

	@Override
	protected boolean isFinished() {
		return Lift.getInstance().onTarget();
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
