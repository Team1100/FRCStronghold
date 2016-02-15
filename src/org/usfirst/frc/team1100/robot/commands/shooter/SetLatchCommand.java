package org.usfirst.frc.team1100.robot.commands.shooter;

import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class SetLatchCommand extends Command{
	
	private boolean isFinished = false;
	
	Value value;
	
	public SetLatchCommand(Value value){
		System.out.println("Test");
		requires(Shooter.getInstance());
		this.value = value;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		System.out.println("Executing");
		Shooter.getInstance().setLatch(value);
		System.out.println("Command called: setting latch to " + value.toString() + " actual " + Shooter.getInstance().getLatchValue());
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
