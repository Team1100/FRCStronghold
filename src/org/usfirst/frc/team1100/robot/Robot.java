
package org.usfirst.frc.team1100.robot;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Intake;
import org.usfirst.frc.team1100.robot.subsystems.Lift;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;
import org.usfirst.frc.team1100.robot.subsystems.Ultrasound;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
    
    public void robotInit() {
    	//Initialize Subsystems and OI
		OI.getInstance();
		Drive.getInstance();
		Intake.getInstance();
		Shooter.getInstance();
		Lift.getInstance();
		Ultrasound.getInstance();
		//TODO: add Climb
		
		/*autoChuse= new SendableChooser();
		autoChuse.addObject("Low Bar", new LowBarAuto());
		//TODO: add rest. make it work
		
		SmartDashboard.putData("AutoThomas", autoChuse);*/
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        //autonomousCommand = (Command)autoChuse.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
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
        LiveWindow.run();
    }
}
