package com;

import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/varifaction")
public class Varifaction extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("pname");
        try {
            Register r = new Register();
            String code = r.getCode();
            String name1 = Register.getName();
            String uname = Register.getUname();
            String phone = Register.getPhone();
            String pass = Register.getPass();

            PrintWriter out = response.getWriter();

            if (name.equals(code)) {
                Con con = new Con();
                int i = con.register(name1, uname, phone, pass);

                if (i != 0) {
                    request.setAttribute("message", "Registation Successful");
                    request.getRequestDispatcher("login.jsp").forward(request, response);

                } else {
                    out.println("Registation fald");
                }

            } else {
                out.print("nono");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
