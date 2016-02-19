
package org.usfirst.frc.team1100.robot.commands.drive;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Used for autonomous driving command groups
 */
public class DriveCommand extends Command {

	private double left, right, time;
	/**
	 * Moves the robot for a period of time
	 * @param left - speed of left motor
	 * @param right - speed of right motor
	 * @param time - duration of movement in seconds
	 */
    public DriveCommand(double left, double right, double time) {
        requires(Drive.getInstance());
        this.left = left;
        this.right = right;
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drive.getInstance().driveTank(left, right);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	DriverStation.reportError("Drive Interrupted", false);
    }
}
