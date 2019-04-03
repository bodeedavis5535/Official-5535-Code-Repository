/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.functions;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class balllevels extends Subsystem {


  CANSparkMax frontelv = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax middleelv = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax backelv = new CANSparkMax(3, MotorType.kBrushless);
  Encoder u1enc = new Encoder(0, 1);
  Encoder u2enc = new Encoder(2, 3);
  Encoder u3enc = new Encoder(4, 5);


  @Override
  public void initDefaultCommand() {
    u1enc.setReverseDirection(true);
    u2enc.setReverseDirection(false);
    u3enc.setReverseDirection(true);
  }

  public void high(){
    if (u1enc.get() <= 2049.25) {
      frontelv.set(-1);
    }

  if (u2enc.get() <= 1958.5) {
      middleelv.set(1);
    }

  if (u3enc.get() <= 2669.0) {
      backelv.set(-1);
    }

  if (u1enc.get() >= 2049.25) {
      frontelv.set(0);
    }

  if (u2enc.get() >= 1958.5) {
      middleelv.set(0);
    }

  if (u3enc.get() >= 2669.0) {
      backelv.set(0);
    }

  if (u3enc.get() >= 2669 && u2enc.get() >= 1958.5 && u1enc.get() >= 2049.25){
    End();
  }
  }

  public void middle(){
    if (u1enc.get() <= 1312.75) {
      frontelv.set(-1);
  }

  if (u2enc.get() <= 1292.75) {
      middleelv.set(1);
  }

  if (u3enc.get() <= 1509) {
      backelv.set(-1);
  }

  if (u1enc.get() >= 1312.75) {
      frontelv.set(0);
  }

  if (u2enc.get() >= 1292.75) {
      middleelv.set(0);
  }

  if (u3enc.get() >= 1509) {
      backelv.set(0);
  }

  if (u3enc.get() >= 1509 && u2enc.get() >= 1292.75 && u1enc.get() >= 1312.75){
    End();
  }
  }

  public void bottom(){
  if (u1enc.get() <= 523.25) {
      frontelv.set(-1);
  }

  if (u2enc.get() <= 433.25) {
      middleelv.set(1);
  }

  if (u3enc.get() <= 623) {
      backelv.set(-1);
  }

  if (u1enc.get() >= 523.25) {
      frontelv.set(0);
  }

  if (u2enc.get() >= 433.25) {
      middleelv.set(0);
  }

  if (u3enc.get() >= 623) {
      backelv.set(0);
  }

  if (u3enc.get() >= 623 && u2enc.get() >= 433.25 && u1enc.get() >= 533.25){
    End();
  }
  }

  public void player(){
    if (u1enc.get() <= 984.75) {
        frontelv.set(-1);
    }

    if (u2enc.get() <= 986.75) {
        middleelv.set(1);
    }

    if (u3enc.get() <= 1079.25) {
        backelv.set(-1);
    }

    if (u1enc.get() >= 984.75) {
        frontelv.set(0);
    }

    if (u2enc.get() >= 986.75) {
        middleelv.set(0);
    }

    if (u3enc.get() >= 1079.25) {
        backelv.set(0);
    }

    if (u3enc.get() >= 1079.25 && u2enc.get() >= 986.75 && u1enc.get() >= 984.75){
      End();
    }
  }

  public void pickup(){
    if (u3enc.get() > 362.5) {
      backelv.set(1);
    }

    if (u2enc.get() > 321.5) {
      middleelv.set(-1);
    }

    if (u1enc.get() > 389.0) {
      frontelv.set(1);
    }

    if (u3enc.get() < 362.5 && u3enc.get() > 50) {
      backelv.set(.4);
    }

    if (u2enc.get() < 321.5 && u2enc.get() > 50) {
      middleelv.set(-.4);
    }

    if (u1enc.get() < 389.0 && u1enc.get() > 50) {
      frontelv.set(.4);
    }

    if (u3enc.get() <= 50) {
      backelv.set(0);
    }

    if (u2enc.get() <= 50) {
      middleelv.set(0);
    }

    if (u1enc.get() <= 50) {
      frontelv.set(0);
    
    }

    if (u3enc.get() <= 50 && u2enc.get() <= 50 && u1enc.get() <= 50){
      End();
    }
  }

  public void End(){
    frontelv.set(0);
    middleelv.set(0);
    backelv.set(0);
  }

}
