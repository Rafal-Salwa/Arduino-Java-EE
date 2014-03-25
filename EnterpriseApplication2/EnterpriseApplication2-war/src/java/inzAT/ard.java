package inzAT;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
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
@WebServlet(urlPatterns = {"/ard"})
@Singleton
public class ard extends HttpServlet {

     private Arduino ard1;
    private ArdParametry ardParam;
    private SingleByteCommunication sbc;

    public ard() throws Exception {
        
        System.out.println("Konstr ardRXTX");
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
//    public ard() throws Exception {
//        //ard = new InzynierkaSE();
//        ardParam = new ArdParametry();
//        ard1 = Arduino.getInstance();
//        System.out.println("Konstr ard");
//        
//    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        this.sbc = SingleByteCommunication.getInstance();
        
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InzArd</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InzArd $at " + request.getContextPath() + "</h1>");

            //out.println("<br /><hr>A"+ard.getRaf());
            //System.out.println(ard.getRaf());
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
         try {
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(ard.class.getName()).log(Level.SEVERE, null, ex);
         }

System.out.println("doGet");
       
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
         try {
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(ard.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        System.out.println(request.getParameter("imie") + "=" + request.getParameter("kraj"));
 
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
