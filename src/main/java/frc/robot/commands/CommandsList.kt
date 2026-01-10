package frc.robot.commands

import edu.wpi.first.wpilibj2.command.InstantCommand
import frc.robot.subsystems.Intake
import frc.robot.subsystems.Wrist
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup
import edu.wpi.first.wpilibj2.command.WaitCommand

/** An example command that uses an example subsystem.  */
class CommandsList (private val intake: Intake, private val wrist : Wrist) { // This class was created to separate the independent control of the intake
    val deploy = SequentialCommandGroup(
        InstantCommand({intake.setIntakeSpeed(0.8)}, intake),
        WaitCommand(0.1),
        InstantCommand({ wrist.downDeployable() }, wrist)
    )

    val raise = SequentialCommandGroup(
        InstantCommand({intake.setIntakeSpeed(0.0)}, intake),
        WaitCommand(0.1),
        InstantCommand({ wrist.raiseDeployable() }, wrist)
    )

}