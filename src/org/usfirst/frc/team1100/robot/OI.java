package org.usfirst.frc.team1100.robot;

import org.usfirst.frc.team1100.robot.commands.shooter.ShootCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.SpinBeltCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.StopShootCommand;
import org.usfirst.frc.team1100.robot.input.AttackThree;
import org.usfirst.frc.team1100.robot.input.XboxController;
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
		LeftStick = new AttackThree(RobotMap.J_LEFT, 0);//TODO: set deadband
		RightStick = new AttackThree(RobotMap.J_RIGHT, 0);//TODO: set deadband
		Peasant = new XboxController(RobotMap.J_X, 0);//TODO:set deadband
		
		//Control button sets go here. Like, literally in this section of the constructor.
		Peasant.getButtonX().whileHeld(new ShootCommand());
		Peasant.getButtonA().whenPressed(new SpinBeltCommand(.5));
		Peasant.getButtonB().whenPressed(new SpinBeltCommand(-.5));
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

