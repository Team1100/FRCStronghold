package org.usfirst.frc.team1100.robot.subsystems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.ultrasound.PollSensors;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ultrasound extends Subsystem {
	
	private AnalogInput EZ1;
	private AnalogInput EZ3;
	private final int SAMPLE_SIZE = 100;
	private static Ultrasound ultrasound;

	private Queue<Double> dataEZ1;
	private Queue<Double> dataEZ3; 
	
	private double EZ3Distance;
	private double EZ1Distance;
	
	public static Ultrasound getInstance() {
		if (ultrasound == null)
			ultrasound = new Ultrasound();
		return ultrasound;
	}

	public Ultrasound() {
		EZ1 = new AnalogInput(RobotMap.U_EZ1);
		EZ3 = new AnalogInput(RobotMap.U_EZ3);

		dataEZ1 = new LinkedList<Double>();
		dataEZ3 = new LinkedList<Double>();; 
	}

	public void setDistanceEZ3() {
		double value = getMode(dataEZ3);
		dataEZ3.clear();
		EZ3Distance =  distanceEZ3(value);
	}
	
	public void setDistanceEZ1() {
		double value = getMode(dataEZ1);
		dataEZ1.clear();
		EZ1Distance = distanceEZ1(value);
	}
	
	public double getEZ3Distance(){
		return EZ3Distance;
	}
	
	public double getEZ1Distance(){
		return EZ1Distance;
	}
	
	public void addEZ3Data(){
		dataEZ3.add((double) EZ3.getValue());
		if(dataEZ3.size()>SAMPLE_SIZE)
			dataEZ3.poll();
	}
	
	public void addEZ1Data(){
		dataEZ1.add((double) EZ1.getValue());
		if(dataEZ1.size()>SAMPLE_SIZE)
			dataEZ1.poll();
	}

	private double distanceEZ3(double value) {
		return .129 * value + 2.494;
	}

	private double distanceEZ1(double value) {
		return .129 * value + 2.077;
	}

	public double getMode(Queue<Double> data) {
		double x = 0;
		double y = 0;
		double count = 0;
		double maxCount = 0;
		int index = 0;
		ArrayList<Double> d = new ArrayList<Double>(data);
		Collections.sort(d);
		for (int i = 0; i < data.size(); i++) {
			x = d.get(i);
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
		return d.get(index);

	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new PollSensors());
	}

}