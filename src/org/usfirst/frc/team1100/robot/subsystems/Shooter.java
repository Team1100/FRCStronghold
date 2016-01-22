
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.shooter.AimShooterCommand;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	private Jaguar belts;
	private Jaguar fire1;
	private Jaguar fire2;
	private Jaguar height;
    
   private static Shooter Shooter;
   
   public static Shooter getInstance(){
	   if(Shooter==null)
		   Shooter = new Shooter();
	   return Shooter;
   }
   
   private Shooter(){
	   fire1 = new Jaguar(RobotMap.S_FIRE_1);
	   fire2 = new Jaguar(RobotMap.S_FIRE_2);
	   belts = new Jaguar(RobotMap.S_BELT);
	   height = new Jaguar(RobotMap.S_HEIGHT);
   }

   public void Shoot(double speed){
	   fire1.set(speed);//spin firing wheels
	   fire2.set(speed);
   }
   public void ChangeAngle(double speed) {
	   height.set(speed);
   }
   /**
    * @belt = belt
    * beltsssss of belt
    * @param speed of belt
    * belt belts belt belts
    */
   public void SpinBelt(double speed){
	   belts.set(speed);
   }
   
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new AimShooterCommand());
    }
}

