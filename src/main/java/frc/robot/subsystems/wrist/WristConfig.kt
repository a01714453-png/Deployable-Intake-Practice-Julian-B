package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.units.measure.Current


data class WristConfig ( //this class was created to define the basic information that the motor needs.
    val motorControllerID : Int,
    val motorAmpsLimit : Double,

    val absoluteEncoderID : Int,
    val absoluteEncoderInverted : Boolean,
    val encoderOffset : Double,

    val gearRatio : Double,

    //PIDs:
    val kP : Double, // Controls how fast the motor reacts,
    val kD : Double, //Damping Force,
    val kG : Double, //Gravity Force,

    //Safety

    val minAngle : Double,
    val maxAngle : Double
)

 public val wristConfig = WristConfig( // this instace was created to define the basic parameters that the motor needs.
    motorControllerID = TODO() ,
    motorAmpsLimit = 40.0,

     absoluteEncoderID = TODO(),
     absoluteEncoderInverted = true,
     encoderOffset = -90.0,

     gearRatio = 9.0, // The equivalent of 9:1 in decimal

    //PIDs:

     kP = 1.0,
     kD = 0.2,
     kG = 0.2,

     //Safety

     minAngle = TODO(),
     maxAngle = TODO()


)