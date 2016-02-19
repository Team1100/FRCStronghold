package org.usfirst.frc.team1100.robot.commands.shooter.arm;

import org.usfirst.frc.team1100.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;
//#include <apstring.h>
public class MoveArmCommand extends Command{

	double value;
	double timeout;
	
	public MoveArmCommand(double value, double timeout){
		requires(Lift.getInstance());
		this.value = value;
		this.timeout = timeout;
	}
	
	@Override
	protected void initialize() {
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
		Lift.getInstance().moveArm(value);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Lift.getInstance().moveArm(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
