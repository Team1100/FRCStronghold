package org.usfirst.frc.team1100.robot.subsystems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.ultrasound.PollSensors;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ultrasound extends Subsystem {
	
	private AnalogInput EZ3;
	private final int SAMPLE_SIZE = 100;
	private static Ultrasound ultrasound;
	
	private Queue<Double> dataEZ3; 
	
	private double EZ3Distance;
	
	public static Ultrasound getInstance() {
		if (ultrasound == null)
			ultrasound = new Ultrasound();
		return ultrasound;
	}

	public Ultrasound() {
		EZ3 = new AnalogInput(RobotMap.U_EZ3);

		dataEZ3 = new LinkedList<Double>();;
	}

	public void setDistanceEZ3() {
		
	}
	
	public void setDistanceEZ1() {
		
	}
	
	public double getEZ3Distance(){
		return EZ3Distance;
	}
	
	public void addEZ3Data(){
		SmartDashboard.putNumber("EZ3 Ultrasonic Readout", EZ3.getValue());
		SmartDashboard.putNumber("EZ3 Ultrasonic Distance", distanceEZ3(EZ3.getValue()));
	}
	
	public void addEZ1Data(){
		
	}
	
	public double getCurrentReading() {
		return EZ3.getValue();
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