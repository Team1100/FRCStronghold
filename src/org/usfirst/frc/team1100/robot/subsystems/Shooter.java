
package org.usfirst.frc.team1100.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Uses pneumatics to kick boulders into enemy towers
 */
public class Shooter extends Subsystem {
    
   private static Shooter shooter;
   
   private Solenoid kicker;
   private DoubleSolenoid latch;
   private DoubleSolenoid reset;
   
   public static Shooter getInstance(){
	   if(shooter==null)
		   shooter = new Shooter();
	   return shooter;
   }
   
   

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

