package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import org.usfirst.frc.team1100.robot.commands.shooter.SetLatchCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.SetResetCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class FireShooterCommandGroup extends CommandGroup {
    
    public  FireShooterCommandGroup() {
    	addSequential(new SetLatchCommand(Value.kReverse));
    }
}
