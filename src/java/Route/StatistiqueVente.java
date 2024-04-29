/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Route;

import Connect.DbConnect;
import Model.Modele;
import Model.Vente;
import Utilitaire.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Connect;

/**
 *
 * @author Tohy
 */
public class StatistiqueVente extends HttpServlet {

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
            Connect c = new Connect();
            DbConnect db = new DbConnect();
            Connection con = db.ConnectPostgres();
            String nomModele = "Tous";
            
            List<Vente> allVente = Vente.getAllVente(c);
            
            List<Modele> allModele = Modele.getAllModele(c);
            List<Model.StatistiqueVente> allStat = Model.StatistiqueVente.getAllStatistiqueVente(c);
            if (request.getParameter("modele") != null && !request.getParameter("modele").equals("tous")) {
                for (Modele mod : allModele) {
                    if (request.getParameter("modele").equals(mod.getIdModele())) {
                        nomModele = mod.getNomModel();
                    }
                }
                allStat = Model.StatistiqueVente.getStatistiqueVente(con, request.getParameter("modele"));
            }
            
            request.setAttribute("nomModele", nomModele);
            request.setAttribute("allVente", allVente);
            request.setAttribute("listeModele", allModele);
            request.setAttribute("listeStatistique", allStat);
            c.close();
            con.close();
            
            Util.dispatcheo(request, response, "StatistiqueVente.jsp");
        } catch (Exception e) {
            out.print(e.getStackTrace());
            e.printStackTrace();
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
