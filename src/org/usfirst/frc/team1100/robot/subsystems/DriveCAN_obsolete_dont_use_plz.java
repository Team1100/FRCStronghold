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
public class DriveCAN_obsolete_dont_use_plz extends Subsystem {
    
	private static DriveCAN_obsolete_dont_use_plz driveCAN;
	
	private CANTalon backLeftT;
	private CANTalon backRightT;
	private CANTalon frontLeftT;
	private CANTalon frontRightT;
	private RobotDrive driveTrain;
	
	public static DriveCAN_obsolete_dont_use_plz getInstance(){
		if(driveCAN==null)
			driveCAN = new DriveCAN_obsolete_dont_use_plz();
		return driveCAN;
	}
	
	public DriveCAN_obsolete_dont_use_plz(){
		backLeftT = new CANTalon(RobotMap.D_LEFT_BACK);
		backRightT = new CANTalon(RobotMap.D_RIGHT_BACK);
		frontLeftT = new CANTalon(RobotMap.D_LEFT_FRONT);
		frontRightT = new CANTalon(RobotMap.D_RIGHT_FRONT);
		driveTrain = new RobotDrive(backLeftT, frontLeftT, backRightT, frontRightT);
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

	public double getAngle() {
		// TODO Add once gyro confirmed
		return 0;
	}
}