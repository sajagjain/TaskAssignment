<%@page import="com.mongodb.client.MongoCursor"%>
<%@page import="org.bson.Document"%>

<%@page import="com.mongodb.client.MongoDatabase"%>
<%@page import="com.mongodb.client.MongoCollection"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    MongoClient client=new MongoClient();
    MongoDatabase db=client.getDatabase("grevesoft");
    
    MongoCollection coll2=db.getCollection("challenge");
    String name=(String)request.getParameter("name");
    MongoCursor cur2=coll2.find(new Document("member",name)).iterator();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        
        <title>Home</title>
    </head>
    <body class="bodyji">
        <div class="container">
        <div class="page-header">
            <h1>Member</h1>
            <a href="Logout" class="btn btn-lg pull-right btn-primary" style="margin-top:-50px">LOGOUT</a>
        </div>
        
            <div class="row">
            <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-12">
                <div class="jumbotron">
                <p style="font-size:30px">
                Task Assigned
                </p>
                <%while(cur2.hasNext()){
                    Document doc2=(Document)cur2.next();
                    
                %>   
                <hr size="20">
                <div class="media">
                <div class="media-left media-top">
                
                    <div class="media-object" style="height: 100px;color: white;text-align:center;font-size:70px;background-color:rgba(54, 159, 173, 0.88);width:100px">C</div>
                
                </div>
                <div class="media-body">
                <h4 class="media-heading"><%=doc2.get("taskname")%></h4>
                <h5 class="media-heading"><%=doc2.get("coordinator")%></h5>
                <h5 class="media-heading"><%=doc2.get("member")%>
                <h5 class="media-heading"><%=doc2.get("startdate")%>---<%=doc2.get("enddate")%></h5>
                <p style="font-size:15px"><%=doc2.get("description")%></p>
                </div>
                
            </div>
            
            <%}%>
        </div>
</div>
</div>
</div>
    </body>
</html>
