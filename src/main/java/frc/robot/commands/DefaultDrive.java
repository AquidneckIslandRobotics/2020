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
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.GenericHID;

public class DefaultDrive extends CommandBase {

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

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_subsystem.curvatureDrive(m_Joystick.getY(GenericHID.Hand.kLeft),(m_Joystick.getX(GenericHID.Hand.kRight) *-1), m_button.get());

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
