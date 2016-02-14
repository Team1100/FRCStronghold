package org.usfirst.frc.team1100.robot.subsystems;

import java.util.ArrayList;
import java.util.Collections;

import org.usfirst.frc.team1100.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ultrasound extends Subsystem {

	private AnalogInput EZ1;
	private AnalogInput EZ3;
	private final int SAMPLE_SIZE = 100;
	private Ultrasound ultrasound;

	public Ultrasound getInstance() {
		if (ultrasound == null)
			ultrasound = new Ultrasound();
		return ultrasound;
	}

	public Ultrasound() {
		EZ1 = new AnalogInput(RobotMap.U_EZ1);
		EZ3 = new AnalogInput(RobotMap.U_EZ3);
	}

	public double getDistanceEZ3() {
		ArrayList<Double> data = new ArrayList<Double>();
		
		for(int i = 0; i < SAMPLE_SIZE; i++){
			data.add((double) (EZ3.getValue()));
		}
		Collections.sort(data);
		double value = getMode(data);
		data.clear();
		return distanceEZ3(value);
	}
	
	public double getDistanceEZ1() {
		ArrayList<Double> data = new ArrayList<Double>();
		
		for(int i = 0; i < SAMPLE_SIZE; i++){
			data.add((double) (EZ1.getValue()));
		}
		Collections.sort(data);
		double value = getMode(data);
		data.clear();
		return distanceEZ1(value);
	}

	private double distanceEZ3(double value) {
		return .129 * value + 2.494;
	}

	private double distanceEZ1(double value) {
		return .129 * value + 2.077;
	}

	public double getMode(ArrayList<Double> list) {
		double x = 0;
		double y = 0;
		double count = 0;
		double maxCount = 0;
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			x = list.get(i);
			if (x == y) {
				count++;
			} else {
				if (count > maxCount) {
					maxCount = count;
					index = i - 1;
				}
				count = 0;
				y = x;
			}
		}
		return list.get(index);

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}