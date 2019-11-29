package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("pass");
            Con con = new Con();
            int i = con.login(username, password);
            if (i != 0) {

                request.setAttribute("id", i);
                RequestDispatcher rd = request.getRequestDispatcher("HomeLet");
                rd.forward(request, response);
            } else {
                out = response.getWriter();
                out.print("Wrong");
            }
        } catch (Exception e) {
            out = response.getWriter();
            out.println(e);
        }
    }
}
