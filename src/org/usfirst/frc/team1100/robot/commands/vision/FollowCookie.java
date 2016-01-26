
package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FollowCookie extends Command {
	private final double ANGLE_SPEED = .4;
	private final double DRIVE_SPEED = .5;
	private NetworkTable table;
	double[] defaultValue;
    public FollowCookie() {
        requires(Drive.getInstance());
        requires(Shooter.getInstance());
        table = NetworkTable.getTable("GRIP/myContoursReport");
        defaultValue = new double[0];
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double[] centerX  =table.getNumberArray("centerX", defaultValue);
    	for(double x : centerX){
    		SmartDashboard.putNumber("X", x);
    		if(x<152.5){
    			Drive.getInstance().driveTank(-DRIVE_SPEED, DRIVE_SPEED);
    		}
    		else if(x>167.5){
    			Drive.getInstance().driveTank(DRIVE_SPEED, -DRIVE_SPEED);
    		}
    		else{
    			Drive.getInstance().driveTank(0, 0);
    		}
    	}
    	if(centerX.length==0)Drive.getInstance().driveTank(0, 0);
    	double[] centerY = table.getNumberArray("centerY", defaultValue);
    	for (double y : centerY){
    		SmartDashboard.putNumber("Y", y);
    		if(y>112.5){
    			Shooter.getInstance().ChangeAngle(ANGLE_SPEED);
    		}
    		else if(y<127.5){
    			Shooter.getInstance().ChangeAngle(-ANGLE_SPEED);
    		}
    		else{
    			Shooter.getInstance().ChangeAngle(0);
    		}
    	}
    	if(centerY.length==0)Shooter.getInstance().ChangeAngle(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Shooter.getInstance().ChangeAngle(0);
    	Drive.getInstance().driveTank(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
