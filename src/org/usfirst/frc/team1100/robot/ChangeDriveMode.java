package org.usfirst.frc.team1100.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ChangeDriveMode extends Command{
	boolean f;
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		f = false;
	}

	@Override
	protected void execute() {
		if(OI.getMethod()==2)
			OI.setMethod(0);
		else
			OI.setMethod(OI.getMethod()+1);
		SmartDashboard.putNumber("Drive Mode", OI.getMethod());
		f = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return f;
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
