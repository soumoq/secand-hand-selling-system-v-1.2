
package com;


import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageCrop")

public class ImageCrop extends HttpServlet {

private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest req, HttpServletResponse res)
throws IOException,ServletException{

int t=Integer.parseInt(req.getParameter("t"));
int l=Integer.parseInt(req.getParameter("l"));
int w=Integer.parseInt(req.getParameter("w"));
int h=Integer.parseInt(req.getParameter("h"));
String imagePath=getServletContext().getRealPath("/")+req.getParameter("i");
BufferedImage outImage=ImageIO.read(new File(imagePath));
BufferedImage cropped=outImage.getSubimage(l, t, w, h);
ByteArrayOutputStream out=new ByteArrayOutputStream();
ImageIO.write(cropped,req.getParameter("f"), out);

ImageIO.write(cropped,req.getParameter("f"),
new File(getServletContext().getRealPath("")+System.getProperty("file.separator")
+"cropped.jpg")); // save the file with crop dimensions

//res.setContentType("image/jpg");
ServletOutputStream wrt=res.getOutputStream();
wrt.write(out.toByteArray());
wrt.flush();
wrt.close();

}

}
