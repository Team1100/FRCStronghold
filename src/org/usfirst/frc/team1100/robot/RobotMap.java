package org.usfirst.frc.team1100.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//t indicates temporary value
	
	//[D]RIVE TRAIN
	public static final int D_LEFT_FRONT = 1; 
	//public static final int D_LEFT_MID = 2;//t
	//public static final int D_LEFT_BACK = 3;//t
	public static final int D_RIGHT_FRONT = 2;
	//public static final int D_RIGHT_MID = 2;//t
	//public static final int D_RIGHT_BACK = 3;//t
	public static final int D_GYRO = 3;//t
	//[V]ISION
	//public static final int V_CAMERA = 0;//t
	//[S]HOOTER
	public static final int S_BELT = 4;//t
	public static final int S_FIRE_1 = 5;//t
	public static final int S_FIRE_2 = 6;//t
	//[I]NTAKE
	//[J]OYSTICKS
	public static final int J_LEFT = 0;
	public static final int J_RIGHT = 1;
	public static final int J_X = 2;
	//[E]NCODERS
	//public static final int E_POLAR_SHOOTER = 0;//t
}
