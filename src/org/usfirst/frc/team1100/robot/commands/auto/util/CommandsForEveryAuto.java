package org.usfirst.frc.team1100.robot.commands.auto.util;

import org.usfirst.frc.team1100.robot.commands.arm.ArmToSetpoint;
import org.usfirst.frc.team1100.robot.commands.arm.MoveToResetEncoder;
import org.usfirst.frc.team1100.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CommandsForEveryAuto extends CommandGroup{
	public CommandsForEveryAuto(){
		addSequential(new MoveToResetEncoder());
		addSequential(new ArmToSetpoint(Lift.POS_RAMP));
	}
}