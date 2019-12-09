
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="add.css">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                String code = (String)request.getAttribute("var");
                request.setAttribute("code", code);
            %>
            
            
         <form action="varifaction"  method="POST" >
            <div class="col-sm-4">

                <div alight="left">
                    <label class="form-label">Enter verifaction code</label>
                    <input type="number" class="form-control" placeholder="Varifaction code" name="pname" id="sname" required="">                         
                </div>
                
                <input type="submit" id="submit" value="varify" name="Sell" class="btn btn-info">
            </div>
         </form>
      
            
    </body>
</html>
