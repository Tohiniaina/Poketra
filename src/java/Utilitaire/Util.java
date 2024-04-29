/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Tohy
 */
public class Util {
    public static void dispatcheo(HttpServletRequest request, HttpServletResponse response, String body) throws ServletException, IOException {
        RequestDispatcher headerDispatcher = request.getRequestDispatcher("/Template/Header.jsp");
        headerDispatcher.include(request, response);

        RequestDispatcher bodyDispatcher = request.getRequestDispatcher("Page/"+body);
        bodyDispatcher.include(request, response);

        RequestDispatcher footerDispatcher = request.getRequestDispatcher("/Template/Footer.jsp");
        footerDispatcher.include(request, response);
    }
}
