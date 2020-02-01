/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int LeftLeader = 2;
    public static final int LeftFollower1 = 1;
    //public static final int LeftFollower2 = 21;
    public static final int RightLeader = 3;
    public static final int RightFollower1 = 4;
    //public static final int RightFollower2 = 16;
    public static final int LeftElevator = 5;
    public static final int RightElevator = 10;
    public static final int Shooter1 = 17;
    public static final int Shooter2 = 18;


    public static final int TurretServo = 62;
    public static final int TurretWheel1 = 7;
    public static final int TurretWheel2 = 6;
	public static boolean kSensorPhase = false;
	public static int kTimeoutMs = 0;
	public static int kPIDLoopIdx = 0;
    public static boolean kMotorInvert = false;

    public static final int ColorMotor = 8;//7; 
    
    //Encoders
    public static final int TurretEncoder = 0;
    public static final double DRIVE_DISTANCE = -14;
	public static final int PID_PRIMARY = 0;
	public static final int REMOTE_0 = 0; 
}



