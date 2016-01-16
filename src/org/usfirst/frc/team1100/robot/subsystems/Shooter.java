
package org.usfirst.frc.team1100.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
   private Shooter Shooter;
   
   public Shooter getInstance(){
	   if(Shooter==null)
		   Shooter = new Shooter();
	   return Shooter;
   }
   
   

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

