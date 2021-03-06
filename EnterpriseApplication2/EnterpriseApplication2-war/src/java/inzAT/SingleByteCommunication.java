/*
 * Class uses the RXTX Library for Serial Communication
 * to send and receive single Bytes from an Arduino
 * 
 * done by Laurid Meyer
 * 28.04.2012
 * 
 * http://www.lauridmeyer.com
 *  Link do źródła: http://playground.arduino.cc/Interfacing/Java#.Ux080d6JKwo
 */
package inzAT;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

public class SingleByteCommunication implements SerialPortEventListener {

    SerialPort serialPort;

    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyUSB0", // Linux
        "COM4", // Windows
    };

    private InputStream input;

    private OutputStream output;

    private static final int TIME_OUT = 2000;

    private static final int DATA_RATE = 9600;
    private static volatile SingleByteCommunication instance = null;

    public static SingleByteCommunication getInstance() throws Exception {
        if (instance == null) {
            synchronized (SingleByteCommunication.class) {
                if (instance == null) {
                    System.out.println("Instace Jest");
                    instance = new SingleByteCommunication();
                    instance.initialize();
                }
            }
        }
        return instance;
    }

    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }

        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        } else {
            System.out.println("Found your Port");
        }

        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();

            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public void sendSingleByte(byte myByte) {
        try {
            output.write(myByte);
            output.flush();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                int myByte = input.read();
                int value = myByte & 0xff;//byte to int conversion:0...127,-127...0 -> 0...255
                if (value >= 0 && value < 256) {//make shure everything is ok
                    System.out.println(value);
                    sendSingleByte((byte) myByte);
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

}
