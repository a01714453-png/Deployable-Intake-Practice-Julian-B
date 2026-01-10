package frc.robot.subsystems
import frc.robot.subsystems.wristConfig

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.Command

//imports to control the Talon motors.
import com.ctre.phoenix6.configs.TalonFXConfiguration
import com.ctre.phoenix6.controls.VoltageOut
import com.ctre.phoenix6.hardware.TalonFX
import com.ctre.phoenix6.signals.NeutralModeValue

import edu.wpi.first.units.measure.AngularVelocity
import com.ctre.phoenix6.configs.MotorOutputConfigs
import com.ctre.phoenix6.configs.CurrentLimitsConfigs
import com.ctre.phoenix6.signals.InvertedValue
import com.ctre.phoenix6.controls.PositionVoltage
import com.ctre.phoenix6.signals.GravityTypeValue

//CanCoder
import com.ctre.phoenix6.hardware.CANcoder
import com.ctre.phoenix6.configs.CANcoderConfiguration
import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue
import com.ctre.phoenix6.signals.SensorDirectionValue


class Wrist : SubsystemBase() {
    private val config = wristConfig
    private val motorController = TalonFX(config.motorControllerID) //Declaring the Motor.

    val positionController = PositionVoltage(0.0)
    val cancoder = CANcoder(wristConfig.absoluteEncoderID)


    init {
        val talonConfig = TalonFXConfiguration()

        talonConfig.Slot0.kP = wristConfig.kP
        talonConfig.Slot0.kD = wristConfig.kD
        talonConfig.Slot0.kG = wristConfig.kG
        talonConfig.GravityType =  GravityTypeValue.Arm_Cosine
        talonConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake
        talonConfig.MotorOutput.Inverted = InvertedValue_CounterClocwise_Positive

        //Safety
        talonConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = true
        talonConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold = wristConfig.maxAngle / 360.0

        talonConfig.SoftwareLimitSwitch.ReverseSoftLimitEnable = true
        talonConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold = wristConfig.minAngle / 360.0

        talonConfig.CurrentLimits.SupplyCurrentLimitEnable = true
        talonConfig.CurrentLimits.SupplyCurrentLimit = config.motorAmpsLimit

        talonConfig.Feedback.SensorToMechanismRatio = config.gearRatio

        motorController.configurator.apply(talonConfig)

        val cancoderConfig = CANcoderConfiguration()
        cancoderConfig.MagnetSensor.AbsoluteSensorRange = AbsoluteSensorRangeValue.Unsigned_0To1
        cancoderConfig.MagnetSensor.SensorDirection = SensorDirectionValue.CounterClockwise_Positive
        cancoderConfig.MagnetSensor.MagnetOffset = wristConfig.encoderOffset/360.0

        cancoder.configurator.apply(cancoderConfig)

        }

    fun setAngle(angle : Double) {
        val rotations = angle/360.0
        motorController.setControl(positionController.withPosition(rotations))
    }

    fun raiseDeployable(){ // Makes the deployable go back to its original position.
        setAngle(0.0)
    }

    fun downDeployable(){ //This function will be used to set the wrist so that the intake can work.
        setAngle(90.0)
    }

    fun syncAbsolute(){
        val absolutePosition = cancoder.absolutePosition.value * 360.0
        motorController.setPosition(absolutePosition)
    }


    }