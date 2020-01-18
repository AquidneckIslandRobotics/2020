/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants; 
import com.ctre.phoenix.motorcontrol.NeutralMode; 


public class Turret extends SubsystemBase {
  TalonSRX turretServo = new TalonSRX(Constants.TurretServo); 
  /**
   * Creates a new Turret.
   */
  public Turret() {
 turretServo.setNeutralMode(NeutralMode.Brake); 
    
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
public void setSpeed(double speed) {
  turretServo.set(ControlMode.PercentOutput, speed); 

  }

public void stopTurret(){
  turretServo.set(ControlMode.PercentOutput, 0); 
}
}
