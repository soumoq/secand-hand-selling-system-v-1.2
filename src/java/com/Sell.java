package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.*;

@WebServlet("/sell")
public class Sell extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Con con = new Con();
        int id=con.getId();
        con.fatch(id);
        String name = con.getName();
        String user_name = con.getUser_name();
        String phone = con.getPhone();

        request.setAttribute("name", name);
        request.setAttribute("user_name", user_name);
        request.setAttribute("phone", phone);

        RequestDispatcher dispatcer = request.getRequestDispatcher("sell.jsp");
        dispatcer.forward(request, response);
    }
}
