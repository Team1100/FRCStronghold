package org.usfirst.frc.team1100.robot.commands.ultrasound;

import org.usfirst.frc.team1100.robot.subsystems.Ultrasound;

import edu.wpi.first.wpilibj.command.Command;

public class PollSensors extends Command{

	public PollSensors(){
		requires(Ultrasound.getInstance());
	}
	
	@Override
	protected void initialize() {		
	}

	@Override
	protected void execute() {
		Ultrasound.getInstance().addEZ1Data();
		Ultrasound.getInstance().addEZ3Data();
		Ultrasound.getInstance().setDistanceEZ1();
		Ultrasound.getInstance().setDistanceEZ3();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {		
	}

	@Override
	protected void interrupted() {		
	}

}
