/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SparkMaxCommand;
import frc.robot.commands.TalonCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SparkMaxSubsystem;
import frc.robot.subsystems.TalonSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final SparkMaxSubsystem sparkMaxSubsystem = new SparkMaxSubsystem(7);
  private final TalonSubsystem talonSubsystem = new TalonSubsystem(31);
  private SparkMaxCommand sparkMaxCommand;
  private TalonCommand talonCommand;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final XboxController controller = new XboxController(0);
    DoubleSupplier sparkThrottle = () -> controller.getY(Hand.kRight);
    sparkMaxCommand = new SparkMaxCommand(sparkMaxSubsystem, sparkThrottle);
    sparkMaxSubsystem.setDefaultCommand(sparkMaxCommand);
    DoubleSupplier talonThrottle = () -> controller.getY(Hand.kLeft);
    talonCommand = new TalonCommand(talonSubsystem, talonThrottle);
    talonSubsystem.setDefaultCommand(talonCommand);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}