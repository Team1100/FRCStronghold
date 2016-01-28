
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
	
	private final double PIXELS_TO_MM = 32512;
	private final double COOKIE_WIDTH_MM = 69;
	private final double IMAGE_DISTANCE_MM = 5.29517356;
	
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
    	double[] area = table.getNumberArray("area", defaultValue);
    	int index = 0;
    	double max_area = 0;
    	for(int i = 0; i <area.length; i++){
    		if(area[i]>max_area){
    			max_area = area[i];
    			index = i;
    		}
    	}
    	
    	double[] centerX  =table.getNumberArray("centerX", defaultValue);
    	int ix = 0;
    	for(double x :centerX){
    		if(ix == index){
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
    		ix++;
    	}
    	if(centerX.length==0)Drive.getInstance().driveTank(0, 0);
    	
    	double[] centerY = table.getNumberArray("centerY", defaultValue);
    	int iy = 0;
    	for(double y : centerY){
    		if(iy==index){
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
    		iy++;
    	}
    	if(centerY.length==0)Shooter.getInstance().ChangeAngle(0);
    	
    	double[] widthList = table.getNumberArray("width", defaultValue);
    	double width = 0;
    	for(int i = 0; i<widthList.length; i++){
    		if(i==index)width = widthList[i];
    	}
    	SmartDashboard.putNumber("Distance_Vector", distance(width));
    	SmartDashboard.putNumber("Width_in_Pixels", width);
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
    
    private double distance(double width){
    	if(width==0)return 0;
    	double imageWidth = width/PIXELS_TO_MM;
    	double ratio =  COOKIE_WIDTH_MM/imageWidth;
    	double distance = IMAGE_DISTANCE_MM * ratio;
    	return distance;
    }
}
