/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj.XboxController;

public class TurretTurn extends CommandBase {
  private XboxController m_joystick;
  private Turret m_turret; 


  
  /**
   * Creates a new TurretTurn.
   */
  public TurretTurn(XboxController joystick, Turret turret) {
    m_joystick = joystick; 
    m_turret = turret;
    
    addRequirements(turret); 
 
   // double targetPositionRotations; 
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // turretServo.configFactoryDefault(); 
    // turretServo.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
    // Constants.kPIDLoopIdx, 
    // Constants.kTimeoutMs); 

    // turretServo.setSensorPhase(Constants.kSensorPhase); 
    // turretServo.setInverted(Constants.kMotorInvert); 
    // turretServo.configNominalOutputForward(0, Constants.kTimeoutMs); 
    // turretServo.configNominalOutputReverse(0, Constants.kTimeoutMs); 
    // turretServo.configPeakOutputForward(1, Constants.kTimeoutMs); 
    // turretServo.configPeakOutputReverse(-1, Constants.kTimeoutMs); 

    // turretServo.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs); 
    // turretServo.config_kF(Constants.kPIDLoopIdx, Constants.kF, Constants.kTimeoutMs); 
    // turretServo.config_kP(Constants.kPIDLoopIdx, Constants.kP, Constants.kTimeoutMs); 
    // turretServo.config_kI(Constants.kPIDLoopIdx, Constants.kI, Constants.kTimeoutMs); 
    // turretServo.config_kD(Constants.kPIDLoopIdx, Constants.kD, Constants.kTimeoutMs); 

    // int absolutePosition = turretServo.getSensorCollection().getPulseWidthPosition();
    // absolutePosition &= 0xFFF; 
    // if (Constants.kSensorPhase) { absolutePosition *= -1; }
    // if (Constants.kMotorInvert) { absolutePosition *= -1; }

    // turretServo.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   

    
   
    //targetPositionRotations = leftYstick * 4096; 
     //turretServo.set(ControlMode.Position, targetPositionRotations); 
    //}
    

    //m_subsystem.curvatureDrive(m_Joystick.getY(GenericHID.Hand.kLeft),
    //(m_Joystick.getX(GenericHID.Hand.kRight) *-1)
    //, m_button.get());
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
