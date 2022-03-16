// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LED;

public class Light extends CommandBase {
  private LED m_light;
  private double colorR;
  private double colorG;
  private double colorB;

  /** Creates a new Light. */
  public Light(LED light) {
    m_light = light;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    colorR = SmartDashboard.getNumber("colorR", 0);
    colorG = SmartDashboard.getNumber("colorG", 0);
    colorB = SmartDashboard.getNumber("colorB", 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_light.lightUp(colorR, colorG, colorB);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_light.lightUp(0, 0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
