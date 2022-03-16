// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;



public class TankDrive extends CommandBase {
  DriveTrainSubsystem m_driveTrain;
  private Joystick m_joystickRight;
  private Joystick m_joystickLeft;

  /** Creates a new TankDrive. */
  public TankDrive(DriveTrainSubsystem driveTrain, Joystick joystickLeft, Joystick joystickRight){
    m_driveTrain = driveTrain;
    m_joystickLeft = joystickLeft;
    m_joystickRight = joystickRight;

    addRequirements(m_driveTrain);

  } 
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.drive(m_joystickLeft.getY()*.25, m_joystickRight.getY()*.25);
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
