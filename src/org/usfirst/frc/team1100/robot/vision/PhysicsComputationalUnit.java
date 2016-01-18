package org.usfirst.frc.team1100.robot.vision;

public class PhysicsComputationalUnit {
	private final double THETA = Math.toRadians(30); //Special thanks to Jacob for solving this problem after 90 minutes of stalling
	private final float SPRING_CONSTANT = 4000;
	private final float MASS_OF_BOULDER = 0.1f;
	private final float RELATIVE_TOWER_HEIGHT = 2;
	
	public double getRange(float springCompressed) {
		double part1 = cos2(THETA);
		double part2 = 5*pow(SPRING_CONSTANT,2)*pow(springCompressed,4)*tan(THETA);
		double part3 = 5*pow(SPRING_CONSTANT,2)*pow(springCompressed,4)*tan2(THETA);
		double part4 = 98*RELATIVE_TOWER_HEIGHT*pow(MASS_OF_BOULDER,2)*sec2(THETA);
		double part5 = sqrt(5)*sqrt(pow(SPRING_CONSTANT,2)*pow(springCompressed,4)*(part3-part4));
		double numerator = part1*(part2-part5);
		double denominator = 49*Math.pow(MASS_OF_BOULDER, 2);
		return numerator/denominator;
	}
	
	public double getSpringCompressionDistance(float distance) {
		double numerator = sqrt(7)*sqrt(MASS_OF_BOULDER)*sqrt(distance)*sqrt(sec(THETA));
		double denominator = Math.pow(10,1.0/4.0)*Math.pow(-1*SPRING_CONSTANT*(RELATIVE_TOWER_HEIGHT-distance*tan(THETA)), 1.0/4.0);
		return numerator/denominator;
	}
	
	private double cos(double d) {
		return Math.cos(d);
	}
	
	private double tan(double d) {
		return Math.tan(d);
	}
	
	private double sec(double d) {
		return (1/Math.cos(d));
	}
	
	private double sec2(double d) {
		return 2/(Math.cos(2*d)+1);
	}
	
	private double pow(double d, int i) {
		return Math.pow(d, i);
	}
	
	private double sqrt(double d) {
		return Math.sqrt(d);
	}
	
	private double cos2(double d) {
		return (cos(2*d)+1)/2;
	}
	
	private double tan2(double d) {
		return (1-cos(2*d))/(cos(2*d)+1);
	}
	
	public static void main(String[] args) {
		PhysicsComputationalUnit physics = new PhysicsComputationalUnit();
		System.out.println(physics.getSpringCompressionDistance(3.5f));
	}
}
