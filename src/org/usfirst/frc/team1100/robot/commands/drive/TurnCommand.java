
package org.usfirst.frc.team1100.robot.commands.drive;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.DriveCAN;

import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class TurnCommand extends Command {

	private double leftSpeed, rightSpeed, targetAngle, startAngle;
	private double Epsilon = 0;//TODO: Test and find real value
	
    public TurnCommand(double angle) {
        requires(DriveCAN.getInstance());
        targetAngle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startAngle = DriveCAN.getInstance().getAngle();
    	rightSpeed = -.5;
    	leftSpeed = .5;
    	if(targetAngle<0){
    		targetAngle +=360;
    		rightSpeed = .5;
    		leftSpeed = -.5;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriveCAN.getInstance().driveTank(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return DriveCAN.getInstance().getAngle()-startAngle>targetAngle-Epsilon;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
