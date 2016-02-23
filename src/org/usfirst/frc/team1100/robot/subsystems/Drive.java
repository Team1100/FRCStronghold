
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.drive.UserDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Controls the Wheels. Obsolete class. Use DriveCAN Instead.
 */
public class Drive extends PIDSubsystem{
	private static Drive drive;

	private Victor RightFrontVictor;
	private Victor RightBackVictor;
	private Victor LeftFrontVictor;
	private Victor LeftBackVictor;
	
	private RobotDrive driveTrain;
	
	private AnalogGyro gyro;
	
	private boolean reversed;
	
	private static final double P = 1;
	private static final double I = 0;
	private static final double D = 0;
	
	private static final double TOLERANCE = 1;
	private static final double MAX_SPEED = .5;
	
	public static Drive getInstance() {// make drive accessible from anywhere
		if (drive == null)
			drive = new Drive();
		return drive;
	}

	public Drive() {
		super (P,I,D);
		setAbsoluteTolerance(TOLERANCE);
		setOutputRange(-MAX_SPEED, MAX_SPEED);
		
		reversed = false;
		
		RightFrontVictor = new Victor(RobotMap.D_RIGHT_FRONT);
		RightBackVictor = new Victor(RobotMap.D_RIGHT_BACK);
		LeftFrontVictor = new Victor(RobotMap.D_LEFT_FRONT);
		LeftBackVictor = new Victor(RobotMap.D_LEFT_BACK);

		driveTrain = new RobotDrive(LeftFrontVictor, LeftBackVictor, RightFrontVictor, RightBackVictor);

		/* gyro = new AnalogGyro(RobotMap.D_GYRO, 0 , 1);
		 gyro.reset();*/
	}

	public void driveTank(double left, double right) {
		if(!reversed)driveTrain.tankDrive(left, right);
	}

	public void toggleDriveReverse(){
		reversed = !reversed;
	}
	
	public boolean isReversed(){
		return reversed;
	}
	
	public double getAngle() {
		return gyro.getAngle();

	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserDrive());
	}
	
	public void driveAngle(double speed, double angle){
		if(!reversed)driveTrain.drive(speed, angle);
	}

	public void stop(){
		driveTrain.stopMotor();
	}
	
	@Override
	protected double returnPIDInput() {
		return gyro.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		driveTank(output, -output);
		
	}
}