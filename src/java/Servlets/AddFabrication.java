/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Connect.DbConnect;
import Model.Fabrication;
import Model.Formule;
import Model.Mouvement;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
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
public class AddFabrication extends HttpServlet {

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
            Date dateFabrication = Date.valueOf(request.getParameter("date"));
            double nombre = Double.valueOf(request.getParameter("nombre"));
            Connect co = new Connect();
            
            DbConnect db = new DbConnect();
            Connection con = db.ConnectPostgres();
            List<Formule> formuleBesoin = Formule.getFormuleBesoinModel(con, idModele, nombre);
            con.close();
            
            List<Mouvement> listMvt = new ArrayList<>();
            
            for (Formule formule : formuleBesoin) {
                Mouvement mvt = new Mouvement(formule.getIdMatiere(), dateFabrication);
                mvt.setQuantite(formule.getQuantiteBesoin(), co, 0);
                listMvt.add(mvt);
            }
            
            for (Mouvement mouvement : listMvt) {
                if (mouvement.getReste() != 0) {
                    String ex = "Stock de "+mouvement.getNomMatiere(co)+" insuffisant de "+mouvement.getReste();
                    request.setAttribute("exception", ex);
                    RequestDispatcher dispatch = request.getServletContext().getRequestDispatcher("/Page/Exception.jsp");
                    dispatch.forward(request, response);
                    throw new Exception(ex);
                }
            }
            
            for (Mouvement mouvement : listMvt) {
                mouvement.insert(co);
            }
            
            Fabrication fab = new Fabrication(idModele, dateFabrication, nombre);
            fab.insert(co);
            
            response.sendRedirect("AjoutFabrication");
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
