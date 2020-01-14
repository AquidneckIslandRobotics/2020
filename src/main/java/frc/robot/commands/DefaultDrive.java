/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.Button;
<<<<<<< HEAD
=======
import frc.robot.RobotContainer;
>>>>>>> 63b5df266423e93493e1f033140b4fad0c1525de
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.GenericHID;

public class DefaultDrive extends CommandBase {
<<<<<<< HEAD
  private Button m_button;
  private final Drive m_subsystem;
  private XboxController m_JoyStick;

  /**
   * Creates a new DefaultDrive.
   */
  public DefaultDrive(Drive subsystem, XboxController Joy, Button button) {
    m_subsystem = subsystem;
    m_JoyStick = Joy;
    m_button = button;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
=======
  private static final Drive XboxController = null;
  private final Drive m_subsystem;
  private XboxController m_Joystick;
  private Button m_button;
  /**
   * Creates a new DefaultDrive.
   */
  public DefaultDrive(Drive subsystems, XboxController Joy, Button button) {
    m_subsystem = subsystems;
    m_Joystick = Joy;
    m_button = button;
    addRequirements(subsystems);
    // Use addRequirements() here to declare subsystem dependencies.
>>>>>>> 63b5df266423e93493e1f033140b4fad0c1525de
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
<<<<<<< HEAD
    m_subsystem.curvatureDrive(m_JoyStick.getY(GenericHID.Hand.kLeft) * -1, m_JoyStick.getX(GenericHID.Hand.kRight) * -1, m_button.get());
=======
    m_subsystem.curvatureDrive(m_Joystick.getY(GenericHID.Hand.kLeft),(m_Joystick.getX(GenericHID.Hand.kRight) *-1), m_button.get());
>>>>>>> 63b5df266423e93493e1f033140b4fad0c1525de
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
