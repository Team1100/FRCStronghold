//#include <apstring.h>
//TODO:xtrack testing(prayer)
//TODO:test auto
package org.usfirst.frc.team1100.robot;

import java.io.IOException;

import org.usfirst.frc.team1100.robot.commands.auto.DriveBackLeft;
import org.usfirst.frc.team1100.robot.commands.auto.DriveBackRight;
import org.usfirst.frc.team1100.robot.commands.auto.DriveForwardLeft;
import org.usfirst.frc.team1100.robot.commands.auto.DriveForwardRight;
import org.usfirst.frc.team1100.robot.commands.auto.DriveStraightBackward;
import org.usfirst.frc.team1100.robot.commands.auto.DriveStraightForward;
import org.usfirst.frc.team1100.robot.commands.auto.LowBarAuto;
import org.usfirst.frc.team1100.robot.subsystems.Climb;
import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Intake;
import org.usfirst.frc.team1100.robot.subsystems.Lift;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;
import org.usfirst.frc.team1100.robot.subsystems.Ultrasound;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	/*try {
            new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    	//Initialize Subsystems and OI
		OI.getInstance();
		Drive.getInstance();
		Intake.getInstance();
		Shooter.getInstance();
		Lift.getInstance();
		Ultrasound.getInstance();
		Climb.getInstance();
		Vision.getInstance();
		
		//TODO:enable auto chooser
		/*autoChuse= new SendableChooser();
		autoChuse.addObject("Low Bar", new LowBarAuto());
		autoChuse.addObject("Backwards Defense, Left of Goal", new DriveBackLeft());
		autoChuse.addObject("Backwards Defense, Right of Goal", new DriveBackRight());
		autoChuse.addObject("Forwards Defense, Left of Goal", new DriveForwardLeft());
		autoChuse.addObject("Forwards Defense, Right of Goal", new DriveForwardRight());
		autoChuse.addObject("Forwards Defense, Straight Ahead", new DriveStraightForward());
		autoChuse.addObject("Backwards Defense, Straight Ahead", new DriveStraightBackward());
		SmartDashboard.putData("AutoThomas", autoChuse);*/
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        //autonomousCommand = (Command)autoChuse.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
        try {
			new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
    	Lift.getInstance().disable();
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
