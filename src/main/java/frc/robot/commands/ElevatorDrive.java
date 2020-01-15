/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;


public class ElevatorDrive extends CommandBase {
  private Elevator m_elevator;
  private XboxController m_joystick;
  /**
   * Creates a new ElevatorDrive.
   */
  public ElevatorDrive(Elevator elevator, XboxController joystick) {
    m_elevator = elevator;
    m_joystick = joystick;
    addRequirements(elevator);
<<<<<<< HEAD
    
=======


>>>>>>> a01de955b84627ec750e55a0039e5c3c91a8ef7b
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
<<<<<<< HEAD
=======

>>>>>>> a01de955b84627ec750e55a0039e5c3c91a8ef7b
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
<<<<<<< HEAD
   int dad;
  dad = m_joystick.getPOV();
  
=======
    int dad;
    dad = m_joystick.getPOV();
>>>>>>> a01de955b84627ec750e55a0039e5c3c91a8ef7b
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
