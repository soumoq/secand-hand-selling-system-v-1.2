
package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

            
            if(checkEmail(uName))
            {            
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
            }
            else
            {
                request.setAttribute("message", "enter valid email address");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

        } catch (Exception e) {
            out.print(e);
        }
    }
    
    public boolean checkEmail(String email) {
        
        try {
            String apiKey = "c258db52ebba81e631bdbb6795bcc7b2";
            String url = "http://apilayer.net/api/check?access_key="+apiKey+"&email="+email+"&smtp=1&format=1";;
            URL urlobj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlobj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Chrome");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            String result=null;
            result=response.toString();
            
            System.out.println(result);
            
            
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(result);
            JSONObject jsonObject = (JSONObject) obj;
            boolean smtp_check = (boolean) jsonObject.get("smtp_check");
            
            return smtp_check;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
