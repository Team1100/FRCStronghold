//#include <apstring.h>
package org.usfirst.frc.team1100.robot;

import org.usfirst.frc.team1100.robot.commands.auto.DriveStraightBackward;
import org.usfirst.frc.team1100.robot.commands.auto.HighGoalTurnAuto;
import org.usfirst.frc.team1100.robot.subsystems.Arm;
import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Intake;
import org.usfirst.frc.team1100.robot.subsystems.LED;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;
import org.usfirst.frc.team1100.robot.subsystems.Ultrasound;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    private SendableChooser autoChuse;
    private SendableChooser fireInAutoChoose;
    
    public void robotInit() {
    	//Initialize Subsystems and OI
		OI.getInstance();
		Drive.getInstance();
		Intake.getInstance();
		Shooter.getInstance();
		Arm.getInstance();
		Ultrasound.getInstance();
		LED.getInstance();
		//Climb.getInstance();
		//Vision.getInstance();
		
		//USB Camera Initialization
		CameraServer server = CameraServer.getInstance();
		server.setQuality(40);
		server.startAutomaticCapture("cam2");
		
//		autoChuse= new SendableChooser();
//		autoChuse.addDefault("Low Bar", new LowBarAuto());
//		autoChuse.addObject("Forwards Defense", new DriveStraightForward());
//		autoChuse.addObject("Backwards Defense", new DriveStraightBackward());
//		autoChuse.addObject("SpyBot-Fires boulder", new SpyBotFire());
//		autoChuse.addObject("Portcullis Auto -- Experimental", new PortcullisAuto());
//		autoChuse.addObject("Low Bar then Low Fire", new LowShootLowBarAuto());
//		SmartDashboard.putData("AutoThomas", autoChuse);
		
		/*
		fireInAutoChoose = new SendableChooser();
		fireInAutoChoose.addObject("Fire at end of auto", new SetFireAuto(true));
		fireInAutoChoose.addObject("Do not fire at end of auto", new SetFireAuto(false));
		SmartDashboard.putData("Fire in Auto", fireInAutoChoose);
		*/
    	
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
		autonomousCommand=new HighGoalTurnAuto();
		if(!Drive.getInstance().getAutoS()){
			autonomousCommand=new DriveStraightBackward();
		}
		//autonomousCommand=new HighGoalAuto();
		
    	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	//Shooter.getInstance().setInAuto(false);
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    }
}
