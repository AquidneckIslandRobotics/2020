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
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.GenericHID;

public class DefaultDrive extends CommandBase {
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
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.curvatureDrive(m_JoyStick.getY(GenericHID.Hand.kLeft) * -1, m_JoyStick.getX(GenericHID.Hand.kRight) * -1, m_button.get());
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
