package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Lift;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public class WidthToEncoderMovement extends Command{

	double pos;
	
	public WidthToEncoderMovement(){
		requires(Lift.getInstance());
	}
	
	@Override
	protected void initialize() {
		System.out.println("Math Started");
		setTimeout(3.5);
		double x = Vision.getInstance().getW();
		
		/*pos = (-5.569 * Math.pow(10, -6)*Math.pow(x, 6)) + (1.769 * Math.pow(10, -3)
		* Math.pow(x, 5)) + (-0.231 * Math.pow(x, 4)) + (15.911 * Math.pow(x, 3))
		+ (-607.383 * Math.pow(x, 2)) + (12192.185*x) + (-1.003 * Math.pow(10, 5));
		*/
		
		if(x<35){
			pos = 235;
		}
		if(x>=35&&x<50){
			pos = 235;
		}
		if(x>=50&&x<=52){
			pos = 240;
		}
		if(x>52&&x<54){
			pos = 246;
		}
		if(x>=54&&x<58){
			pos = 255;
		}
		if(x>=58&&x<60){
			pos = 260;
		}
		if(x>=60&&x<63){
			pos = 270;
		}
		if(x>=63&&x<65){
			pos = 277;
		}
		if(x>=65){
			pos = 293;
		}
	}

	@Override
	protected void execute() {
		Lift.getInstance().setSetpoint(pos);
		Lift.getInstance().enable();
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Lift.getInstance().disable();
	}

	@Override
	protected void interrupted() {
		end();
		
	}

}
