/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.AutoColor;
import frc.robot.commands.ColorSpinTarget;
import frc.robot.commands.ColorSpinThree;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.DriveTo;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TurretTarget;
import frc.robot.subsystems.ExampleSubsystem;
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

  public static XboxController drivingJoystick1 = new XboxController(1);
  public static XboxController colorJoystick = new XboxController(2);


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

  
  

  Button button = new JoystickButton(drivingJoystick1, 6);
  Button button1 = new JoystickButton(drivingJoystick1, 4);
  Button driverA = new JoystickButton(drivingJoystick1, 1);
  Button driverB = new JoystickButton(drivingJoystick1, 2);
  Button driverX = new JoystickButton(drivingJoystick1, 3);
  Button testButton = new JoystickButton(drivingJoystick1, 7); 


  //Button leftYstick = new JoystickButton(drivingJoystick1, 2);

  Button colorA = new JoystickButton(colorJoystick, 1);
  Button colorB = new JoystickButton(colorJoystick, 2);
  Button colorX = new JoystickButton(colorJoystick, 3);
  Button colorY = new JoystickButton(colorJoystick, 4);
  Button driverStart = new JoystickButton(colorJoystick, 8);
  Button driverBack = new JoystickButton(colorJoystick, 7);
  // A is green, B is red, X is blue and Y is yellow.

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public final Drive m_drive = new Drive();
  //public final ColorSensor m_colorsensor = new ColorSensor(); 
  public final DriveTo m_auto = new DriveTo(m_drive, -10);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
   
    
    // Configure the button bindings
    configureButtonBindings();
    //m_drive.setDefaultCommand(new DefaultDrive(m_drive, drivingJoystick1, button));
    //m_drive.setDefaultCommand(new DriveTo(m_drive, 100));
    button1.whenPressed(new DriveTo(m_drive, Constants.DRIVE_DISTANCE));
     
       m_drive.setDefaultCommand(new DefaultDrive(m_drive, drivingJoystick1, button));

   //m_drive.setDefaultCommand(new DefaultDrive(m_drive, drivingJoystick1, button));
    driverA.whileHeld(new TurretTarget()); 
    // m_drive.setDefaultCommand(new driveTest(m_drive));
    
    
  }

  public double getSpeed() {
    double speed = drivingJoystick1.getY(Hand.kLeft); 
    if(Math.abs(speed) < 0.12 ) return 0; 
    else return speed; 
  }

  public double getRotation() {
    double rotation = -drivingJoystick1.getX(Hand.kRight); 
    if(Math.abs(rotation) < 0.12) return 0; 
    else return rotation; 
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driverA.whileHeld(new TurretTarget());
   // driverX.whenPressed(new LightsOn());
    driverStart.whenPressed(new ColorSpinThree());
    driverBack.whileHeld(new ColorSpinTarget());
   //driverX.whenReleased(new LightsOff()); these lines aren't needed bc the limelight already turns off after A is released
    testButton.whenHeld(new DriveTo(m_drive, 5));
   colorA.whenPressed(new AutoColor("Green"));
   colorB.whenPressed(new AutoColor("Red"));
   colorX.whenPressed(new AutoColor("Blue"));
   colorY.whenPressed(new AutoColor("Yellow"));
   button1.whenHeld
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