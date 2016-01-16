
package org.usfirst.frc.team1100.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *This is a blank class for subsystem with a basic format.
 */
public class Example extends Subsystem {
    
    private Example Example;
    
    public Example getInstance(){
    	if(Example==null)
    		Example = new Example();
    	return Example;
    }
    
    //list declarations.
    public Example(){
    	//initialize components
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

