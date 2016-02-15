package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import org.usfirst.frc.team1100.robot.commands.shooter.SetKickerCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.SetLatchCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class LowGoalFire extends CommandGroup{
	public LowGoalFire(){
		addSequential(new SetKickerCommand(Value.kReverse));
		addSequential(new WaitCommand(1));
		addSequential(new SetLatchCommand(Value.kReverse));
		addSequential(new WaitCommand(1));
		addSequential(new SetKickerCommand(Value.kForward));
		addSequential(new WaitCommand(1));
	}
}