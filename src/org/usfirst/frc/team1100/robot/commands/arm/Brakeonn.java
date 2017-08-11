package org.usfirst.frc.team1100.robot.commands.arm;

import org.usfirst.frc.team1100.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class Brakeonn extends Command{

	public Brakeonn(){
		requires(Arm.getInstance());
	}
	boolean f;
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		f = false;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Arm.getInstance().setBrake(Arm.ON);
		f = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return f;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
