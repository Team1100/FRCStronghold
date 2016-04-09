package org.usfirst.frc.team1100.robot.commands.arm.led;

import org.usfirst.frc.team1100.robot.subsystems.Intake;
import org.usfirst.frc.team1100.robot.subsystems.LED;

import edu.wpi.first.wpilibj.command.Command;

public class LeadLoop extends Command{

	public LeadLoop(){
		requires(LED.getInstance());
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(Intake.getInstance().isBallIn() || Intake.getInstance().isMagSwitchOn()) {
			if(Intake.getInstance().isBallIn())
				LED.getInstance().setRGB(true, false, false);
			else if(Intake.getInstance().isMagSwitchOn())
				LED.getInstance().setRGB(false, false, true);
		} else {
			LED.getInstance().setRGB(false, true, false);
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
