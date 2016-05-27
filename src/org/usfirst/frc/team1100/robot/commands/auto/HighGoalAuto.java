package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.drive.DriveBackwardsUntilUltrasonicCommand;
import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.commands.intake.LiftIntake;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class HighGoalAuto extends CommandGroup {
    
    public  HighGoalAuto() {
        addSequential(new DriveCommand(0.7,0.7,3));
        addSequential(new DriveCommand(0.5,0.8,4));
        addSequential(new DriveCommand(0.8,0.6,1)); //Begin nice alignment
        addSequential(new DriveCommand(0.8,0,0.2)); //Continue nice alignment
        addSequential(new DriveCommand(0,0.8,0.2)); //Continue nice alignment
        addSequential(new DriveCommand(0.8,0.6,1)); //Finish nice alignment
        addSequential(new LiftIntake(.9, -.9));
        addSequential(new DriveBackwardsUntilUltrasonicCommand());
        //addSequential(new ToggleBrakeCommand());
        addSequential(new WaitCommand(0.5));
        addSequential(new DriveCommand(0,-0.5,0.5));
        addSequential(new FireThenReset());
        addSequential(new DriveCommand(-0.7,-0.7,2));
    }
}
