/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ColorSensor extends SubsystemBase {
  private final I2C.Port i2cPort = I2C.Port.kOnboard; 
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort); 
  public static VictorSPX colorMotor = new VictorSPX(Constants.ColorMotor);
  /**
   * Creates a new ColorSensor.
   */
  public ColorSensor() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    CommandScheduler.getInstance().run();
    Color detectedColor = m_colorSensor.getColor(); 
    double IR = m_colorSensor.getIR(); 
   SmartDashboard.putNumber("Red", detectedColor.red); 
   SmartDashboard.putNumber("Green", detectedColor.green);  
   SmartDashboard.putNumber("Blue", detectedColor.blue);  
   SmartDashboard.putNumber("IR", IR); 
   SmartDashboard.putString("Color", colorDetector(detectedColor));
   
   SmartDashboard.putNumber("Right X", RobotContainer.getRightX());
   int proximity = m_colorSensor.getProximity(); 
   SmartDashboard.putNumber("Proximity", proximity); 
   }
   public String colorDetector(Color detectedColor){
     if(detectedColor.blue > .35){ 
     return "Blue"; 
     }else if(detectedColor.green > .5 && detectedColor.red < .200){
       return "Green";
     }else if(detectedColor.red > .47 && detectedColor.green > .3){
       return "Red";
     }else if(detectedColor.green > .53 && detectedColor.red > .29){
       return "Yellow";
     }else{
       return "Unkown";
     }
  }
}
