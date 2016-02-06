package org.usfirst.frc.team1100.robot.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestGrip extends Command {

	NetworkTable table;
	double[] defaultValue;

	@Override
	protected void initialize() {

		table = NetworkTable.getTable("GRIP/myContoursReport");
		defaultValue = new double[0];
	}

	@Override
	protected void execute() {
		// while(!isFinished()){
		int i = 0;
		double[] area = table.getNumberArray("area", defaultValue);
		double[] height = table.getNumberArray("height", defaultValue);
		double[] width = table.getNumberArray("width", defaultValue);
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		double[] centerY = table.getNumberArray("centerY", defaultValue);
		for (double a : area) {
			SmartDashboard.putNumber("AreaTest", a);
		}
		for (double h : height) {
			SmartDashboard.putNumber("HeigthTest", h);
		}
		for (double w : width) {
			SmartDashboard.putNumber("WidthTest", w);
		}
		for (double x : centerX) {
			SmartDashboard.putNumber("CenterXTest", x);
		}
		for (double y : centerY) {
			SmartDashboard.putNumber("CenterYTest", y);
		}
		SmartDashboard.putNumber("ExecutableLoop", i);
		i++;
		// }
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
