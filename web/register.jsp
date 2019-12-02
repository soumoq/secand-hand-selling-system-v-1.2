<%-- 
    Document   : register
    Created on : 6 Nov, 2019, 11:20:17 AM
    Author     : mr3o5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head><title>Simple jsp page</title>
        <link rel="stylesheet" href="add.css">
    </head>  

    <form action="register" method="post" >
        <div class="login-box">
            <h1>Register</h1>
            <div class="textbox">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Full name" name="name">
            </div>

            <div class="textbox">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Username" name="uName">
            </div>

            <div class="textbox">
                <i class="fas fa-phone"></i>
                <input type="number" placeholder="Phone" name="phone">
            </div>

            <div class="textbox">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Password" name="pass">
            </div>

            <div class="textbox">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Confirm password" name="cPass">
            </div>



            <input type="submit" class="btn" value="Register" name="login">
            <a href="login.jsp">Back to login</a>
        </div>
        <h3 style="color: red"> ${message}</h3>
    </form>



</html>  