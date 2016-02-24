package org.usfirst.frc.team1100.robot;

import org.usfirst.frc.team1100.robot.commands.arm.MoveToResetEncoder;
import org.usfirst.frc.team1100.robot.commands.arm.SetArmSetpoint;
import org.usfirst.frc.team1100.robot.commands.drive.ToggleDirection;
import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeSetpoint;
import org.usfirst.frc.team1100.robot.commands.intake.ToggleRollerCommand;
import org.usfirst.frc.team1100.robot.commands.intake.TurnRollers;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.LowGoalThenReset;
import org.usfirst.frc.team1100.robot.commands.vision.TrackThenFIRELASER;
import org.usfirst.frc.team1100.robot.input.AttackThree;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Intake;
import org.usfirst.frc.team1100.robot.subsystems.Lift;
/**
.*.This.class.is.the.glue.that.binds.the.controls.on.the.physical.operator
.*.interface.to.the.commands.and.command.groups.that.allow.control.of.the.robot.
.*/
public class OI{
	public static OI oi;
	
	public static OI getInstance(){
		if(oi==null)
			oi = new OI();
		return oi;
	}
	
	private AttackThree LeftStick;
	private AttackThree RightStick;
	private XboxController Peasant;
	
	/**
	 * Called by Robot Initialization. 
	 * Creates joysticks and button assignments.
	 */
	private OI(){
		//Joystick Init
		LeftStick = new AttackThree(RobotMap.J_LEFT, .1);
		RightStick = new AttackThree(RobotMap.J_RIGHT, .1);
		Peasant = new XboxController(RobotMap.J_X, .2);
		
		//Button Assignments
		Peasant.getButtonX().whenPressed(new FireThenReset());
		Peasant.getButtonB().whenPressed(new TrackThenFIRELASER());
		Peasant.getButtonY().whenPressed(new ToggleRollerCommand());
		Peasant.getButtonA().whileHeld(new TurnRollers(.5));
		Peasant.getButtonRightBumper().whenPressed(new SetIntakeSetpoint(Intake.POS_DOWN));
		Peasant.getButtonLeftBumper().whenPressed(new SetIntakeSetpoint(Intake.POS_UP));
		Peasant.getButtonStart().whenPressed(new MoveToResetEncoder());
		
		Peasant.getButtonLeftStick().whenPressed(new SetArmSetpoint(Lift.POS_DEFENSES));
		Peasant.getButtonStart().whenPressed(new SetArmSetpoint(Lift.POS_RAMP));
		Peasant.getButtonBack().whenPressed(new SetArmSetpoint(Lift.POS_MIDDLE));
		
		//RightStick.getButton(6).whenPressed(new StartGrip());
		//RightStick.getButton(5).whenPressed(new ToggleDirection());
		
		//Piston testing:
		/*Peasant.getButtonA().whenPressed(new SetFillCommand(Value.kReverse));
		Peasant.getButtonY().whenPressed(new SetResetCommand(Value.kForward));
		Peasant.getButtonLeftBumper().whenPressed(new SetLatchCommand(Value.kForward));
		Peasant.getButtonB().whenPressed(new SetResetCommand(Value.kReverse));
		Peasant.getButtonRightBumper().whenPressed(new SetFillCommand(Value.kForward));
		Peasant.getButtonX().whenPressed(new SetLatchCommand(Value.kReverse));*/
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
}