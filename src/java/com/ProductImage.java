package com;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/imageUp")

public class ProductImage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        try {

            String image = null, imagePath = null;

            File f = new File("/home/mr3o5/NetBeansProjects/Secand-hand-selling-system-in-JSP-master/web/image");
            if (!f.exists()) {
                f.mkdir();
            }

            ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> file = sf.parseRequest(request);
            for (FileItem item : file) {
                if (!item.isInMemory()) {
                    image = item.getName();
                    item.write(new File("/home/mr3o5/NetBeansProjects/Secand-hand-selling-system-in-JSP-master/web/image/" + item.getName()));
                    imagePath = "/home/mr3o5/NetBeansProjects/Secand-hand-selling-system-in-JSP-master/web/image/" + item.getName();

                }
            }
            int id = StaticProduct.getId();
            String pName = StaticProduct.getpName();
            String pDetails = StaticProduct.getpDetails();
            String pPrice = StaticProduct.getpPrice();
            
            Con con = new Con();
            int i=con.sellNow(pName, pDetails, id, pPrice, image, imagePath);
            
            out.println(pName);
            out.println(pDetails);
            out.println(id);
            out.println(pPrice);
            out.println(image);
            out.println(imagePath);
            out.println(i);
            

        } catch (Exception e) {
            out.println(e);
        }
    }
}
