/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Drive extends SubsystemBase {
  TalonFX leftLeader = new TalonFX(Constants.LeftLeader);
    TalonFX leftFollower1 = new TalonFX(Constants.LeftFollower1);
    TalonSRX leftFollower2 = new TalonSRX(Constants.LeftFollower2);
    TalonFX rightLeader = new TalonFX(Constants.RightLeader);
    TalonFX rightFollower1 = new TalonFX(Constants.RightFollower1);
    TalonSRX rightFollower2 = new TalonSRX(Constants.RightFollower2);
    //TalonFX testMotor = new TalonFX(Constants.testMotor);
    //DifferentialDrive diffDrive = new DifferentialDrive(leftLeader, rightLeader);
  /**
   * Creates a new Drive.
   */
  public Drive() {
    leftFollower1.configFactoryDefault();
    leftFollower2.configFactoryDefault();
   leftFollower1.follow(leftLeader);
   leftFollower2.follow(leftLeader);
   rightFollower1.configFactoryDefault();
   rightFollower2.configFactoryDefault();
   rightFollower1.follow(rightLeader);
   rightFollower2.follow(rightLeader);
   leftLeader.setInverted(true);
   leftFollower1.setInverted(true);
   leftFollower2.setInverted(true);

   double speed = 0.5;
   double rotation = 0.5;
   boolean quickTurn = true;
   //diffDrive.curvatureDrive(speed, rotation, quickTurn);


leftLeader.configFactoryDefault();
   leftLeader.follow(rightLeader);
   rightLeader.configFactoryDefault();
   //testMotor.configFactoryDefault();
   
   leftLeader.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.PID_PRIMARY, Constants.kTimeoutMs);
   rightLeader.configRemoteFeedbackFilter(leftLeader.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor, Constants.REMOTE_0, Constants.kTimeoutMs);
   rightLeader.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.RemoteSensor0, Constants.kTimeoutMs);
   rightLeader.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.CTRE_MagEncoder_Absolute, Constants.kTimeoutMs);
    rightLeader.configSelectedFeedbackSensor(FeedbackDevice.SensorSum, Constants.PID_PRIMARY, Constants.kTimeoutMs);
   rightLeader.configSelectedFeedbackCoefficient(0.5, Constants.PID_PRIMARY, Constants.kTimeoutMs); 
   rightLeader.configNeutralDeadband(.001, 30);
   leftLeader.setInverted(true);
   leftLeader.setSensorPhase(true);
   rightLeader.setSensorPhase(false);
   rightLeader.setInverted(false);
   //testMotor.setInverted(true);
   rightLeader.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 30);
   rightLeader.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 10, 30);

   rightLeader.configNominalOutputForward(0, 30);
   rightLeader.configNominalOutputReverse(0, 30);
   rightLeader.configPeakOutputForward(1, 30);
   rightLeader.configPeakOutputReverse(-1, 30);

   rightLeader.selectProfileSlot(0, 0);
   rightLeader.config_kF(0, 0.1, 30);
   rightLeader.config_kP(0, .4, 30);
   rightLeader.config_kI(0, .001, 30);
   rightLeader.config_kD(0, 4, 30);
   rightLeader.configMotionCruiseVelocity(3000, 30);
   rightLeader.configMotionAcceleration(937, 30);

   rightLeader.setSelectedSensorPosition(0, 0, 30);
  }
  public void curvatureDrive(double speed, double rotation, boolean quickTurn){
    //diffDrive.curvatureDrive(speed, rotation, quickTurn);
  }
  public void setPoint(double rotation){
    rightLeader.set(ControlMode.MotionMagic, rotation);
    SmartDashboard.putNumber("error", rightLeader.getClosedLoopError(0));
    SmartDashboard.putNumber("Output", rightLeader.getMotorOutputPercent());

  }
  public void stop(){
    rightLeader.set(ControlMode.PercentOutput, 0);



  }
public void driveForward(double speed){
  leftLeader.set(ControlMode.PercentOutput, speed);
}


  @Override
  public void periodic() {
    SmartDashboard.putString("Mode",rightLeader.getControlMode().toString());
    SmartDashboard.putData("Drive", this);
    System.out.println("accel"+rightLeader.getSelectedSensorVelocity());
    //double x = SmartDashboard.getNumber("SetPoing", 0);
    //rightLeader.set(ControlMode.MotionMagic, 15000);
    // This method will be called once per scheduler run
  }
  public void resetEncoder(){
    rightLeader.setSelectedSensorPosition(0);
  }
}
