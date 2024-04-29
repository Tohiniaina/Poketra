/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Connect.DbConnect;
import Model.MetierPersonnelModele;
import Model.Modele;
import Model.PersonnelTaille;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Connect;

/**
 *
 * @author Tohy
 */
public class AddMetierPersonnelModele extends HttpServlet {

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
            String idModele = request.getParameter("modele");
            String personnel = request.getParameter("personnel");
            int nbr = Integer.parseInt(request.getParameter("nbr"));
            Connect co = new Connect();
            
            Modele modele = Modele.getModelById(co, idModele);
            double nbrTaille = PersonnelTaille.getPersonnelTailleByIdTaille(co, modele.getIdTaille()).getNbrPerso();
            
            DbConnect con = new DbConnect();
            Connection conne = con.ConnectPostgres();
            int nbrMetier = MetierPersonnelModele.getNbrMetier(conne, idModele);
            conne.close();
            
            if (nbrTaille <= nbrMetier || nbrTaille < nbrMetier+nbr) {
                String ex = "Nombre de Metier dejà complet";
                request.setAttribute("exception", ex);
                RequestDispatcher dispatch = request.getServletContext().getRequestDispatcher("/Page/Exception.jsp");
                dispatch.forward(request, response);
                throw new Exception(ex);
            }
            
            MetierPersonnelModele mpm = new MetierPersonnelModele(idModele, personnel, nbr);
            mpm.insert(co);
            
            response.sendRedirect("AjoutMetierPersonnelModele?idModele="+idModele);
        } catch (Exception ex) {
            out.print(ex.getMessage());
            ex.printStackTrace();
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
        processRequest(request, response);
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
