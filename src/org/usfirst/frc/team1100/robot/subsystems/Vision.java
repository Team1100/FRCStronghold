package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.commands.vision.UpdateCameraValues;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Vision extends Subsystem{

	private static Vision vision;
	
	
	public static Vision getInstance(){
		if(vision==null)
			vision = new Vision();
		return vision;
	}
	
	private double y, x;
	private double h;
	private double w;
	private double a;
	
	public void updateVal(double x, double y, double h, double w, double a){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.a = a;
	}
	
	public double getY(){
		return y;
	}
	
	public double getH(){
		return h;
	}
	
	public double getX(){
		if(x==0)return 1;
		return x;
	}
	
	public double getA(){
		return a;
	}
	
	public double getW(){
		return w;
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new UpdateCameraValues());
	}

}
