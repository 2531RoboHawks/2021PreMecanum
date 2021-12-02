// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSystem;

public class DriveCommand extends CommandBase {
  private DriveSystem driveSystem;

  public DriveCommand(DriveSystem driveSystem) {
    addRequirements(driveSystem);
    this.driveSystem = driveSystem;
  }

  @Override
  public void execute() {
    driveSystem.mecanum(-Robot.gamepad.getY() * 0.5, Robot.gamepad.getX() * 0.8, Robot.gamepad.getZ() * 0.5);
  }

  @Override
  public void end(boolean interrupted) {
    driveSystem.stop();
  }
}
