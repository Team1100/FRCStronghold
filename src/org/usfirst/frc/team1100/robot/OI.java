package org.usfirst.frc.team1100.robot;

import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeSetpoint;
import org.usfirst.frc.team1100.robot.commands.intake.ToggleRollerCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.LowGoalThenReset;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.ResetShooterCommandGroup;
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
	
	private OI(){
		//Joystick Init
		LeftStick = new AttackThree(RobotMap.J_LEFT, .1);
		RightStick = new AttackThree(RobotMap.J_RIGHT, .1);
		Peasant = new XboxController(RobotMap.J_X, .2);
		
		//Button Assignments
		//Don't have these on while testing things unless you are testing them
		Peasant.getButtonX().whenPressed(new FireThenReset());
		Peasant.getButtonA().whenPressed(new LowGoalThenReset());
		Peasant.getButtonStart().whenPressed(new ResetShooterCommandGroup());
		Peasant.getButtonY().whenPressed(new ToggleRollerCommand());
		Peasant.getButtonRightBumper().whenPressed(new SetIntakeSetpoint(Intake.POS_DOWN));
		Peasant.getButtonLeftBumper().whenPressed(new SetIntakeSetpoint(Intake.POS_UP));
		Peasant.getButtonLeftStick().whenPressed(new SetIntakeSetpoint(Intake.POS_SUCK));
	}

	public AttackThree getLeftStick() {
		return LeftStick;
	}

	public AttackThree getRightStick() {
		return RightStick;
	}

	public XboxController getPeasant() {
		return Peasant;
	}
	
	
}

