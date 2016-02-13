
package org.usfirst.frc.team1100.robot.commands.shooter;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserAimShooterCommand extends Command {

	//private double speed;
    public UserAimShooterCommand(/*double speed*/) {
        requires(Shooter.getInstance());
        //this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Shooter.getInstance().ChangeAngle(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYLeft));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
