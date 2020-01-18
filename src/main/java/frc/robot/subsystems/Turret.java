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
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.TurretTurn;
import edu.wpi.first.wpilibj.Encoder; 
import edu.wpi.first.wpilibj.Servo; 



public class Turret extends SubsystemBase {
  public static TalonSRX turretServo = new TalonSRX(Constants.TurretServo);

  public NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  /**
   * Creates a new Turret.
   */
  public Turret() {
    turretServo.setNeutralMode(NeutralMode.Brake);
    turretServo.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
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
  
 
 /* public void resetTurret() {

  } */ 

  @Override
  public void periodic() {
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightX", y);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("Turret Encoder", )
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed){
    turretServo.set(ControlMode.PercentOutput, speed);
  }
  public void stopTurret(){
    turretServo.set(ControlMode.PercentOutput, 0);
  }
}
