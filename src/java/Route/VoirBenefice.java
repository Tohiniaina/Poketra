/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Route;

import Connect.DbConnect;
import Model.Modele;
import Model.Benefice;
import Model.DepenseMatierePremiere;
import Model.DepensePersonnel;
import Model.PrixVente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import Utilitaire.Util;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Connect;

/**
 *
 * @author Tohy
 */
public class VoirBenefice extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            Connect c = new Connect();
            DbConnect db = new DbConnect();
            Connection connection = db.ConnectPostgres();
            
            List<Modele> allModele = Modele.getAllModele(c);
            List<Benefice> allBenefice = new ArrayList<>();
            
            double prixmin = 0;
            double prixmax = 10000000;
            if (request.getParameter("prixmin") != null) {
                prixmin = Double.valueOf(request.getParameter("prixmin"));
            }
            if (request.getParameter("prixmax") != null) {
                prixmax = Double.valueOf(request.getParameter("prixmax"));
            }
            
            for (Modele modele : allModele) {
                PrixVente pv = PrixVente.getPrixVenteByIdModele(c, modele.getIdModele());
                DepenseMatierePremiere pmp = DepenseMatierePremiere.getDepenseMatierePremiereModel(connection, modele.getIdModele());
                DepensePersonnel dp = DepensePersonnel.getDepensePersonnelModel(connection, modele.getIdModele());
                double benefice = pv.getMontant()-(pmp.getPrixtotal()+dp.getPrixtotal());
                Benefice bn = new Benefice(modele.getIdModele(), benefice);
                if (bn.getMontant()>=prixmin && bn.getMontant()<=prixmax) {
                    allBenefice.add(bn);
                }
            }
            
            c.close();
            connection.close();
            
            request.setAttribute("listeBenefice", allBenefice);
            Util.dispatcheo(request, response, "TriBenefice.jsp");
        } catch (Exception e) {
            out.print(e.getMessage());
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
