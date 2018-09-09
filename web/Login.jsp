<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 

javax.servlet.http.Cookie ck[]=request.getCookies();
String v1="",v2="";
if(ck!=null){
for(int i=0;i<ck.length;i++)
{
String name=ck[i].getName();
if(name.equals("name"))
{
v1=ck[i].getValue();
}
if(name.equals("password"))
{
v2=ck[i].getValue();
}
}
}

%>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .page-header{
                color:#006064;
            }
            .jumbotron{
                color: grey;
                background-color:rgba(255, 255, 255, 0.94);
            }
            .bodyji{
                background-image: url(2.jpg);
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
        </style>
        
    </head>
    <body class="bodyji">
        <div class="container">
            <div class="page-header">
                <h1>Login</h1>
                <a href="SignUp.jsp" class="btn btn-lg pull-right btn-primary" style="margin-top:-50px">SIGN UP</a>
            </div>
            <br><br><br><br><br>
            <div class="row">
                <div class="col-lg-6 col-md-offset-3 col-sm-offset-2 col-lg-offset-3 col-md-6 col-sm-8 col-xs-12">
            <div class="jumbotron ">
                <br>
                <form action="LoginVerify" method="post">
                    <div class="input-group input-group-md">
                        <span class="input-group-addon">Name</span>
                        <input type="text" class="form-control" value="<%=v1%>" name="name">
                    </div><br>
                    <div class="input-group input-group-md">
                        <span class="input-group-addon">Password</span>
                        <input type="password" class="form-control" value="<%=v2%>" name="password">
                    </div><br>
                    <div class="input-group input-group-md">
                        <input type="checkbox" style="height:15px;width:15px" value="checked" name="save">
                        <span style="font-size: 15px">  Save Password</span>
                        
                    </div><br><br>
                    <input type="submit" class="btn btn-primary btn-md" value="Login">
                </form>
            </div>
                </div>
            </div>
            
        </div>
    </body>
</html>
