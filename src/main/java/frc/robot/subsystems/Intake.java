/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  Solenoid intakeSolenoid = new Solenoid(1);
  Compressor c = new Compressor(Constants.intake);
  
  public Intake() {

    c.setClosedLoopControl(true);
    retract();
    boolean enabled = c.enabled();
    boolean pressureSwitch = c.getPressureSwitchValue();
    double current = c.getCompressorCurrent();

  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void extend(){
    intakeSolenoid.set(true);
  }
  public void retract(){
    intakeSolenoid.set(false);
  }
}