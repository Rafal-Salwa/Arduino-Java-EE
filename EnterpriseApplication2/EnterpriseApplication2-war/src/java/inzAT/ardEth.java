/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inzAT;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Salwa2
 */
@WebServlet(name = "ardEth", urlPatterns = {"/ardEth"})
public class ardEth extends HttpServlet {

    private boolean dioda = false;
    private ArduinoEthernet c;
    private BazaOperacje bo;

    public ardEth() throws Exception {
        c = ArduinoEthernet.getInstance();
        System.out.println("Konstr ardEth");
    }

    private static final Logger LOG = Logger.getLogger(ardEth.class.getName());
    private static final boolean SHOW_LOG = false;
    private static final int DEFAULT_TIMEOUT = 2000;

    private String host = "192.168.1.113";
    private String path;
    private int liczba = 10;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ardEth</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ardEth at </h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        System.out.println(request.getParameter("czujnik"));
        PrintWriter out = response.getWriter();

        
            out.println(c.operacja1(request.getParameter("czujnik")));
        
//            System.out.println(" Responce :" + (c.modifiedSentence).trim());

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
