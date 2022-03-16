// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;



public class TankDriveXbox extends CommandBase {
  DriveTrainSubsystem m_driveTrain;
XboxController m_xboxController;

double encoderLeft;
double encoderRight;



  /** Creates a new TankDrive. */
  public TankDriveXbox(DriveTrainSubsystem driveTrain, XboxController xboxController){
    m_driveTrain = driveTrain;
m_xboxController = xboxController;

    addRequirements(m_driveTrain);

  } 
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_driveTrain.drive(m_xboxController.getRawAxis(1)*.5, m_xboxController.getRawAxis(5)*.5);

   encoderLeft = m_driveTrain.getLeftEncoder();
   encoderRight = m_driveTrain.getRightEncoder();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
