/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inzAT;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Salwa2
 */
@WebServlet(name = "Temp", urlPatterns = {"/Temp"})
public class Temp extends HttpServlet {
    private BazaOperacje bo;

    private boolean dioda = false;
    private ArduinoEthernet c;

    public Temp() throws Exception {
        c = ArduinoEthernet.getInstance();
        System.out.println("Konstr ardEth");
    }

    private static final Logger LOG = Logger.getLogger(ardEth.class.getName());
    private static final boolean SHOW_LOG = false;
    private static final int DEFAULT_TIMEOUT = 2000;

    private String host = "192.168.1.113";
    private String path;
    private int liczba = 10;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Temp</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Temp at " + request.getContextPath() + "</h1>");
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

        System.out.println(request.getParameter("wart"));
        PrintWriter out = response.getWriter();
        if (Integer.parseInt(request.getParameter("wart")) == 1) {
            bo = new BazaOperacje();

            out.println(bo.zaloguj("salwa2"));
        } else {

            out.println(c.operacja1(request.getParameter("wart")));
            System.out.println(" Responce :" + (c.odpArd).trim());
        }
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
