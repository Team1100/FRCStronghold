
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.intake.UserLiftIntake;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Controls the roller that pulls the boulders into the kicker 
 */
public class Intake extends Subsystem {
    
	private static Intake intake;
	
	private SpeedController roller;
	private SpeedController lift;
	private boolean rollers;
	
    public static Intake getInstance(){
    	if(intake==null)
    		intake = new Intake();
    	return intake;
    }

    public Intake(){
    	roller = new Talon(RobotMap.I_INTAKE_ROLLER);
    	lift = new Talon(RobotMap.I_INTAKE_LIFT);
    }
    
    public void moveLift(double value){
    	lift.set(value);
    }
    
    public void moveRoller(double value){
    	if(OI.getInstance().getPeasant().getButtonLeftBumper().get())
    		value = -value;
    	roller.set(value);
    }
    
    public void initDefaultCommand() {
       setDefaultCommand(new UserLiftIntake());
    }
    
    public void toggleRollers(){
    	if(rollers)
    		roller.set(-.5);
    	else roller.set(0);
    	rollers = !rollers;
    }
}

