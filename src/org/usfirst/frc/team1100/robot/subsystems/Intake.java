
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.OI;
import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.intake.UserLiftIntake;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Controls the roller that pulls the boulders into the kicker
 */
public class Intake extends PIDSubsystem {

	private static Intake intake;

	private boolean rollersOn;

	private SpeedController roller;
	private SpeedController lift;
	private DigitalInput ballIn;
	private DigitalInput ballIn2;
	private AnalogInput liftRead;

	public static final double POS_SUCK = 2;
	public static final double POS_UP = 3.34;
	public static final double POS_DOWN = 1.48;
	
	private static final double MAX_SPEED = .4;
	
	private static final double P = 1;
	private static final double I = .2;
	private static final double D = 0;
	private static final double TOLERANCE = 100000;//shhhhh

	public static Intake getInstance() {
		if (intake == null)
			intake = new Intake();
		return intake;
	}

	private Intake() { /*"We need some sort of ball-sucking mechanism..." - L Tambascio, 2015*/
		super(P, I, D);
		setInputRange(POS_DOWN, POS_UP);

		setOutputRange(-MAX_SPEED, MAX_SPEED);
		
		setAbsoluteTolerance(TOLERANCE);
		
		roller = new Victor(RobotMap.I_INTAKE_ROLLER);
		lift = new Victor(RobotMap.I_INTAKE_LIFT);
		
		liftRead = new AnalogInput(RobotMap.I_INTAKE_LIFT_POTENTIOMETER);
		ballIn = new DigitalInput(RobotMap.I_BALL_IN);
		ballIn2 = new DigitalInput(RobotMap.I_BALL_IN_2);
	}
	
	public boolean target(){
		boolean x = onTarget();
		return x;
	}
	
	public double getEncoder() {
		return liftRead.getValue();
	}

	public boolean ballIn() {
		boolean in;
		if(!ballIn.get()&&!ballIn2.get())
			in = true;
		else in = false;
		return in;
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

	public void setLift(double value){
		if(Math.abs(value)>MAX_SPEED){
			if(value>0)value = MAX_SPEED;
			else if(value<0)value = -MAX_SPEED;
		}
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