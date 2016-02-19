
package org.usfirst.frc.team1100.robot.commands.drive;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
/**
 *Turns robot in autonomous command groups
 */
public class TurnCommand extends Command {

	private double targetAngle;
	/**
	 * Turns the robot a set angle using PID
	 * @param angle robot will drive to this angle
	 */
    public TurnCommand(double angle) {
        requires(Drive.getInstance());
        targetAngle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drive.getInstance().setSetpoint(targetAngle);
    	Drive.getInstance().enable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Drive.getInstance().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Drive.getInstance().driveTank(0, 0);
    	Drive.getInstance().disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
