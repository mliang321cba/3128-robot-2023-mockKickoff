package frc.robot.subsystem;
import static frc.robot.Constants.ManipulatorConstants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import common.hardware.motorcontroller.NAR_CANSparkMax;
import common.utility.shuffleboard.NAR_Shuffleboard;
import edu.wpi.first.wpilibj.RobotController;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Manipulator extends SubsystemBase{
    private TalonSRX m_motor;
    private static Manipulator instance;
    public static boolean Whole_N = true;
    public boolean outtaking = false;
    
    public static Manipulator getInstance(){
        if(instance == null){
            instance = new Manipulator();
        }
        return instance;
    }
    
    public Manipulator(){
        configMotor();
    }
    
    public void periodic(){
        
    }
    
    public void configMotor(){
        m_motor = new TalonSRX(MANIP_ID);
        m_motor.setNeutralMode(NeutralMode.Brake);
    }
    
    public void intake(){
        set(-MOTOR_POWER);
    }
    
    public void outtake(){
        set(MOTOR_POWER);
    }
    
    public void stopMotor(){
        set(0);
    }
    
    public void set(double power){
        m_motor.set(TalonSRXControlMode.PercentOutput, power);
    }
    
    public boolean hasObjectPresent(){
        return getCurrent() < CURRENT_THRESHOLD;
    }
    
    public double getCurrent(){
        return m_motor.getStatorCurrent();
    }
    
    public void stallPower(){
        set(STALL_POWER);
    }
    
    public void initShuffleboard() {
        NAR_Shuffleboard.addData("Manipulator", "Manip current", () -> getCurrent(), 0, 1);
        NAR_Shuffleboard.addData("Manipulator", "ObjectPresent", ()-> hasObjectPresent(), 1, 1);

    }
    
    

}
