package org.usfirst.frc.team1100.robot.commands.shooter;

import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class SetFillCommand extends Command{

	private Value value;
	private boolean isFinished = false;
	/**
	 * Sets the piston to a position
	 * @param value use Value.position
	 */
	public SetFillCommand(Value value){
		requires(Shooter.getInstance());
		this.value = value;
	}
	
	@Override
	protected void initialize() {
		
		
	}

	@Override
	protected void execute() {
		Shooter.getInstance().setFill(value);
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		
		
	}

	@Override
	protected void interrupted() {
		
		
	}

}
