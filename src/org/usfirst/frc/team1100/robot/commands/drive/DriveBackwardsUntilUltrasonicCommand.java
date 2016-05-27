package org.usfirst.frc.team1100.robot.commands.drive;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Ultrasound;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackwardsUntilUltrasonicCommand extends Command {

	private boolean finished;
	private final double TARGET_VALUE;
	
    public DriveBackwardsUntilUltrasonicCommand() {
        requires(Drive.getInstance());
        requires(Ultrasound.getInstance());
        TARGET_VALUE = 410.0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Ultrasound.getInstance().getCurrentReading()<TARGET_VALUE)
    		Drive.getInstance().driveTank(-0.5, -0.5);
    	else
    		finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	new DriveCommand(0.4,0.4,0.25);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
