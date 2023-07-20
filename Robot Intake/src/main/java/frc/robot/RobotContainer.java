// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
docs: https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers.html
https://docs.wpilib.org/en/stable/docs/software/commandbased/commands.html
*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.IntakeAtEighty;
import frc.robot.commands.IntakeAtVariableSpeed;
import frc.robot.commands.IntakeForFiveSeconds;
import frc.robot.commands.OuttakeAtFifty;
import frc.robot.commands.OuttakeForFiveSeconds;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final IntakeSubsystem intake = new IntakeSubsystem();

  private final XboxController controller = new XboxController(0); //port = 0

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    if(this.controller.getAButtonPressed()) {
      new IntakeAtEighty(this.intake, this.controller);
    }
    if(this.controller.getPOV() == 180) {
      new OuttakeAtFifty(this.intake, this.controller);
    }
    if(this.controller.getRightBumperReleased()) {
      new OuttakeForFiveSeconds(this.intake);
    }
    if(this.controller.getLeftBumperReleased()) {
      new IntakeForFiveSeconds(this.intake);
    }
    if(this.controller.getLeftY() != 0) {
      new IntakeAtVariableSpeed(this.intake, this.controller, this.controller.getLeftY());
    }
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand; //example auto commmand
  }
}
