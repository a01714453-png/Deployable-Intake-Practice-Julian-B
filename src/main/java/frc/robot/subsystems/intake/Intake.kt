package frc.robot.subsystems
import  frc.robot.subsystems.intakeConfig

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
import com.ctre.phoenix6.controls.DutyCycleOut


class Intake : SubsystemBase() {
    private val config = intakeConfig
    private val motorController = TalonFX(config.motorControllerID) //Declaring the Motor.
    private val motorSpeed = DutyCycleOut(0.0)

    fun getIntakeSpeed () : AngularVelocity{ //This function will later be used to know if the intake speed
        return motorController.velocity.value
    }

    fun setIntakeSpeed ( speed: Double) { // Function to turn on the intake
        motorController.setControl(motorSpeed.withOutput(speed))
    }

    fun stopIntake () { //used to turn off the intake
        motorController.setControl(motorSpeed.withOutput(0.0))
    }


    init {
        val motorConfigs = MotorOutputConfigs()
        motorConfigs.Inverted = InvertedValue.Clockwise_Positive
        motorConfigs.NeutralMode = NeutralModeValue.Brake

        val motorLimits = CurrentLimitsConfigs()
        motorLimits.SupplyCurrentLimitEnable = true
        motorLimits.SupplyCurrentLimit = config.motorAmpsLimit

        motorController.configurator.apply(motorConfigs)
        motorController.configurator.apply(motorLimits)

        }
    }