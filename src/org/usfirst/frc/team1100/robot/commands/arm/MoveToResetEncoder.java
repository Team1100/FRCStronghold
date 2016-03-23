package org.usfirst.frc.team1100.robot.commands.arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveToResetEncoder extends CommandGroup{
	public MoveToResetEncoder(){
		addSequential(new MoveArmCommand(.9, 1));
		addSequential(new ResetEncoder());
	}
}
