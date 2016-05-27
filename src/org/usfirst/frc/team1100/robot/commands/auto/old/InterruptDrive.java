package org.usfirst.frc.team1100.robot.commands.auto.old;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class InterruptDrive extends Command {

    public InterruptDrive() {
        requires(Drive.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Nothing
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Really, nothing to see here
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Well there is nothing to do
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Why are you interrupting the interrupt command!?!?
    }
}
