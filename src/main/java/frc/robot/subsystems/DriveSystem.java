// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.DriveCommand;

public class DriveSystem extends SubsystemBase {
  private Spark frontRight = new Spark(0);
  private Spark backRight = new Spark(1);
  private Spark frontLeft = new Spark(2);
  private Spark backLeft = new Spark(3);

  public DriveSystem() {
    setDefaultCommand(new DriveCommand(this));
  }

  @Override
  public void periodic() {

  }

  public void mecanum(double forward, double sideways, double rotation) {
    forward *= -1;
    System.out.println(forward + " " + sideways);
    frontRight.set((forward + sideways) + rotation);
    backRight.set((forward - sideways)  + rotation);
    frontLeft.set(-(forward - sideways) + rotation);
    backLeft.set(-(forward + sideways)  + rotation);
  }

  public void stop() {
    mecanum(0, 0, 0);
  }
}
