package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class UserLiftIntake extends Command{

	double value;
	
	public UserLiftIntake(){
		requires(Intake.getInstance());
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		value = OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYLeft);
		Intake.getInstance().moveLift(value);
		if(Intake.getInstance().ballIn()&&Intake.getInstance().rollersOn()){
			Intake.getInstance().toggleRollers();
		}
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
