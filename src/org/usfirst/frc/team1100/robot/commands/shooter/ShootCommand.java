
package org.usfirst.frc.team1100.robot.commands.shooter;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCommand extends Command {
	private double speed;
	private double s;
    public ShootCommand(double speed) {
       requires(Shooter.getInstance());
       this.speed = speed;
       s = .01;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(s<speed)s+=.01;
    	Shooter.getInstance().shoot(s);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Shooter.getInstance().shoot(0);
    	s = 0;
    	speed = 0;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
