/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.Servlet;

import it.marconivr.microblog.dao.UtenteDao;
import it.marconivr.microblog.entity.BlogUtente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Tutor-00
 */
public class AddPostServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        if (request.getSession(false) != null) {
            String username = (String)request.getSession(false).getAttribute("username"); 
            BlogUtente u = UtenteDao.findBlogUtente(username);
            
            if (u.getRuolo().equals("ADMIN")) {
            request.getRequestDispatcher("aggiungi.html").include(request, response);
            }
            else {
                request.getRequestDispatcher("alert.html").include(request, response);
            }
        }
    }


}
