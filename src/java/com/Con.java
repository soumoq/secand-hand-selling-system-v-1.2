package com;

import java.sql.*;
import java.util.*;

public class Con {

    public static void main(String[] args) {
        Con con = new Con();
        int i=con.sellNow("dirty", "LIC", 1, "456","455","/home/mr3o5/NetBeansProjects/Secand-hand-selling-system-in-JSP-master/web/image/Screenshot from 2019-08-05 09-03-14.png");
        System.out.println("i"+i);
    }

    public List<Product> fatchProduct() {
        ArrayList<Product> items = new ArrayList<>();
        String sql = "SELECT register.name,register.user_name,register.phone,product.product_id,product.product_name,product.product_details,product.price FROM `product` JOIN register WHERE register.id=product.register_id";
        try {
            Connection con = con();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String rName = rs.getString(1);
                String rUname = rs.getString(2);
                String rPhone = rs.getString(3);
                int pId=rs.getInt(4);
                String pName=rs.getString(5);
                String pDetails=rs.getString(6);
                String pPrice=rs.getString(7);

                Product product=new Product(pName,pDetails,pPrice,rName,rUname,rPhone,pId);
                items.add(product);
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return items;
    }

    private String imageName="",imagePath="";
    
    public int sellNow(String pname, String pdetails, int rid, String pprice,String imageName,String imagePath) {
        
        String sql = "INSERT INTO `product` (`product_id`, `product_name`, `register_id`, `product_details`, `price`, `product_image`, `image_path`) VALUES (NULL, ?, ?, ?, ?, ?, ?);";
        try {
            Connection con = con();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pname);
            ps.setInt(2, rid);
            ps.setString(3, pdetails);
            ps.setString(4, pprice);
            ps.setString(5,imageName);
            ps.setString(6, imagePath);
            int rs = ps.executeUpdate();
            return rs;

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    private String name;
    private String user_name;
    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void fatch(int id) {
        String sql = "SELECT * FROM `register` WHERE id=" + id;
        try {
            Connection con = con();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                setName(name);
                String user_name = rs.getString(3);
                setUser_name(user_name);
                String phone = rs.getString(4);
                setPhone(phone);
            }
        } catch (Exception e) {

        }
    }

    private static int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int login(String name, String pass) {
        String sql = "SELECT id FROM `register` WHERE user_name=? and password = ?";
        try {
            Connection con = con();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int i = rs.getInt("id");
                setId(i);
                return i;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    private String pass = "";
    private String uname = "root";
    private String url = "jdbc:mysql://localhost:3308/Book";
    public Connection connection;

    public Connection con() {
        try {
            System.out.println("Start");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Lode");
            connection = DriverManager.getConnection(url, uname, pass);
            System.out.println("Connected");

        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

}
