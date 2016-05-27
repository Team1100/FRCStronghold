package org.usfirst.frc.team1100.robot;

import org.usfirst.frc.team1100.robot.commands.FireInHigh;
import org.usfirst.frc.team1100.robot.commands.arm.ArmToSetpoint;
import org.usfirst.frc.team1100.robot.commands.arm.MoveToResetEncoder;
import org.usfirst.frc.team1100.robot.commands.arm.ToggleBrakeCommand;
import org.usfirst.frc.team1100.robot.commands.auto.old.InterruptDrive;
import org.usfirst.frc.team1100.robot.commands.drive.DriveBackwardsUntilUltrasonicCommand;
import org.usfirst.frc.team1100.robot.commands.intake.LiftIntake;
import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeSetpoint;
import org.usfirst.frc.team1100.robot.commands.intake.ToggleLEDCommand;
import org.usfirst.frc.team1100.robot.commands.intake.TurnRollers;
import org.usfirst.frc.team1100.robot.commands.shooter.ToggleLight;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenResetSimultIntake;
import org.usfirst.frc.team1100.robot.input.AttackThree;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Arm;
import org.usfirst.frc.team1100.robot.subsystems.Intake;
/**
.*.This.class.is.the.glue.that.binds.the.controls.on.the.physical.operator
.*.interface.to.the.commands.and.command.groups.that.allow.control.of.the.robot.
.*/
public class OI{
	public static OI oi;
	
	private static int method;

	public static OI getInstance(){
		if(oi==null)
			oi = new OI();
		return oi;
	}
	
	public static void setTwoDriver(){
		/*oi = null;
		OI.getInstance();*/
	}
	public static void setOneDriver(boolean controller){
		/*oi = null;
		oi = new OI(controller);*/
	}
	
	private AttackThree LeftStick;
	private AttackThree RightStick;
	private XboxController Peasant/*, Peasant2*/;
	
	public static final boolean XBOX = true;
	public static final boolean STICKS = false;
	
	/**
	 * Called by Robot Initialization. 
	 * Creates joysticks and button assignments.
	 */
	
	private OI(){
		
		setMethod(0);
		
		//Joystick Init
		LeftStick = new AttackThree(RobotMap.J_LEFT, .1);
		RightStick = new AttackThree(RobotMap.J_RIGHT, .1);
		Peasant = new XboxController(RobotMap.J_X, .2); //Help! Help! I'm being repressed!
		
		
		//Button Assignments
		
		Peasant.getButtonX().whenPressed(new FireThenReset());
		Peasant.getButtonB().whenPressed(new FireThenResetSimultIntake());
		Peasant.getButtonY().whileHeld(new TurnRollers(-Intake.ROLL_SPEED));
		Peasant.getButtonA().whileHeld(new TurnRollers(Intake.ROLL_SPEED));
		Peasant.getButtonRightBumper().whenPressed(new SetIntakeSetpoint(Intake.POS_DOWN));
		Peasant.getButtonLeftBumper().whenPressed(new SetIntakeSetpoint(Intake.POS_UP));
		
		//Peasant.getButtonRightStick().whenPressed(new MoveToResetEncoder());
		
		Peasant.getButtonLeftStick().whenPressed(new ToggleBrakeCommand());
		Peasant.getButtonStart().whenPressed(new ArmToSetpoint(Arm.POS_RAMP));
		Peasant.getButtonBack().whenPressed(new ArmToSetpoint(Arm.POS_MIDDLE));
		
		RightStick.getButton(2).whenPressed(new ToggleLight());
		RightStick.getButton(3).whenPressed(new DriveBackwardsUntilUltrasonicCommand());
		RightStick.getButton(6).whenPressed(new ChangeDriveMode());
		
		RightStick.getButton(10).whenPressed(new DriveBackwardsUntilUltrasonicCommand());;
		RightStick.getButton(11).whenPressed(new FireInHigh());
		LeftStick.getButton(11).whenPressed(new InterruptDrive());
		
		LeftStick.getButton(5).whenPressed(new ToggleBrakeCommand());
		RightStick.getButton(8).whenPressed(new ToggleLEDCommand(0));
		RightStick.getButton(9).whenPressed(new ToggleLEDCommand(1));
		RightStick.getButton(10).whenPressed(new ToggleLEDCommand(2));
		//RightStick.getButton(6).whenPressed(new StartGrip());
		//RightStick.getButton(5).whenPressed(new ToggleDirection());
		
		//Piston testing:
		/*
		Peasant.getButtonA().whenPressed(new SetFillCommand(Value.kReverse));
		Peasant.getButtonY().whenPressed(new SetResetCommand(Value.kForward));
		Peasant.getButtonLeftBumper().whenPressed(new SetLatchCommand(Value.kForward));
		Peasant.getButtonB().whenPressed(new SetResetCommand(Value.kReverse));
		Peasant.getButtonRightBumper().whenPressed(new SetFillCommand(Value.kForward));
		Peasant.getButtonX().whenPressed(new SetLatchCommand(Value.kReverse));
		Peasant.getButtonStart().whenPressed(new FireThenReset());
		*/
	}
	
	private OI(boolean controller){
		if(XBOX){
			setMethod(1);
			//just xbox assignments
			RightStick.getButton(6).whenPressed(new ChangeDriveMode());
			
			Peasant.getButtonX().whenPressed(new FireThenReset());
			Peasant.getButtonB().whenPressed(new FireThenResetSimultIntake());
			Peasant.getButtonY().whileHeld(new TurnRollers(-Intake.ROLL_SPEED));
			Peasant.getButtonA().whileHeld(new TurnRollers(Intake.ROLL_SPEED));
			
			Peasant.getButtonRightStick().whenPressed(new MoveToResetEncoder());
			Peasant.getButtonLeftStick().whenPressed(new ArmToSetpoint(Arm.POS_DEFENSES));
			Peasant.getButtonStart().whenPressed(new ArmToSetpoint(Arm.POS_RAMP));
			Peasant.getButtonBack().whenPressed(new ArmToSetpoint(Arm.POS_MIDDLE));
			
			Peasant.getButtonRightBumper().whileHeld(new LiftIntake(.9));
			Peasant.getButtonLeftBumper().whileHeld(new LiftIntake(-.9));
		}else if(STICKS){
			setMethod(2);
			//just sticks assignments
			RightStick.getButton(6).whenPressed(new ChangeDriveMode());
		}
	}
	/**
	 * Returns the Left Joystick.
	 * @return the Left AttackThree
	 */
	public AttackThree getLeftStick() {
		return LeftStick;
	}

	/**
	 * Returns the Right Joystick
	 * @return the Right AttackThree
	 */
	public AttackThree getRightStick() {
		return RightStick;
	}
	/**
	 * Returns the Xbox
	 * @return the xbox ya silly what else
	 */
	public XboxController getPeasant() {
		return Peasant;
	}

	public static int getMethod() {
		return method;
	}

	public static void setMethod(int method) {
		OI.method = method;
	}
}