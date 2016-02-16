package org.usfirst.frc.team1100.robot.commands.shooter.arm;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class UserMoveArm extends Command{

	public UserMoveArm(){
		requires(Shooter.getInstance());
	}
	
	@Override
	protected void initialize() {
		
		
	}

	@Override
	protected void execute() {
		Shooter.getInstance().moveArm(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYRight));		
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
