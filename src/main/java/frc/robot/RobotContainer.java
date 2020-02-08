/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.AutoColor;
import frc.robot.commands.ColorSpinTarget;
import frc.robot.commands.ColorSpinThree;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.DriveTo;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FlipDirection;
import frc.robot.commands.TurretTarget;
import frc.robot.commands.TurretTurn;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.subsystems.Drive;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public static XboxController manipulatorJoystick = new XboxController(0); 
  public static XboxController drivingJoystick1 = new XboxController(1);
  public static XboxController colorJoystick = new XboxController(2); 
  public static XboxController patheticExtraJoystick = new XboxController(5); 


 public static double getRightX() {
    //Get raw value from joystick
    double rightX = colorJoystick.getX(Hand.kRight);
    //Check for deadzone
    if (Math.abs(rightX) < 0.05) {
      rightX = 0;
    }
    //Return adjusted value
    return rightX;

    
  }

  public static double rightXm() {
    //Get raw value from joystick
    double rightXmm = manipulatorJoystick.getX(Hand.kRight);
    //Check for deadzone
    if (Math.abs(rightXmm) < 0.05) {
      rightXmm = 0;
    }
    //Return adjusted value
    return rightXmm;
  }
  

  
  Button driverY = new JoystickButton(drivingJoystick1, 4);
  Button driverA = new JoystickButton(drivingJoystick1, 1);
  Button driverB = new JoystickButton(drivingJoystick1, 2);
  Button driverX = new JoystickButton(drivingJoystick1, 3);
  Button driverLB = new JoystickButton(drivingJoystick1, 5); 
  Button driverRB = new JoystickButton(drivingJoystick1, 6); 
  Button testButton = new JoystickButton(drivingJoystick1, 7); 


  //Button leftYstick = new JoystickButton(drivingJoystick1, 2);
  

  Button manipulatorB = new JoystickButton(manipulatorJoystick, 2); 
  Button manipulatorX = new JoystickButton(manipulatorJoystick, 3); 
  Button manipulatorY = new JoystickButton(manipulatorJoystick, 4); 



  Button colorA = new JoystickButton(colorJoystick, 1); 
  Button colorB = new JoystickButton(colorJoystick, 2); 
  Button colorX = new JoystickButton(colorJoystick, 3); 
  Button colorY = new JoystickButton(colorJoystick, 4); 
  Button driverStart = new JoystickButton(colorJoystick, 8); 
  Button driverBack = new JoystickButton(colorJoystick, 7); 

  Button patheticExtraButton = new JoystickButton(patheticExtraJoystick, 3); 

  // A is green, B is red, X is blue and Y is yellow.

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public final Drive m_drive = new Drive();
  //public final ColorSensor m_colorsensor = new ColorSensor(); 
  public final DriveTo m_auto = new DriveTo(m_drive, -10);

  public final Turret m_turret = new Turret(); 


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
   
    
    // Configure the button bindings
    configureButtonBindings();
    //m_drive.setDefaultCommand(new DefaultDrive(m_drive, drivingJoystick1, button));
    //m_drive.setDefaultCommand(new DriveTo(m_drive, 100));
    manipulatorY.whenPressed(new DriveTo(m_drive, Constants.DRIVE_DISTANCE));
     
       m_drive.setDefaultCommand(new DefaultDrive(m_drive, drivingJoystick1, patheticExtraButton));

   //m_drive.setDefaultCommand(new DefaultDrive(m_drive, drivingJoystick1, button));
    driverA.whileHeld(new TurretTarget()); 
    // m_drive.setDefaultCommand(new driveTest(m_drive));
    
    //m_drive.setDefaultCommand(new DefaultDrive(m_drive, drivingJoystick1, button));
    manipulatorY.whenPressed(new DriveTo(m_drive, 8));
     
   // m_turret.setDefaultCommand(new TurretTurn(m_turret));

    
  }

  public static double getSpeed() {
    double speed = drivingJoystick1.getY(Hand.kLeft); 
    if(Math.abs(speed) < 0.12 ) return 0; 
    else if(Robot.m_drive.yeeting) {
      if (speed > 0) return Math.pow(speed, 2); 
      else return -Math.pow(speed, 2); 
    } else {
      if(speed > 0) return Math.pow(speed, 2) * 0.5; // this should be going half speed
      else return -Math.pow(speed, 2) * 0.5; 
    }
    
  }

  public double getRotation() {
    double rotation = -drivingJoystick1.getX(Hand.kRight); 
    if(Math.abs(rotation) < 0.12) return 0; 
    else if(Robot.m_drive.yeeting) {
      if (rotation > 0) return Math.pow(rotation, 2) * 0.5; 
      else return -Math.pow(rotation, 2) *0.5; 
    } else {
      if (rotation > 0) return Math.pow(rotation, 2) * 0.5; 
      else return -Math.pow(rotation, 2) * 0.5; 
    }
  }

  public boolean getQuickTurn() {
    return driverRB.get(); 
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driverA.whileHeld(new TurretTarget());

    driverY.whenPressed(new YeetButton()); 
    driverY.whenReleased(new Unyeet()); 

    manipulatorB.whileHeld(new TurretTurn(m_turret, .5)); 
    manipulatorX.whileHeld(new TurretTurn(m_turret, -.5)); 




   // driverX.whenPressed(new LightsOn());
    driverStart.whenPressed(new ColorSpinThree());
    driverBack.whileHeld(new ColorSpinTarget()); 
    driverLB.whenPressed(new FlipDirection(Robot.m_drive)); 
    colorA.whenPressed(new AutoColor("green"));
    
    
   //driverX.whenReleased(new LightsOff()); these lines aren't needed bc the limelight already turns off after A is released
    testButton.whenHeld(new DriveTo(m_drive, 5));
   colorA.whenPressed(new AutoColor("Green"));
   colorB.whenPressed(new AutoColor("Red"));
   colorX.whenPressed(new AutoColor("Blue"));
   colorY.whenPressed(new AutoColor("Yellow"));


   //yeet
  
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}