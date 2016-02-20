package org.usfirst.frc.team1100.robot;

import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeSetpoint;
import org.usfirst.frc.team1100.robot.commands.intake.ToggleRollerCommand;
import org.usfirst.frc.team1100.robot.commands.intake.TurnRollers;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.LowGoalThenReset;
import org.usfirst.frc.team1100.robot.commands.vision.TrackToGoal;
import org.usfirst.frc.team1100.robot.input.AttackThree;
import org.usfirst.frc.team1100.robot.input.XboxController;
import org.usfirst.frc.team1100.robot.subsystems.Intake;
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
	 * Creates joysticks and button asssignments.
	 */
	private OI(){
		//Joystick Init
		LeftStick = new AttackThree(RobotMap.J_LEFT, .1);
		RightStick = new AttackThree(RobotMap.J_RIGHT, .1);
		Peasant = new XboxController(RobotMap.J_X, .2);
		
		//Button Assignments TODO: Finalize
		Peasant.getButtonX().whenPressed(new FireThenReset());
		Peasant.getButtonA().whenPressed(new LowGoalThenReset());
		Peasant.getButtonB().whenPressed(new TrackToGoal());
		Peasant.getButtonY().whenPressed(new ToggleRollerCommand());
		Peasant.getButtonBack().whileHeld(new TurnRollers(.5));
		Peasant.getButtonRightBumper().whenPressed(new SetIntakeSetpoint(Intake.POS_DOWN));
		Peasant.getButtonLeftBumper().whenPressed(new SetIntakeSetpoint(Intake.POS_UP));
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