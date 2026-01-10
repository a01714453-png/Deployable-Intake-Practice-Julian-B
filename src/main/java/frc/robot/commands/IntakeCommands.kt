package frc.robot.commands

import edu.wpi.first.wpilibj2.command.Command
import frc.robot.subsystems.ExampleSubsystem
import edu.wpi.first.wpilibj2.command.InstantCommand
import frc.robot.subsystems.Intake

/** An example command that uses an example subsystem.  */
class IntakeCommands (private val intake: Intake) { // This class was created to separate the independent control of the intake
    val startIntake = InstantCommand({intake.setIntakeSpeed(0.8)}, intake)

    val stopIntake = InstantCommand({intake.stopIntake()}, intake)

}