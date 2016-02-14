package org.usfirst.frc.team1100.robot.subsystems;

import java.util.ArrayList;
import java.util.Collections;

import org.usfirst.frc.team1100.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ultrasound extends Subsystem{

	AnalogInput EZ1;
	AnalogInput EZ3;
	
	private Ultrasound ultrasound;
	
	public Ultrasound getInstance(){
		if(ultrasound==null)ultrasound = new Ultrasound();
		return ultrasound;
	}
	
	public Ultrasound(){
		EZ1 = new AnalogInput(RobotMap.U_EZ1);
		EZ3 = new AnalogInput(RobotMap.U_EZ3);
	}
/*protected void execute() {
		
		if(System.currentTimeMillis() - oldTime >= refreshRate) {
			data.add((double) Drive.getInstance().getUltrasound());
			oldTime = System.currentTimeMillis();
			if(data.size()==sampleSize){
				Collections.sort(data);
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
		
	}*/

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}