package org.usfirst.frc.team1100.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.command.Command;

public class StartGrip extends Command {

	boolean isFinished;
	
	@Override
	protected void initialize() {
		isFinished = false;
	}

	@Override
	protected void execute() {
		try {
			new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		
		return isFinished;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
