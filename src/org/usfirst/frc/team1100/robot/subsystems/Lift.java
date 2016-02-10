
package org.usfirst.frc.team1100.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *This is a blank class for subsystem with a basic format.
 */
public class Lift extends Subsystem {
    
    private static Lift Example;
    
    public static Lift getInstance(){
    	if(Example==null)
    		Example = new Lift();
    	return Example;
    }
    
    //list declarations.
    public Lift(){
    	//initialize components
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

