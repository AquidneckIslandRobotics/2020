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
    public static final int LeftLeader = 1;
    public static final int LeftFollower1 = 3;
    public static final int LeftFollower2 = 2;
    public static final int RightLeader = 15;
    public static final int RightFollower1 = 14;
    public static final int RightFollower2 = 16;
    public static final int LeftElevator = 5;
    public static final int RightElevator = 10;

<<<<<<< HEAD
    public static final int TurretServo = 6; //this is not the right position
    public static final int kPIDLoopIdx = 0;
    public static final int kTimeoutMs = 0; 
    public static final int kSensorPhase = 0; 
    public static final int kMotorInvert = 0;
=======
    public static final int TurretServo = 6;
	public static boolean kSensorPhase = false;
	public static int kTimeoutMs = 0;
	public static int kPIDLoopIdx = 0;
    public static boolean kMotorInvert = false;
	public static double kF = 0;
	public static double kP = 0;
	public static double kI = 0;
	public static double kD = 0;
>>>>>>> 9ad0dada0489f2f0b34efd7f0694aa44603c6528
}

