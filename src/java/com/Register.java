package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.*;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

    private static String name, uname, phone, pass;

    public static void setName(String name) {
        Register.name = name;
    }

    public static void setUname(String uname) {
        Register.uname = uname;
    }

    public static void setPhone(String phone) {
        Register.phone = phone;
    }

    public static void setPass(String pass) {
        Register.pass = pass;
    }

    public static String getName() {
        return name;
    }

    public static String getUname() {
        return uname;
    }

    public static String getPhone() {
        return phone;
    }

    public static String getPass() {
        return pass;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            String name = request.getParameter("name");
            String uName = request.getParameter("uName");
            String phone = request.getParameter("phone");
            String pass = request.getParameter("pass");
            String cPass = request.getParameter("cPass");

            if (checkEmail(uName)) {
                int i = 1;
                Con con = new Con();
                //int i = con.register(name, uName, phone, pass);
                if (i != 0) {

                    Random random = new Random();
                    int code = random.nextInt(999999);
                    String codeE = String.valueOf(code);
                    setCode(codeE);
                    
                    
                    sendMail(code,uName);
                    checkEmail(uName);
                    
                    Register.setName(name);
                    Register.setUname(uName);
                    Register.setPhone(phone);
                    Register.setPass(pass);

                    request.setAttribute("var", codeE);
                    request.setAttribute("name", name);
                    request.setAttribute("uName", uName);
                    request.setAttribute("phone", phone);
                    request.setAttribute("pass", pass);
                    request.getRequestDispatcher("varifaction.jsp").forward(request, response);

                } else {
                    request.setAttribute("message", "somthing went wrong");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", "enter valid email address");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

        } catch (Exception e) {
            out.print(e);
        }
    }

    public void sendMail(int code,String from1) {

        try {
            System.out.println("1");
            Properties pro = new Properties();
            pro.setProperty("mail.transport.protocol", "smtp");
            pro.setProperty("mail.host", "smtp.gmail.com");
            pro.put("mail.smtp.auth", "true");
            pro.put("mail.smtp.port", "465");
            pro.put("mail.debug", "true");
            pro.put("mail.smtp.socketFactory.port", "465");
            pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pro.put("mail.smtp.socketFactory.fallback", "false");

            String to = "bat48655@gmail.com";
            String pass = "Misti270@";
            String from = from1;

            System.out.println("2");

            Session session = Session.getInstance(pro, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(to, pass);
                }
            }
            );
            System.out.println("3");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(to));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(from));
            message.setSubject("Varifaction code");
            message.setText("your varifaction code is: " + code);

            System.out.println("4");

            //Transport transport = session.getTransport("smtp"); 
            Transport.send(message);

            System.out.println("5");

            System.out.println("done");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String code;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean checkEmail(String email) {

        try {
            String apiKey = "c258db52ebba81e631bdbb6795bcc7b2";
            String url = "http://apilayer.net/api/check?access_key=" + apiKey + "&email=" + email + "&smtp=1&format=1";;
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
            String result = null;
            result = response.toString();

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
