package org.usfirst.frc.team1100.robot.commands;

import java.util.ArrayList;
import java.util.Collections;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class StayAlongSide extends Command {

	double sampleSize = 100;
	double left = .4;
	double right = .4;
	

	public StayAlongSide() {
		requires(Drive.getInstance());
	}

	ArrayList<Double> data3 = new ArrayList<Double>();
	double distanceRight = 0;

	// Called just before this Command runs the first time
	protected void initialize() {
		Drive.getInstance().driveTank(.4, .4);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Drive.getInstance().driveTank(left, right);
		data3.add((double) Drive.getInstance().getEZ3());
		if (data3.size() == sampleSize) {
			Collections.sort(data3);
			double value3 = getMode(data3);
			distanceRight = distanceMZ3(value3);
			SmartDashboard.putNumber("Right", distanceRight);
			data3.clear();
			SmartDashboard.putNumber("Distance", distanceRight);
			if(Math.abs(distanceRight-48)>=5){
				if(distanceRight>48){
					left = .6;
					right = .4;
					System.out.println("Turning to the right, distance = "+distanceRight);
				}
				if(distanceRight<48){
					left = .4;
					right = .6;
					System.out.println("Turning to the left, distance = "+distanceRight);
				}
			}else{
				left = .4;
				right = .4;
			}
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
	}
	
	private double distanceMZ3(double value){
		return .129*value + 2.494; 
	}
	public double getMode(ArrayList<Double> list){
		double x = 0;
		double y = 0;
		double count = 0;
		double maxCount = 0;
		int index = 0;
		for(int i = 0; i< list.size(); i++){
			x = list.get(i);
			if(x==y){
				count++;
			}
			else{
				if(count>maxCount){
					maxCount=count;
					index = i-1;
				}
				count = 0;
				y=x;
			}
		}
		return list.get(index);
	}
}
