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
 * @author Zeina Mint
 */
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        User username = (User)session.getAttribute("username");
        User password = (User)session.getAttribute("password");
        
         if(username != null || password != null){
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
            return;
        } 
        request.setAttribute("username",username);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
