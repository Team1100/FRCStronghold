package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.drive.UserDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Utilizes CAN bus for driving. Use this class, not Drive.java
 */
public class DriveCAN extends Subsystem {
    
	private static DriveCAN driveCAN;
	
	private CANTalon backLeftT;
	private CANTalon backRightT;
	private CANTalon midRightT;
	private CANTalon midLeftT;
	private CANTalon frontLeftT;
	private CANTalon frontRightT;
	private RobotDrive driveTrain;
	
	public static DriveCAN getInstance(){
		if(driveCAN==null)
			driveCAN = new DriveCAN();
		return driveCAN;
	}
	
	public DriveCAN(){
		backLeftT = new CANTalon(RobotMap.D_LEFT_BACK);
		backRightT = new CANTalon(RobotMap.D_RIGHT_BACK);
		midLeftT = new CANTalon(RobotMap.D_LEFT_MID);
		midRightT = new CANTalon(RobotMap.D_RIGHT_MID);
		frontLeftT = new CANTalon(RobotMap.D_LEFT_FRONT);
		frontRightT = new CANTalon(RobotMap.D_RIGHT_FRONT);
		driveTrain = new RobotDrive(new VVV(backLeftT, midLeftT, frontLeftT),
									new VVV(backRightT, midRightT, frontRightT));
	}
	
    public void initDefaultCommand() {
       setDefaultCommand(new UserDrive());
    }
    /**
     * Drives the robot
     * @param leftSpeed
     * @param rightSpeed
     */
    public void driveTank(double leftSpeed, double rightSpeed){
    	driveTrain.tankDrive(leftSpeed, rightSpeed);
    }
public class VVV implements SpeedController {//class manages a side of speed controllers
		
		//In this class "Sanic" indicates enhanced loop variable
		
		private SpeedController[] vics;
		private double speed;

		public VVV(SpeedController... vics) {
			this.vics = vics;
			this.set(0.0);
		}

		@Override
		public void pidWrite(double output) {
			this.set(output);
			for (SpeedController Sanic : vics) {
				Sanic.disable();
			}
		}

		@Override
		public double get() {
			return this.speed;
		}

		@Override
		public void set(double speed, byte syncGroup) {
			this.speed = speed;
		}

		@Override
		public void set(double speed) {
			this.speed = speed;
			for (SpeedController Sanic : this.vics) {
				Sanic.set(speed);
			}

		}

		@Override
		public void setInverted(boolean isInverted) {
			for(SpeedController Sanic: this.vics){
				Sanic.setInverted(isInverted);
			}

		}

		@Override
		public boolean getInverted() {
			return vics[0].getInverted();
		}

		@Override
		public void disable() {
			for(SpeedController Sanic: this.vics){
				Sanic.disable();
			}
		}
	}
}