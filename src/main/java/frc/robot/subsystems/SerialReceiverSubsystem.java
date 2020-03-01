/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SerialReceiverSubsystem extends SubsystemBase {
  private final SerialPort port;
  private final PipedInputStream in;
  private final PipedOutputStream out;
  private static final int bufferSize = 4096;
  /**
   * Creates a new SerialReceiverSubsystem.
   */
  public SerialReceiverSubsystem(int portNumber) throws IOException {
    this.port = new SerialPort(38400, SerialPort.Port.kUSB);
    this.in = new PipedInputStream(bufferSize);
    this.out = new PipedOutputStream(in);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    int avail = port.getBytesReceived();
    if (avail > 0) {
      byte[] chunk = port.read(avail);
      try {
        out.write(chunk);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }


}
