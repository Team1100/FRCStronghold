package org.usfirst.frc.team1100.robot.commands.shooter;

import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class SetKickerCommand extends Command{

	private Value value;
	private boolean isFinished = false;
	
	public SetKickerCommand(Value value){
		requires(Shooter.getInstance());
		this.value = value;
	}
	
	@Override
	protected void initialize() {
		
		
	}

	@Override
	protected void execute() {
		Shooter.getInstance().setKicker(value);
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFinished;
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