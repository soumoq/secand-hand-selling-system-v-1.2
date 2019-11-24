package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/HomeLet")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Integer id1 = (Integer) request.getAttribute("id");
            Con con = new Con();
            con.fatch(id1);
            String name = con.getName();
            String user_name = con.getUser_name();
            String phone=con.getPhone();
            request.setAttribute("name", name);
            request.setAttribute("user_name", user_name);
            

            
            
            RequestDispatcher dispatcer = request.getRequestDispatcher("Home.jsp");
            dispatcer.forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e);
        }
    }
}
