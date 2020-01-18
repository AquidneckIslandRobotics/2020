/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.TurretTurn;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import edu.wpi.first.wpilibj.util.Color; 
import com.revrobotics.ColorSensorV3; 

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private final I2C.Port i2cPort = I2C.Port.kOnboard; 
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort); 
  public static Turret m_turret = new Turret();

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    m_turret.setDefaultCommand(new TurretTurn());
    //m_turret.lightsOff();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
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

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}