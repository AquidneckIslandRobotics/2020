/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.sensors.PigeonIMU_StatusFrame;
import com.ctre.phoenix.sensors.PigeonIMU;

public class Drive extends SubsystemBase {
  public WPI_TalonSRX leftLeader = new WPI_TalonSRX(Constants.LeftLeader);
  public WPI_TalonSRX leftFollower1 = new WPI_TalonSRX(Constants.LeftFollower1);
  public WPI_TalonSRX leftFollower2 = new WPI_TalonSRX(Constants.LeftFollower2);
  public WPI_TalonSRX rightLeader = new WPI_TalonSRX(Constants.RightLeader);
  public WPI_TalonSRX rightFollower1 = new WPI_TalonSRX(Constants.RightFollower1);
  public WPI_TalonSRX rightFollower2 = new WPI_TalonSRX(Constants.RightFollower2);
  DifferentialDrive diffDrive = new DifferentialDrive(leftLeader, rightLeader);
  PigeonIMU _pidgey;

  final int kPigeonID = 30;
  /**
   * Creates a new Drive.
   */
  public Drive() {
    System.out.println("Starting Drive");
   leftFollower1.follow(leftLeader);
   leftFollower2.follow(leftLeader);
   rightFollower1.follow(rightLeader);
   rightFollower2.follow(rightLeader);

   double speed = 0.5;
   double rotation = 0.5;
   boolean quickTurn = true;
   diffDrive.curvatureDrive(speed, rotation, quickTurn);

    _pidgey = new PigeonIMU(kPigeonID);

  boolean _firstCall = false;
  boolean _state = false;
  double _targetAngle = 0;
  int _smoothing;
  
  rightLeader.set(ControlMode.PercentOutput, 0);
  leftLeader.set(ControlMode.PercentOutput, 0);

  rightLeader.configFactoryDefault();
  leftLeader.configFactoryDefault();
  _pidgey.configFactoryDefault();

  leftLeader.setNeutralMode(NeutralMode.Brake);
  rightLeader.setNeutralMode(NeutralMode.Brake);

  leftLeader.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.PID_PRIMARY, Constants.kTimeoutMs);
  rightLeader.configRemoteFeedbackFilter(leftLeader.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor,
        Constants.REMOTE_0, Constants.kTimeoutMs);
  rightLeader.configRemoteFeedbackFilter(_pidgey.getDeviceID(), RemoteSensorSource.Pigeon_Yaw, Constants.REMOTE_1, Constants.kTimeoutMs);
  
  rightLeader.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.RemoteSensor0, Constants.kTimeoutMs);
  rightLeader.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kTimeoutMs);

  rightLeader.configSelectedFeedbackSensor(FeedbackDevice.SensorSum, Constants.PID_PRIMARY, Constants.kTimeoutMs);
  rightLeader.configSelectedFeedbackCoefficient(0.5, Constants.PID_PRIMARY, Constants.kTimeoutMs);
  rightLeader.configSelectedFeedbackSensor(FeedbackDevice.RemoteSensor1, Constants.PID_TURN, Constants.kTimeoutMs);
  rightLeader.configSelectedFeedbackCoefficient(1, Constants.PID_TURN, Constants.kTimeoutMs);

  leftLeader.setInverted(false);
  leftLeader.setSensorPhase(true);
  rightLeader.setInverted(true);
  rightLeader.setSensorPhase(true);

  rightLeader.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, Constants.kTimeoutMs);
	rightLeader.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, Constants.kTimeoutMs);
	rightLeader.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 20, Constants.kTimeoutMs);
	rightLeader.setStatusFramePeriod(StatusFrame.Status_10_Targets, 20, Constants.kTimeoutMs);
	leftLeader.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, Constants.kTimeoutMs);
  _pidgey.setStatusFramePeriod(PigeonIMU_StatusFrame.CondStatus_9_SixDeg_YPR , 5, Constants.kTimeoutMs);
  
  rightLeader.configNeutralDeadband(Constants.kNeutralDeadband, Constants.kTimeoutMs);
	leftLeader.configNeutralDeadband(Constants.kNeutralDeadband, Constants.kTimeoutMs);

  rightLeader.configMotionAcceleration(2000, Constants.kTimeoutMs);
  rightLeader.configMotionCruiseVelocity(2000, Constants.kTimeoutMs);
  
  leftLeader.configPeakOutputForward(+1.0, Constants.kTimeoutMs);
	leftLeader.configPeakOutputReverse(-1.0, Constants.kTimeoutMs);
	rightLeader.configPeakOutputForward(+1.0, Constants.kTimeoutMs);
  rightLeader.configPeakOutputReverse(-1.0, Constants.kTimeoutMs);
  
  rightLeader.config_kP(Constants.kSlot_Distanc, 0.1, Constants.kTimeoutMs);
  rightLeader.config_kI(Constants.kSlot_Distanc, 0.0, Constants.kTimeoutMs);
	rightLeader.config_kD(Constants.kSlot_Distanc, 0.0, Constants.kTimeoutMs);
  rightLeader.config_kF(Constants.kSlot_Distanc, 0.0, Constants.kTimeoutMs);
	rightLeader.config_IntegralZone(Constants.kSlot_Distanc, 100, Constants.kTimeoutMs);
	rightLeader.configClosedLoopPeakOutput(Constants.kSlot_Distanc, 0.5, Constants.kTimeoutMs);

  rightLeader.config_kP(Constants.kSlot_Turning, 2.00, Constants.kTimeoutMs);
  rightLeader.config_kI(Constants.kSlot_Turning, 0.0, Constants.kTimeoutMs);
  rightLeader.config_kD(Constants.kSlot_Turning, 4.0, Constants.kTimeoutMs);
  rightLeader.config_kF(Constants.kSlot_Turning, 0.0, Constants.kTimeoutMs);
  rightLeader.config_IntegralZone(Constants.kSlot_Turning, 200, Constants.kTimeoutMs);
  rightLeader.configClosedLoopPeakOutput(Constants.kSlot_Turning, 1.00, Constants.kTimeoutMs);

  int closedLoopTimeMs = 1;
  rightLeader.configClosedLoopPeriod(0, closedLoopTimeMs, Constants.kTimeoutMs);
  rightLeader.configClosedLoopPeriod(1, closedLoopTimeMs, Constants.kTimeoutMs);

  rightLeader.configAuxPIDPolarity(false, Constants.kTimeoutMs);

  _firstCall = true;
  _state = false;
  rightLeader.setStatusFramePeriod(StatusFrameEnhanced.Status_10_Targets, 10);

}
public void curvatureDrive(double speed, double rotation, boolean quickTurn){
    diffDrive.curvatureDrive(speed, rotation, quickTurn);
  }

  @Override
  public void periodic() {
    double [] accumgyro = new double [3];
    _pidgey.getAccumGyro(accumgyro);
    System.out.println("X: " + accumgyro[0] + " Y: " + accumgyro[1] + " Z: " +accumgyro[2]) ;
    
  }    
    
    // This method will be called once per scheduler run
  }

