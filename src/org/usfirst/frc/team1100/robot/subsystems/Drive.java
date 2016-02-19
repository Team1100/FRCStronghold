
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.drive.UserDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * Controls the Wheels. Obsolete class. Use DriveCAN Instead.
 */
public class Drive extends Subsystem {
	private static Drive drive;// create drive train object

	// Declare Victors(motor controllers)
	private Victor RightFrontVictor;
	private Victor RightBackVictor;
	private Victor LeftFrontVictor;
	private Victor LeftBackVictor;
	// Declare Robot Drive
	private RobotDrive driveTrain;
	// Declare Gyro
	private Gyro gyro;

	public static Drive getInstance() {// make drive accessible from anywhere
		if (drive == null)
			drive = new Drive();
		return drive;
	}

	public Drive() {
		RightFrontVictor = new Victor(RobotMap.D_RIGHT_FRONT);
		RightBackVictor = new Victor(RobotMap.D_RIGHT_BACK);
		LeftFrontVictor = new Victor(RobotMap.D_LEFT_FRONT);
		LeftBackVictor = new Victor(RobotMap.D_LEFT_BACK);

		driveTrain = new RobotDrive(LeftFrontVictor, LeftBackVictor, RightFrontVictor, RightBackVictor);

		// TODO: gyro = new AnalogGyro(RobotMap.D_GYRO);
		// gyro.reset();
	}

	public void driveTank(double left, double right) {
		driveTrain.tankDrive(left, right);
	}

	public double getAngle() {
		return gyro.getAngle();

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new UserDrive());
	}
}