package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.arm.led.LeadLoop;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LED extends Subsystem {
    
	private static LED instance;
	
	private Solenoid ledRedBack;
	private Solenoid ledBlueBack;
	private Solenoid ledGreenBack;
	private Solenoid ledRedEye;
	private Solenoid ledGreenEye;
	private Solenoid ledBlueEye;

    
    public LED(){
    	ledRedBack = new Solenoid(RobotMap.L_PCM, RobotMap.L_RED);
		ledGreenBack = new Solenoid(RobotMap.L_PCM, RobotMap.L_GREEN);
		ledBlueBack = new Solenoid(RobotMap.L_PCM, RobotMap.L_BLUE);
		ledRedEye = new Solenoid(RobotMap.L_PCM, RobotMap.L_EYE_RED);
		ledGreenEye = new Solenoid(RobotMap.L_PCM, RobotMap.L_EYE_GREEN);
		ledBlueEye = new Solenoid(RobotMap.L_PCM, RobotMap.L_EYE_BLUE);
    }
    
    public static LED getInstance() {
    	if(instance==null)
    		instance = new LED();
    	return instance;
    }
    
    public void initDefaultCommand() {
		setDefaultCommand(new LeadLoop());
	}
    
    public void tRed(){
		ledRedBack.set(!ledRedBack.get());
		ledRedEye.set(!ledRedEye.get());
	}
	public void tBlue(){
		ledBlueBack.set(!ledBlueBack.get());
		ledBlueEye.set(!ledBlueEye.get());
	}
	public void tGreen(){
		ledGreenBack.set(!ledGreenBack.get());
		ledGreenEye.set(!ledGreenEye.get());
	}
	public void setRed(boolean b) {
		ledRedBack.set(b);
		ledRedEye.set(b);
	}
	public void setBlue(boolean b) {
		ledBlueBack.set(b);
		ledBlueEye.set(b);
	}
	public void setGreen(boolean b) {
		ledGreenBack.set(b);
		ledGreenEye.set(b);
	}
	
	public void setRGB(boolean red, boolean green, boolean blue){
		setRed(red);
		setBlue(blue);
		setGreen(green);
	}
}

