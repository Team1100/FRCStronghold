package org.usfirst.frc.team1100.robot.commands.intake;

import org.usfirst.frc.team1100.robot.subsystems.Intake;
import org.usfirst.frc.team1100.robot.subsystems.LED;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleLEDCommand extends Command{

	private int s;
	private boolean isFin;
	
	public ToggleLEDCommand(int s){
		requires(LED.getInstance());
		this.s = s;
	}
	
	@Override
	protected void initialize() {
		isFin = false;
		
	}

	@Override
	protected void execute() {
		switch(s){
		case 0:
			LED.getInstance().tRed();
			break;
		case 1:
			LED.getInstance().tGreen();
			break;
		case 2:
			LED.getInstance().tBlue();
			break;
		default:
			System.out.println("Thomas is a but...ane molecule");
		}
		isFin = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFin;
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
