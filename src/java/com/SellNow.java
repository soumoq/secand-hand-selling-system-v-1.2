package com;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.lang.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ready_sell")
public class SellNow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            Con con = new Con();

            String pName = request.getParameter("pname");
            String pDetails = request.getParameter("pdetails");
            String pPrice = request.getParameter("pprice");
            String pPic = request.getParameter("pic");
            String image;
            String imagePath;
            int id = con.getId();

            //int i = con.sellNow(pName, pDetails, id, pPrice);
            StaticProduct.setpName(pName);
            StaticProduct.setId(id);
            StaticProduct.setpDetails(pDetails);
            StaticProduct.setpPrice(pPrice);

            RequestDispatcher dispatcer = request.getRequestDispatcher("productImage.jsp");
            dispatcer.forward(request, response);

        } catch (Exception e) {
            out.print(e);
        }
    }
}

class StaticProduct {

    static String pName;
    static int id;
    static String pDetails;
    static String pPrice;

    public static int getId() {
        return id;
    }

    public static String getpDetails() {
        return pDetails;
    }

    public static String getpPrice() {
        return pPrice;
    }

    public static void setId(int id) {
        StaticProduct.id = id;
    }

    public static void setpDetails(String pDetails) {
        StaticProduct.pDetails = pDetails;
    }

    public static void setpPrice(String pPrice) {
        StaticProduct.pPrice = pPrice;
    }

    public static String getpName() {
        return pName;
    }

    public static void setpName(String pName) {
        StaticProduct.pName = pName;
    }

}
