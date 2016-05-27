
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.intake.PauseLift;
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
	private AnalogInput liftRead;
	
	private DigitalInput /*limitTop,*/ limitBot;

	public static final double POS_UP = 3.33;
	public static final double POS_DOWN = 1.825;
	
	
	
	private static final double P = 1;
	private static final double I = .2;
	private static final double D = 0;
	private static final double TOLERANCE = 100;//shhhhh

	public static final double ROLL_SPEED = .75;
	private static final double MAX_SPEED = ROLL_SPEED*.5;
	
	private boolean magUsed;	
	
	private DigitalInput magSwitch;
	private DigitalInput ballSwitch;
	
	public static Intake getInstance() {
		if (intake == null)
			intake = new Intake();
		return intake;
	}

	private Intake() { /*"We need some sort of ball-sucking mechanism..." - L Tambascio, 2015*/
		super(P, I, D);
		setInputRange(POS_DOWN, POS_UP);

		setOutputRange(-MAX_SPEED*.5, MAX_SPEED);
		
		setAbsoluteTolerance(TOLERANCE);
		
		roller = new Victor(RobotMap.I_INTAKE_ROLLER);
		lift = new Victor(RobotMap.I_INTAKE_LIFT);
		
		/*limitTop = new DigitalInput(RobotMap.I_LIMIT_SWITCH_TOP);*/
		limitBot = new DigitalInput(RobotMap.I_LIMIT_SWITCH_BOT);
		
		liftRead = new AnalogInput(RobotMap.I_INTAKE_LIFT_POTENTIOMETER);
		
		magSwitch = new DigitalInput(RobotMap.I_MAG_SWITCH);
		ballSwitch = new DigitalInput(RobotMap.I_BALL_IN);
		
		magUsed = false;
	}
	
	public boolean target(){
		boolean x = onTarget();
		return x;
	}
	
	public double getEncoder() {
		return liftRead.getValue();
	}

	public boolean tooFarDown(){
		return !limitBot.get();
	}
	
	public boolean ballIn() {
		boolean in;
		if(ballIn.get())
			in = true;
		else in = false;
		return false;//TODO ball in tomfoolery
	}

	public void moveRoller(double value) {
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
			roller.set(-ROLL_SPEED);
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

	public void moveIntake(double value){
		/*if(getAnalog()<POS_DOWN&&value>0){ 
			//lift.set(0);
			//return;
		}
		if(getAnalog()>POS_UP&&value<0){
			//lift.set(0);
			//return;
		}
		if(Math.abs(value)>MAX_SPEED){
			if(value>0)value = MAX_SPEED;
			else if(value<0)value = -MAX_SPEED;
		}*/
		/*if(limitTop.get()&&lift.get()>0){
			lift.set(0);
			return;
		}*/
		if(this.isMagSwitchOn()&&!magUsed){
			//(new SetLEDCommand(false, true, false)).start();
			magUsed = true;
			//new PauseLift().start();
		} else if(!this.isMagSwitchOn()&&magUsed){
			//(new SetLEDCommand(false, false, false)).start();
			magUsed = false;
		}
		if(tooFarDown()&&lift.get()<0){
			lift.set(0);
			return;
		}
		if(Math.abs(value)>.1)
			lift.set(-1*value);
		else
			lift.set(0);
	}
	
	@Override
	protected double returnPIDInput() {
		return liftRead.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		moveIntake(-output);
	}
	
	public boolean isMagSwitchOn() {
		return !magSwitch.get();
	}
	
	public void blindDrive(double speed){
		lift.set(speed);
	}
	
	public boolean isBallIn() {
		return !ballSwitch.get();
	}
}