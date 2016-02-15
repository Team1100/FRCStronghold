package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class TurnRollers extends Command{

	double value;
	
	public TurnRollers(double value){
		requires(Intake.getInstance());
		this.value = value;
	}
	
	@Override
	protected void initialize() {
				
	}

	@Override
	protected void execute() {
		Intake.getInstance().moveRoller(value);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		Intake.getInstance().moveRoller(0);
		
	}

	@Override
	protected void interrupted() {
		end();
	}

}
