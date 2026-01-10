package frc.robot.commands

import frc.robot.subsystems.Wrist

import edu.wpi.first.wpilibj2.command.InstantCommand


/** An example command that uses an example subsystem.  */
class WristCommands (private val wrist: Wrist) { // This class was created to separate the independent control of the intake
    val raiseDeployer = InstantCommand({wrist.raiseDeployable()}, wrist)

    val downDeployer = InstantCommand({wrist.downDeployable()}, wrist)
}