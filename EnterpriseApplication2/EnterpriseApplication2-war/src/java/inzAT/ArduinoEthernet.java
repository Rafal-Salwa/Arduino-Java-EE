/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inzAT;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Arduino Playground
 * modyfikacja Salwa
 * Kod klasy powstał na podstawie: 
 * http://arduino.cc/en/Tutorial/UDPSendReceiveString#.Ux08696JKwo
 */
public class ArduinoEthernet {

    static String serverHostname1;
    static DatagramSocket d1;
    static InetAddress ip, retiip;
    static DatagramPacket send, rec;
    static String odpArd;
    private static volatile ArduinoEthernet instance = null;
    static byte[] b = null;
    static byte[] receiveData = new byte[1024];

    public static ArduinoEthernet getInstance() throws Exception {
        if (instance == null) {
            synchronized (ArduinoEthernet.class) {
                if (instance == null) {
                    System.out.println("Instace Jest");
                    instance = new ArduinoEthernet();

                }
            }
        }
        return instance;
    }

    public String operacja1(String s) {
        try {
            d1 = new DatagramSocket();
            String serverHostname1 = new String("192.168.1.113");
            ip = InetAddress.getByName(serverHostname1);
            b = (s.getBytes());
            send = new DatagramPacket(b, b.length, ip, 8032);
            d1.send(send);
            rec = new DatagramPacket(receiveData, receiveData.length);
            d1.setSoTimeout(30000);
            d1.receive(rec);
            odpArd = new String(rec.getData());
            InetAddress returnIPAddress = rec.getAddress();
            int port = rec.getPort();
            System.out.println("From server at: " + returnIPAddress+ ":" + port);
            System.out.println("Message: " + odpArd);
            d1.close();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
        return odpArd;
    }
    
   

}
