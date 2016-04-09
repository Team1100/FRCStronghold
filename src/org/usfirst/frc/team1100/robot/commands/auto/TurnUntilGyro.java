package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnUntilGyro extends Command {

	boolean finished;
	
    public TurnUntilGyro(double changeAngle) {
        requires(Drive.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double gyroNumber = Drive.getInstance().getAngle();
	    if(90<gyroNumber-10) {
	    	Drive.getInstance().driveTank(0, Drive.PORTCULLIS_SPEED);
	    } else if(90>gyroNumber+10) {
	    	Drive.getInstance().driveTank(Drive.PORTCULLIS_SPEED, 0);
	    } else {
	    	finished = true;
	    }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Drive.getInstance().driveTank(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
