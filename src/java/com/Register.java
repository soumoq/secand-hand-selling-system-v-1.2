/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.*;

@WebServlet("/register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            String name = request.getParameter("name");
            String uName = request.getParameter("uName");
            String phone = request.getParameter("phone");
            String pass = request.getParameter("pass");
            String cPass = request.getParameter("cPass");

            Con con = new Con();
            int i = con.register(name, uName, phone, pass);
            if (i != 0) {
                request.setAttribute("message", "registation seccessfull");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("message", "somthing went wrong");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

        } catch (Exception e) {
            out.print(e);
        }
    }
}
