package org.usfirst.frc.team1100.robot.commands.arm;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Lift;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UserMoveArm extends Command{

	/**
	 * Called by Lift as default. Joystick controls.
	 */
	public UserMoveArm(){
		requires(Lift.getInstance());
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Lift.getInstance().moveArm(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYLeft));		
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