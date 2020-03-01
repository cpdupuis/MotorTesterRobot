/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SparkMaxSubsystem extends SubsystemBase {

  private final CANSparkMax sparkMax;
  private double speed;

  /**
   * Creates a new SparkMaxSubsystem.
   */
  public SparkMaxSubsystem(int canId) {
    sparkMax = new CANSparkMax(canId, MotorType.kBrushless);

  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    sparkMax.set(speed);
    System.err.println("SPEED: "+speed);
  }
}
