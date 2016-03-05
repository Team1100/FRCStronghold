package org.usfirst.frc.team1100.robot.commands.auto.util;

import org.usfirst.frc.team1100.robot.commands.arm.ArmToSetpoint;
import org.usfirst.frc.team1100.robot.commands.arm.MoveToResetEncoder;
import org.usfirst.frc.team1100.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CommandsForEveryAuto extends CommandGroup{
	/**
	 * Use this class for command sequences that should be called
	 * at the start of every match.
	 */
	public CommandsForEveryAuto(){
		addSequential(new MoveToResetEncoder());
		addSequential(new ArmToSetpoint(Arm.POS_RAMP));
	}
}