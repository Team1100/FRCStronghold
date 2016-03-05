package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the hook used to pull up the tower
 */
public class Climb extends Subsystem{
	
	private static Climb climb;/* CLIIIIIIMB */
	
	private SpeedController hookExtend1;
	private SpeedController hookExtend2;
	
	public static Climb getInstance(){
		if(climb==null)
			climb = new Climb();
		return climb;
	}

	public Climb(){
		hookExtend1 = new Victor(RobotMap.C_HOOK_EXTEND_MOTOR_1);
		hookExtend2 = new Victor(RobotMap.C_HOOK_EXTEND_MOTOR_2);
	}
	
	public void extendHook(double speed){
		hookExtend1.set(speed);
		hookExtend2.set(speed);
	}
	
	public void pullUp(double speed){
		hookExtend1.set(-speed);
		hookExtend2.set(-speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Climb controls
	}
}