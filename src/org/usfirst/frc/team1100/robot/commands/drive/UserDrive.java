
package org.usfirst.frc.team1100.robot.commands.drive;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Drive called continuously by the Drive subsystem, for joysticks
 */
public class UserDrive extends Command {

	
    public UserDrive() {
        requires(Drive.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double left = OI.getInstance().getLeftStick().getAxis(Joystick.AxisType.kY);
    	double right = OI.getInstance().getRightStick().getAxis(Joystick.AxisType.kY);
    	if(Drive.getInstance().isReversed()){
    		left = -left;
    		right = -right;
    	}
    	//left = OI.getInstance().getPeasant2().getAxis(org.usfirst.frc.team1100.robot.input.XboxController.XboxAxis.kYLeft);
    	//right = OI.getInstance().getPeasant2().getAxis(org.usfirst.frc.team1100.robot.input.XboxController.XboxAxis.kYRight);
    	Drive.getInstance().driveTank(left, right);
    	//SmartDashboard.putNumber("Gyro", Drive.getInstance().getAngle());
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
    	end();
    }
}