/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;


/**
 *
 * @author mmcka
 */
public class LoginServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get session
        HttpSession session = request.getSession();
        
        String logout = request.getParameter("logout");
        String username = (String) session.getAttribute("username");
        if(logout !=null || username == null ){
            session.invalidate();
            session = request.getSession();

            session.invalidate(); 
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        
        if (username != null ) {
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
          String username = request.getParameter("username");
          String password = request.getParameter("password");
          request.setAttribute("username",username);
          request.setAttribute("password",password);
           if(password==null||password.equals("")||username==null||username.equals("")){
               Boolean notFull = true;
               request.setAttribute("notfull", notFull);
               getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
               return;
           }
    }

}