package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterXAdjust extends CommandGroup{
	private double target = 0;
	public CenterXAdjust(boolean right){		
		if(right){
			while(Vision.getInstance().getX()<target){
				
			}
		}
		if(!right){
			while(Vision.getInstance().getX()>target){
				
			}
		}
	}
}