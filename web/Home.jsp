<%@page import="java.sql.*"%>
<%@page import="com.Con"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>   

        <form action="sell" >
            <h1>Hello ${name}</h1>
            ${user_name}
            <br>
            <input type="submit" id="submit" value="Sell now" name="Sell now" class="btn btn-info">     
        </form>
        
            <br>
            <br>
            <br>
        <table  id="tb1-student" class="table table-responsive table-bordered" cellpadding="0" width="50$">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>User name</th>
                    <th>Phone no.</th>
                    <th>Product id</th>
                    <th>Product Name </th>
                    <th>Product details</th>
                    <th>Product price</th>
                    <th>Product Image</th>
                    <th>Check info</th>

                </tr>


                <%
                    String sql = "SELECT register.name,register.user_name,register.phone,product.product_id,product.product_name,product.product_details,product.price,product.product_image FROM `product` JOIN register WHERE register.id=product.register_id";
                    Con con1 = new Con();
                    Connection con = con1.con();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        String rName = rs.getString(1);
                        String rUname = rs.getString(2);
                        String rPhone = rs.getString(3);
                        int pId = rs.getInt(4);
                        String pName = rs.getString(5);
                        String pDetails = rs.getString(6);
                        String pPrice = rs.getString(7);
                        String imageName=rs.getString(8);
                %>
                <tr>
                    <td><%=rName%></td>
                    <td><%=rUname%></td>
                    <td><%=rPhone%></td>
                    <td><%=pId%></td>
                    <td><%=pName%></td>
                    <td><%=pDetails%></td>
                    <td><%=pPrice%></td>
                    <td><img src="image/<%=imageName%>" alt=""  height="100" width="100"/></td>
                   <td><a href="pinfo.jsp?id=<%=pId%>" >Info</a></td>

                </tr>

                <%
                    }
                %>
            

            </thead>
        </table> 

        
    </body>
</html>
