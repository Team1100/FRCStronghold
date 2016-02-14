package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import org.usfirst.frc.team1100.robot.commands.shooter.SetKickerCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.SetLatchCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.SetResetCommand;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ResetShooterCommandGroup extends CommandGroup {

	public  ResetShooterCommandGroup() {
    	if(!Shooter.getInstance().isReset()){
	    	addSequential(new SetKickerCommand(Value.kReverse));
	    	addSequential(new WaitCommand(.5));
	    	addSequential(new SetResetCommand(Value.kForward));
	    	addSequential(new WaitCommand(.5));
	    	addSequential(new SetLatchCommand(Value.kForward));
	    	addSequential(new WaitCommand(.5));
	    	addSequential(new SetResetCommand(Value.kReverse));
	    	addSequential(new WaitCommand(.5));
	    	addSequential(new SetKickerCommand(Value.kForward));
    	}
    }
}