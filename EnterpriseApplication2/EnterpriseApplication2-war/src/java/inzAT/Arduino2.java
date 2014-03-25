/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inzAT;

/**
 *
 * @author Salwa
 * Klasa zostala stworzonana podstawie poradnika ze strony Arduino.cc
 * Adres http://playground.arduino.cc/Interfacing/Java#.UyPxEN6JKwo
 */
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Arduino2 implements Runnable {

    private String odebrane = "";
    private static volatile Arduino2 instance = null;
    InputStream in;
    OutputStream out;
    byte[] buffer = new byte[1024];
    String odp = "";
    int len = -1;

    public String getOdebrane() {
        return odebrane;
    }

    public void setOdebrane(String odebrane) {
        this.odebrane = odebrane;
    }

    public static Arduino2 getInstance() throws Exception {
        if (instance == null) {
            synchronized (Arduino2.class) {
                if (instance == null) {
                    instance = new Arduino2();
                    instance.connect("COM4");
                }
            }
        }
        return instance;
    }

    public Arduino2() throws Exception {

    }

    String connect(String portName) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            return ("Error: Port is currently in use");
        } else {
            CommPort commPort = portIdentifier.open(this.getClass().getName(), 1000);

            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                in = serialPort.getInputStream();
                out = serialPort.getOutputStream();

//                (new Thread(new SerialReader(in, out))).start();
//                (new Thread(new SerialWriter(out))).start();
            } else {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }
        return "UDALO SIE POLACZYC Z ARDUINO";
    }

    @Override
    public void run() {
        try {
            while ((len = in.read(buffer)) > -1) {
                System.out.print(in.toString());
                odp = in.toString();
                System.out.print(odp);
            }

            System.out.print(odp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String Odczyt() {

        try {
            while ((len = in.read(buffer)) > -1) {
                odp = this.in.toString();
            }

            System.out.print(odp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return odp;
    }

    public void Wyslij(String ard) {

        byte[] b = ard.getBytes();

        try {
            out.write(b);

        } catch (IOException e) {

        }

    }

}
