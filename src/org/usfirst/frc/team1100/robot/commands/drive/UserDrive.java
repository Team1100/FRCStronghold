
package org.usfirst.frc.team1100.robot.commands.drive;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	double left, right;
    	if(OI.getMethod()==0||OI.getMethod()==2){
    		left = OI.getInstance().getLeftStick().getAxis(Joystick.AxisType.kY);
        	right = OI.getInstance().getRightStick().getAxis(Joystick.AxisType.kY);
    	}
    	else if(OI.getMethod()==1){
    		left = OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYLeft);
    		right = OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYRight);
    	}
    	else{
    		left = 0;
    		right = 0;
    	}
 
    	Drive.getInstance().driveTank(left, right);
    	
    	SmartDashboard.putNumber("Gyro", Drive.getInstance().getAngle());
    	
    	double jumpingJacks1 = OI.getInstance().getRightStick().getAxis(Joystick.AxisType.kX);
    	double jumpingJacks2 = OI.getInstance().getLeftStick().getAxis(Joystick.AxisType.kX);
    	if(jumpingJacks1*jumpingJacks2<0.0) {
    		SmartDashboard.putString("Jumping Jacks?", "Jumping Jacks Activated");
    	} else {
    		SmartDashboard.putString("Jumping Jacks?", "Jumping Jacks Deactivated");
    	}
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