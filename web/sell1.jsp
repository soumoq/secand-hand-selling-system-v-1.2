

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="ready_sell" enctype="multipart/form-data" method="post">
            <div class="col-sm-4">

                <div alight="left">
                    <label class="form-label">Product name</label>
                    <input type="text" class="form-control" placeholder="Product name" name="pname" id="sname" required="">                         
                </div>
                
                <input type="submit" id="submit" value="sell" name="Sell" class="btn btn-info"> 
            </div>
            
        </form>
    </body>
</html>
