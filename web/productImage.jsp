
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        hi<% String pName = (String) request.getAttribute("pName");%>
        <%=pName%>
        <br>
        <form action="imageUp" method="POST" enctype="multipart/form-data">
            <input type="file" name="pic" multiple accept="image/*">
            <input type="submit" id="submit" value="sell" name="Sell" class="btn btn-info">
        </form>
    </body>
</html>
