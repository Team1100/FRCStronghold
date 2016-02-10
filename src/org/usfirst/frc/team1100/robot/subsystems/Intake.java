
package org.usfirst.frc.team1100.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Controls the roller that pulls the boulders into the kicker 
 */
public class Intake extends Subsystem {
    
	private static Intake intake;
	
    public static Intake getInstance(){
    	if(intake==null)
    		intake = new Intake();
    	return intake;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

