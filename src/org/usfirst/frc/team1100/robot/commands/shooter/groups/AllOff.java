package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import org.usfirst.frc.team1100.robot.commands.shooter.SetKickerCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.SetLatchCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.SetResetCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AllOff extends CommandGroup{
	public AllOff(){
		addParallel(new SetLatchCommand(Value.kOff));
		addParallel(new SetKickerCommand(Value.kOff));
		addParallel(new SetResetCommand(Value.kOff));
		
	}
}
