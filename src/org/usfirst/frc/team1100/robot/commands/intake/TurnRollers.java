package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;
/**
 * Command for turning the intake rollers
 */
public class TurnRollers extends Command{
	double value;
	
	/**
	 * Turns the rollers (not a toggle)
	 * @param speed of rollers (negative for backwards)
	 */
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
