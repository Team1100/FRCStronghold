package org.usfirst.frc.team1100.robot.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestGrip extends Command {

	NetworkTable table;
	double[] defaultValue;

	@Override
	protected void initialize() {

		table = NetworkTable.getTable("grip");
		defaultValue = new double[0];
	}

	@Override
	protected void execute() {
		double[] area = table.getNumberArray("myContoursReport/area", defaultValue);
		double[] height = table.getNumberArray("myContoursReport/height", defaultValue);
		double[] width = table.getNumberArray("myContoursReport/width", defaultValue);
		double[] centerX = table.getNumberArray("myContoursReport/centerX", defaultValue);
		double[] centerY = table.getNumberArray("myContoursReport/centerY", defaultValue);
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
