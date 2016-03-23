package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Lifts the intake with joystick.
 */
public class UserLiftIntake extends Command{

	double value;
	
	/**
	 * Moves the intake with the joystick. Also listens to the ballIn sensor
	 */
	public UserLiftIntake(){
		requires(Intake.getInstance());
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Intake Analog", Intake.getInstance().getAnalog());
		value = OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYRight);
		Intake.getInstance().setLift(value);
		/*if(Intake.getInstance().ballIn()&&Intake.getInstance().rollersOn()){
			Intake.getInstance().toggleRollers();
		}*///TODO
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
