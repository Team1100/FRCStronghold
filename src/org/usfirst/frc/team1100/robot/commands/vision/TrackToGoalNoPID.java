package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Intake;
import org.usfirst.frc.team1100.robot.subsystems.Lift;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrackToGoalNoPID extends Command{

	public TrackToGoalNoPID(){
		requires(Lift.getInstance());
		requires(Intake.getInstance());
	}
	
	private boolean isFinished;
	
	@Override
	protected void initialize() {
		isFinished = false;
	}

	@Override
	protected void execute() {
		if(Vision.getInstance().getY()==0)return;
		if(Vision.getInstance().getY()>212){
			Lift.getInstance().moveArm(0);
		}
		if(Vision.getInstance().getY()<212){
			Lift.getInstance().moveArm(-.3);
		}
		if(Vision.getInstance().getY()==212&&Lift.getInstance().getSpeed()<0){
			isFinished = true;
			Lift.getInstance().moveArm(-.2);
		}
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
