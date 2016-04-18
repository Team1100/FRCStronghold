package org.usfirst.frc.team1100.robot.commands.auto.old;

import org.usfirst.frc.team1100.robot.commands.arm.ArmToSetpoint;
import org.usfirst.frc.team1100.robot.commands.arm.MoveToResetEncoder;
import org.usfirst.frc.team1100.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpyBotFire extends CommandGroup{
	public SpyBotFire(){
		addSequential(new MoveToResetEncoder());
		addSequential(new ArmToSetpoint(Arm.POS_MIDDLE));
	}
}
