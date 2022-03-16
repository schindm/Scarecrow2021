// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
//ea is bill gates
// not fubnny did not laughn 

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.TOF;

public class AvoidWall extends CommandBase {
DriveTrainSubsystem m_driveTrain;
TOF m_eyes;

private double leftTOF;
private double rightTOF;

  /** Creates a new AvoidWall. */
  public AvoidWall(DriveTrainSubsystem driveTrain, TOF eyes ) {
    m_driveTrain = driveTrain;
    m_eyes = eyes;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveTrain, m_eyes);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    leftTOF = m_eyes.getDistanceLeft();
    rightTOF = m_eyes.getDistanceRight();

  if (leftTOF <= 500 || rightTOF <= 500) {
    m_driveTrain.drive(-.1,.1);
  }
  else  m_driveTrain.drive(-.1, -.1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (leftTOF <= 100 || rightTOF <= 100) {
      return true;
    }
    
    return false;
  }
}
