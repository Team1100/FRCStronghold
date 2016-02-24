package org.usfirst.frc.team1100.robot.commands.arm;

import org.usfirst.frc.team1100.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmToSetpoint extends Command{

	double pos;
	
	public ArmToSetpoint(double pos){
		requires(Lift.getInstance());
		this.pos = pos;
	}
	
	@Override
	protected void initialize() {
		setTimeout(2.5);
	}

	@Override
	protected void execute() {
		Lift.getInstance().setSetpoint(pos);
		Lift.getInstance().enable();
		SmartDashboard.putNumber("Arm Encoder", -Lift.getInstance().getEncValue());
		SmartDashboard.putNumber("Arm Pot.", Lift.getInstance().getPotentiometer());
		SmartDashboard.putBoolean("Arm OnTarget", isFinished());
	}

	@Override
	protected boolean isFinished() {
		return Lift.getInstance().onTarget()||isTimedOut();
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
