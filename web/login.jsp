<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>  
    <head><title>Simple jsp page</title>
        <link rel="stylesheet" href="add.css">
    </head>  
    <body>

        <form action="login">
            <div class="login-box">
                <h1>Login</h1>
                <div class="textbox">
                    <i class="fas fa-user"></i>
                    <input type="text" placeholder="Username" name="username">
                </div>

                <div class="textbox">
                    <i class="fas fa-lock"></i>
                    <input type="password" placeholder="Password" name="pass">
                </div>

                <input type="submit" class="btn" value="Sign in" name="login">

            </div>
        </form>
    </body>  
</html>  