package org.usfirst.frc.team1100.robot.commands.arm;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UserMoveArm extends Command{

	/**
	 * Called by Lift as default. Joystick controls.
	 */
	public UserMoveArm(){
		requires(Arm.getInstance());
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(OI.getMethod()==0){
			Arm.getInstance().moveArm(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYLeft));		
		}
		else if(OI.getMethod()==1){
			double value;
			if(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kRightTrigger)!=0){
				value = OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kRightTrigger); 
			}
			else if(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kLeftTrigger)!=0){
				value = -OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kLeftTrigger);
			}else value = 0;
			Arm.getInstance().moveArm(value);
		}
		if(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kRightTrigger)!=0){
			//Arm.getInstance().brakeToggle();
			Arm.getInstance().setBrake(Arm.ON);
		}
		if(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kLeftTrigger)!=0){
			Arm.getInstance().setBrake(Arm.OFF);
		}
			
		SmartDashboard.putBoolean("Arm Brake", !Arm.getInstance().getBrake());
		SmartDashboard.putNumber("Arm Encoder", Arm.getInstance().getEncValue());
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