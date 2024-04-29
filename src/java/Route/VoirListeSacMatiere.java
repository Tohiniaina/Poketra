/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Route;

import Connect.DbConnect;
import Model.Matiere;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.V_formule_model;
import Utilitaire.Util;
import java.sql.Connection;
import utils.Connect;

/**
 *
 * @author Tohy
 */
public class VoirListeSacMatiere extends HttpServlet {

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
            DbConnect db = new DbConnect();
            Connection con = db.ConnectPostgres();
            Connect c = new Connect();
            Matiere matiere = new Matiere();
            
            String idMatiere = request.getParameter("idMatiere");
            //out.print(idMatiere);
            
            List<Matiere> allMatieres = matiere.getAllMatiere(c);
            
            if (idMatiere==null && !allMatieres.isEmpty()) {
                idMatiere = allMatieres.get(0).getIdMatiere();
            }
            
            List<V_formule_model> listeForm = V_formule_model.getFormuleByIdMatiere(con, idMatiere);
            
            con.close();
            c.close();
            
            request.setAttribute("listeMatiere", allMatieres);
            request.setAttribute("listeFormule", listeForm);
            Util.dispatcheo(request, response, "ListeSacMatiere.jsp");
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
