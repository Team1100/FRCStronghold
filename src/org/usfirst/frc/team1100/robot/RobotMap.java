package org.usfirst.frc.team1100.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//TODO: t indicates temporary value
	
	//[D]RIVE TRAIN
	public static final int D_LEFT_FRONT = 0; //t
	public static final int D_LEFT_MID = 1;//t
	public static final int D_LEFT_BACK = 2;//t
	public static final int D_RIGHT_FRONT = 3;//t
	public static final int D_RIGHT_MID = 4;//t
	public static final int D_RIGHT_BACK = 5;//t
	//[V]ISION
	public static final int V_CAMERA = 314;//t
	//[S]HOOTER
	public static final int S_KICKER_PNEUMATIC = 0;//t
	public static final int S_RESET_PNEUMATIC = 1;//t
	public static final int S_LATCH_PNEUMATIC = 2;//t
	public static final int S_KICKER_SENSOR = 1;//t
	//[I]NTAKE
	public static final int I_INTAKE_ROLLER = 3;//t
	public static final int I_INTAKE_LIFT = 4;//t
	public static final int I_INTAKE_LIFT_ENCODER = 5;//t
	//[L]IFT
	public static final int L_CLUTCH_PNEUMATIC = 3;//t
	public static final int L_ARM_LIFT_MOTOR_1 = 0;//t
	public static final int L_ARM_LIFT_MOTOR_2 = 1;//t
	public static final int L_ARM_LIFT_ENCODER = 0;//t
	//[C]LLIMB
	public static final int C_HOOK_EXTEND_MOTOR = 2;//t
	//[J]OYSTICKS
	public static final int J_LEFT = 0;
	public static final int J_RIGHT = 1;
	public static final int J_X = 2;
	//[U]LTRASONIC
	public static final int U_EZ3 = 0;
	public static final int U_EZ1 = 1;
	public static final int U_UNKNOWN = 2;
	//[E]NCODERS AND SENSORS
	
}
