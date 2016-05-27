package org.usfirst.frc.team1100.robot.commands;

import org.usfirst.frc.team1100.robot.commands.drive.DriveBackwardsUntilUltrasonicCommand;
import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireInHigh extends CommandGroup {
    
    public  FireInHigh() {
    	addSequential(new DriveBackwardsUntilUltrasonicCommand());
    	addSequential(new DriveCommand(0,-0.5,0.5));
    	addSequential(new FireThenReset());
    }
}
