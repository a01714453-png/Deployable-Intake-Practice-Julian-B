package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.units.measure.Current


data class IntakeConfig  (//this class was created to define the basic information that the motor needs.
    var motorControllerID : Int,
    var motorAmpsLimit : Double,
)

  val intakeConfig = IntakeConfig( // this instace was created to define the basic parameters that the motor needs.
      motorControllerID = TODO(),
      motorAmpsLimit = 40.0,

)