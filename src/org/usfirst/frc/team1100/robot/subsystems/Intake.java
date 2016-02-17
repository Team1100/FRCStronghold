
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.intake.UserLiftIntake;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Controls the roller that pulls the boulders into the kicker
 */
public class Intake extends PIDSubsystem {

	private static Intake intake;

	private boolean rollersOn;

	private SpeedController roller;
	private SpeedController lift;
	private DigitalInput ballIn;
	private AnalogInput liftRead;

	public static final double POS_SUCK = 2.3;
	public static final double POS_UP = 3.7;
	public static final double POS_DOWN = 2.2;
	
	private static double P = 1;
	private static double I = .2;
	private static double D = 0;
	private static double TOLERANCE = 100000;

	public static Intake getInstance() {
		if (intake == null)
			intake = new Intake();
		return intake;
	}

	private Intake() {
		super(P, I, D);
		setInputRange(POS_DOWN, POS_UP);

		setOutputRange(-.4, .4);
		
		setAbsoluteTolerance(TOLERANCE);
		
		roller = new Talon(RobotMap.I_INTAKE_ROLLER);
		lift = new Talon(RobotMap.I_INTAKE_LIFT);
		
		liftRead = new AnalogInput(RobotMap.I_INTAKE_LIFT_POTENTIOMETER);
		ballIn = new DigitalInput(RobotMap.I_BALL_IN);

		LiveWindow.addSensor("Intake", "PID Controller", getPIDController());
	}
	
	public boolean target(){
		boolean x = onTarget();
		/*if(Math.abs(getLiftSpeed())<.1){
			x = true;
		}*/
		return x;
	}
	
	public double getEncoder() {
		return liftRead.getValue();
	}

	public boolean ballIn() {
		return ballIn.get();
	}

	public void moveLift(double value) {
		lift.set(value);
	}

	public void moveRoller(double value) {
		if (OI.getInstance().getPeasant().getButtonLeftBumper().get())
			value = -value;
		roller.set(value);
	}

	public void setPosition(double pos) {
		super.setSetpoint(pos);
		super.enable();
		
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserLiftIntake());
	}

	public void toggleRollers() {
		/*if (ballIn()) {
			roller.set(0);
			return;
		}*/
		if (!rollersOn)
			roller.set(-.5);
		else
			roller.set(0);
		rollersOn = !rollersOn;
	}

	public boolean rollersOn() {
		return rollersOn;
	}

	public double getAnalog() {
		return liftRead.getVoltage();
	}
	
	public double getLiftSpeed(){
		return lift.get();
	}

	private void setLift(double value){
		if(Math.abs(value)>.1)
			lift.set(value);
		else
			lift.set(0);
	}
	
	@Override
	protected double returnPIDInput() {
		return liftRead.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		setLift(-output);
	}
}
