package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the hook used to pull up the tower
 */
public class Climb extends Subsystem{
	
	private static Climb climb;
	
	private SpeedController hookExtender;
	
	public static Climb getInstance(){
		if(climb==null)
			climb = new Climb();
		return climb;
	}

	public Climb(){
		hookExtender = new Talon(RobotMap.C_HOOK_EXTEND_MOTOR);//TODO: find out actual controller
	}
	
	public void extendHook(double speed){
		hookExtender.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO : User Climb? (if this is a joystick, otherwise delete this msg)
		
	}

}
