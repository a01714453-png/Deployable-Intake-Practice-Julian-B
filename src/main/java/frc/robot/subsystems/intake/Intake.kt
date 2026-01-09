package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.Command

//imports to control the Talon motors.
import com.ctre.phoenix6.configs.TalonFXConfiguration
import com.ctre.phoenix6.controls.VoltageOut
import com.ctre.phoenix6.hardware.TalonFX
import com.ctre.phoenix6.signals.NeutralModeValue
// By making a subsystem a Kotlin object, we ensure there is only ever one instance of it.
// It also reduces the need to have reference variables for the subsystems to be passed around.

class Intake() : SubsystemBase(){
    private val config = intakeConfig
    private val motorController = TalonFX(config.motorControllerID)

    init {
        val motorConfigs = motorOutputConfigs()
        motorConfigs.Inverted = InvertedValue.ClockWise_Positive
        motorConfigs.NeutralMode = NeutralModeValue.Brake

        val motorLimits = CurrentLimitsConfigs()
        motorLimits.SupplyCurrentLimitEnable = true
        motorLimits.SupplyCurrentLimit = config.motorAmpsLimit

        }
    }

}



object ExampleSubsystem : SubsystemBase()
{
    /**
     * Example command factory method.
     *
     * @return a command
     */
    fun exampleMethodCommand(): Command = runOnce {
        // Subsystem.runOnce() implicitly add `this` as a required subsystem.
        // TODO: one-time action goes here
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    fun exampleCondition(): Boolean {
        // Query some boolean state, such as a digital sensor.
        return false
    }

    override fun periodic()
    {
        // This method will be called once per scheduler run
    }

    override fun simulationPeriodic()
    {
        // This method will be called once per scheduler run during simulation
    }

    fun exampleAction()
    {
        // This action is called by the ExampleCommand
        println("ExampleSubsystem.exampleAction has been called")
    }
}