package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import org.usfirst.frc.team1100.robot.commands.shooter.SetFillCommand;
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
    		addSequential(new WaitCommand(.75));
	    	addSequential(new SetFillCommand(Value.kReverse));//vent the fill
	    	addSequential(new WaitCommand(.5));
	    	addSequential(new SetResetCommand(Value.kForward));//reset
	    	addSequential(new WaitCommand(.75));
	    	addSequential(new SetLatchCommand(Value.kForward));//pull down latch
	    	addSequential(new WaitCommand(.75));
	    	addSequential(new SetResetCommand(Value.kReverse));//retract reset piston
	    	addSequential(new WaitCommand(.5));
	    	addSequential(new SetFillCommand(Value.kForward));//extend fill
    	}
    }
}