<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        
        <link rel="stylesheet" href="add.css">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>

    </head>
    <body>
        Name : ${name}
        <br>
        User name : ${user_name}
        <br>
        phone : ${phone}





       <form action="ready_sell" >
            <div class="col-sm-4">

                <div alight="left">
                    <label class="form-label">Product name</label>
                    <input type="text" class="form-control" placeholder="Product name" name="pname" id="sname" required="">                         
                </div>

                <div alight="left">
                    <label class="form-label">Price</label>
                    <input type="number" class="form-control" placeholder="Product price" name="pprice" id="pprice" required="">                         
                </div>
                
                <br>
                
                
                
                <br>

                <div alight="left">
                    <label class="form-label">Product details</label>
                    <br>
                    <textarea name="pdetails" rows="10" cols="30" placeholder="Product details"></textarea>     
                    <input type="submit" id="submit" value="next" name="Sell" class="btn btn-info"> 
                </div>

            </div>

        </form>

    </body>
</html>