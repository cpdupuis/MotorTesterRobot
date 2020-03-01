/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TalonSubsystem extends SubsystemBase {

  private double speed;
    private final WPI_TalonSRX talon;
  /**
   * Creates a new SparkMaxSubsystem.
   */
  public TalonSubsystem(int canId) {
    talon = new WPI_TalonSRX(canId);

  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    talon.set(speed);
    System.err.println("SPEED: "+speed);
  }
}
