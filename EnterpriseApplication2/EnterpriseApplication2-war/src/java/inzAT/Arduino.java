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

public class Arduino {

    
String slowo = "";
private static volatile Arduino instance = null;

public static Arduino getInstance() throws Exception {
        if (instance == null) {
            synchronized (Arduino.class) {
                if (instance == null) {
                    System.out.println("Instace Jest");
                    instance = new Arduino();
                    instance.connect("COM4");
                }
            }
        }
        return instance;
    }

    public Arduino() throws Exception {

    }
    
    void connect(String portName) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: Port is currently in use");
        } else {
            CommPort commPort = portIdentifier.open(this.getClass().getName(), 1000);

            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();

                (new Thread(new SerialReader(in))).start();
                (new Thread(new SerialWriter(out))).start();
                System.out.println("Polaczono");

            } else {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }
    }

    /**
     *      */
    public static class SerialReader implements Runnable {

        InputStream in;

        public SerialReader(InputStream in) {
            this.in = in;
        }

        public void run() {
            byte[] buffer = new byte[1024];
            int len = -1;
            try {
                while ((len = this.in.read(buffer)) > -1) {
                    System.out.print(new String(buffer, 0, len));
                    
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *      */
    public static class SerialWriter implements Runnable {

        OutputStream out;

        public SerialWriter(OutputStream out) {
            this.out = out;
        }

        public void run() {
            System.out.println();
            try {
                int c = 0;
                while ((c = System.in.read()) > -1) {
                    this.out.write(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            (new Arduino()).connect("COM6");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
