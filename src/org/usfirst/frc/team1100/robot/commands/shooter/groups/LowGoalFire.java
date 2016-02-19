package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import org.usfirst.frc.team1100.robot.commands.shooter.SetFillCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.SetLatchCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class LowGoalFire extends CommandGroup{
	/**
	 * Undoes necessary pistons then does a soft kick
	 */
	public LowGoalFire(){
		addSequential(new SetFillCommand(Value.kReverse));
		addSequential(new WaitCommand(1));
		addSequential(new SetLatchCommand(Value.kReverse));
		addSequential(new WaitCommand(1));
		addSequential(new SetFillCommand(Value.kForward));
		addSequential(new WaitCommand(1));
	}
}