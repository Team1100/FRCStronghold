package org.usfirst.frc.team1100.robot.commands.arm;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class UserMoveArm extends Command{

	/**
	 * Called by Lift as default. Joystick controls.
	 */
	public UserMoveArm(){
		requires(Arm.getInstance());
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Arm.getInstance().moveArm(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYLeft));		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}
}