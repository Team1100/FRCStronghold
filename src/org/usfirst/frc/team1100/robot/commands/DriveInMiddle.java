package org.usfirst.frc.team1100.robot.commands;

import java.util.ArrayList;
import java.util.Collections;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveInMiddle extends Command{

	long oldTime;
	
	double sampleSize = 200;
	double refreshRate = 2.5;
	
	public DriveInMiddle(){
		requires(Drive.getInstance());
	}
	
	@Override
	protected void initialize() {
		
		oldTime = System.currentTimeMillis();
		
	}

	ArrayList<Double> data1 = new ArrayList<Double>();
	ArrayList<Double> data3 = new ArrayList<Double>();
	
	double distanceLeft = 0;
	double distanceRight = 0;
	
	@Override
	protected void execute() {
		Drive.getInstance().driveTank(.4, .4);
		//if(System.currentTimeMillis() - oldTime >= refreshRate) {
			data1.add((double) Drive.getInstance().getEZ1());
			oldTime = System.currentTimeMillis();
			if(data1.size()==sampleSize){
				Collections.sort(data1);
				double value1 = getMode(data1);
				distanceLeft = distanceMZ1(value1);
				SmartDashboard.putNumber("Left", distanceLeft);
				data1.clear();
			//}
		}
		
		//if(System.currentTimeMillis() - oldTime >= refreshRate) {
			data3.add((double) Drive.getInstance().getEZ3());
			oldTime = System.currentTimeMillis();
			if(data3.size()==sampleSize){
				Collections.sort(data3);
				double value3 = getMode(data3);
				distanceRight = distanceMZ3(value3);
				SmartDashboard.putNumber("Right", distanceRight);
				data3.clear();
			//}
		}
		if(Math.abs(distanceLeft-distanceRight)>5){
			if(distanceLeft<distanceRight){
				System.out.println("Turning To the left. L, R:" + distanceLeft+" " +distanceRight );
				Drive.getInstance().driveTank(.4, .5);
			}
			if(distanceLeft>distanceRight){
				System.out.println("Turning To the right. L, R:" + distanceLeft+" " +distanceRight );
				Drive.getInstance().driveTank(.5, .4);
			}
		}else{
			System.out.println("Going straight. L, R:" + distanceLeft+" " +distanceRight );
			Drive.getInstance().driveTank(.4, .4);
		}
	}

	private double distanceMZ3(double value){
		return .129*value + 2.494; 
	}
	
	private double distanceMZ1(double value){
		return .129*value + 2.077;
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
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
