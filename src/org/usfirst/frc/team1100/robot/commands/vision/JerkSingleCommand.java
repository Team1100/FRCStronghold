package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JerkSingleCommand extends Command {
	
	private double direction, left, right;
	
    public JerkSingleCommand(double direction) {
    	requires(Drive.getInstance());
    	this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(.5);
    	//right = (.6*direction)*-1;
    	//left = .6*direction;
    	if(direction<0.0){
    		left = .6;
    		right = -.6;
    	} else if(direction>0.0){
    		left = -.6;
    		right = .6;
    	}
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
    	Drive.getInstance().driveTank(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
