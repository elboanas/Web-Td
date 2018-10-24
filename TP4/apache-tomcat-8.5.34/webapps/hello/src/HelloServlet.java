package fr.ub.m2.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/world")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String parameterValue = req.getParameter("name");
        PrintWriter out = resp.getWriter(); 
        out.println("<html>");
        out.println("<body>");
        out.println("Hello world!");
        if(parameterValue != null)
        out.println("<br>Hello "+parameterValue);
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain");
        // TODO: Traiter les parametres de la requete
        String userName = req.getParameter("name");
        PrintWriter writer = resp.getWriter();
        if(userName != null && !userName.trim().isEmpty())
        writer.append("hello "+userName);
        else
        writer.append("Login Error");

}

}
