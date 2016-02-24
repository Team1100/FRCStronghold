
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.arm.UserMoveArm;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Uses pneumatics to kick boulders into enemy towers (or our own towers. or
 * empty space(its air damnit). or the ceiling, idk)
 */
public class Lift extends PIDSubsystem {

	private static Lift lift;

	private SpeedController lift1;
	private SpeedController lift2;// these two move the arm up and down

	private AnalogInput armRead2;

	private Encoder armRead;

	private DigitalInput lSwitch;

	public static final double POS_DEFENSES = 240;
	public static final double POS_MIDDLE = 230;
	public static final double POS_CLOSE = 250;
	public static final double POS_RAMP = 290;

	private static final double P = .1;
	private static final double I = 0;
	private static final double D = 0;
	private static final double TOLERANCE = 7;
	private static final double MAX_SPEED = .6;

	public static Lift getInstance() {
		if (lift == null)
			lift = new Lift();
		return lift;
	}

	public Lift() {
		super(P, I, D);
		setAbsoluteTolerance(TOLERANCE);
		setOutputRange(-MAX_SPEED, MAX_SPEED);

		lift1 = new Talon(RobotMap.L_ARM_LIFT_MOTOR_1);
		lift2 = new Talon(RobotMap.L_ARM_LIFT_MOTOR_2);

		armRead = new Encoder(RobotMap.L_ARM_ENC_A, RobotMap.L_ARM_ENC_B);
		armRead2 = new AnalogInput(RobotMap.L_ARM_POTENTIOMETER);

		armRead.reset();
	}

	public boolean tooFar() {
		return lSwitch.get();
	}

	public double getEncValue() {
		return armRead.get();
	}

	public void resetEncoder() {
		armRead.reset();
	}

	public double getPotentiometer() {
		return armRead2.getValue();
	}

	public void moveArm(double value) {
		if (getEncValue() > 500 && value < 0) {
			lift1.set(0);
			lift2.set(0);
			return;
		}
		lift1.set(value);
		lift2.set(value);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserMoveArm());
	}

	@Override
	protected double returnPIDInput() {
		return -armRead.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		moveArm(-output);
	}
}