/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.TurretTurn;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Servo; 
import com.revrobotics.CANAnalog; 
import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANPIDController; 
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;  


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Turret extends SubsystemBase {
  public static TalonSRX turretRotate = new TalonSRX(Constants.TurretRotate);
  public static WPI_TalonFX turretWheel1 = new WPI_TalonFX(Constants.LeftShooter);
  public static WPI_TalonFX turretWheel2 = new WPI_TalonFX(Constants.RightShooter);
  //public static Encoder turretEncoder = new Encoder(Constants.TurretEncoder); 
  public NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  //public CANSparkMax turretServo; 

   


  //public CANPIDController m_pidController; 

  //public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput; 
 // public CANAnalog m_analogSensor; 
   
  
  
 
  //public Encoder turretEncoder = new Encoder(Constants.TurretEncoder, 0); //why should it be set to 0, is that bc where it matches for the Constants?


  /**
   * Creates a new Turret.
   */
  public Turret() {

    
    /* turretServo = new CANSparkMax(Constants.deviceID, MotorType.kBrushless); 
    m_analogSensor = turretServo.getAnalog(CANAnalog.AnalogMode.kAbsolute);
    turretServo.restoreFactoryDefaults(); 
    m_pidController = turretServo.getPIDController(); 
    m_pidController.setFeedbackDevice(m_analogSensor); 
    */ 
    turretRotate = new TalonSRX(Constants.talonsrxturret); 
    turretRotate.setSensorPhase(false);
    turretRotate.setInverted(false);
    turretRotate.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    
   // m_analogSensor = turretServo.;

    //PID Coefficients 
   /* kP = 0.9; 
    kI = 0.1;
    kD = 0.1;
    kIz = 0.1; 
    kFF = 0.1; 
    kMaxOutput = 1; 
    kMinOutput = -1; */ 

   /* m_pidController.setP(kP); 
    m_pidController.setI(kI); 
    m_pidController.setD(kD); 
    m_pidController.setIZone(kIz); 
    m_pidController.setFF(kFF); 
    m_pidController.setOutputRange(kMinOutput, kMaxOutput); */ 

    SmartDashboard.putNumber("Turret Rotations", 0); 

    //turretServo.setNeutralMode(NeutralMode.Brake);
   // turretServo.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
   //this won't work bc turret servo is a Neo 550
  }

  public double getLimelightX() {
    return tx.getDouble(0);
  }

  public void lightsOn() {
    table.getEntry("ledMode").setNumber(3);
  }

  public void lightsOff() {
    table.getEntry("ledMode").setNumber(1);
  }
  
 // public double getTurretEncoder() {
  //  return turretEncoder.get(); 
 // }

  //public void resetEncoders() {
   // turretEncoder.reset(); 
 // }
 
 /* public void resetTurret() {

  } */ 

  @Override
  public void periodic() {

    double rotations = SmartDashboard.getNumber("Turret Rotations", 0); 
   // m_pidController.setReference(rotations, ControlType.kPosition); 
    SmartDashboard.putNumber("Turret Set Point", rotations); 
   // SmartDashboard.putNumber("Process Variable Conversion", m_analogSensor.getPositionConversionFactor()); 
   //SmartDashboard.putNumber("Process Variable Get Pos only", m_analogSensor()); 
  SmartDashboard.putNumber("Sensor Velocity", turretRotate.getSelectedSensorVelocity()); 
    SmartDashboard.putNumber("Sensor Position", turretRotate.getSelectedSensorPosition()); 
    
   


    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightX", y);
    SmartDashboard.putNumber("LimelightArea", area);
   // SmartDashboard.putNumber("Turret Encoder", turretEncoder); 
    // This method will be called once per scheduler run
  }

 public void setSpeed(double speed){
    turretRotate.set(ControlMode.PercentOutput, speed);
    //turretServo.getFaults(_faults); 
  
  }
  public void stopTurret(){
    turretRotate.set(ControlMode.PercentOutput, 0);
  }

public void startWheel() {
  turretWheel1.set(ControlMode.PercentOutput, .5);
  turretWheel2.set(ControlMode.PercentOutput, .5);
}
public void stopWheel() {
  turretWheel1.set(ControlMode.PercentOutput, 0);
  turretWheel2.set(ControlMode.PercentOutput, 0);
}
}
