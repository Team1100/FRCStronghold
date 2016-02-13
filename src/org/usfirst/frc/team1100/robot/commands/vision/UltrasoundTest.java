package org.usfirst.frc.team1100.robot.commands.vision;

import java.util.ArrayList;
import java.util.Collections;

import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UltrasoundTest extends Command{

	long oldTime;
	
	double sampleSize = 200;
	double refreshRate = 2.5;
	
	@Override
	protected void initialize() {
		oldTime = System.currentTimeMillis();
		//no im not in the robotmap. yes i will fix it later. TODO
	
	}

	ArrayList<Double> data = new ArrayList<Double>();
	
	@Override
	protected void execute() {
		
		if(System.currentTimeMillis() - oldTime >= refreshRate) {
			data.add((double) Drive.getInstance().getUltrasound());
			oldTime = System.currentTimeMillis();
			if(data.size()==sampleSize){
				Collections.sort(data);
				/*for(int i = 0; i< data.size();i++){
					SmartDashboard.putNumber(""+i, data.get(i));
				}*/
				double value = getMode(data);
				SmartDashboard.putNumber("Ultrasonic Input", value);
				SmartDashboard.putNumber("Distance (inches)", distanceMZ3(value));
				data.clear();
			}
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
