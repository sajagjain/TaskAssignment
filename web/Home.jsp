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
    MongoCollection coll=db.getCollection("users");
    MongoCollection coll2=db.getCollection("challenge");
    MongoCursor cur=coll.find(new Document("role","Coordinator")).iterator();
    MongoCursor cur2=coll2.find().iterator();
    MongoCursor cur3=coll.find(new Document("role","Member")).iterator();
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
            <h1>Admin</h1>
            <a href="Logout" class="btn btn-lg pull-right btn-primary" style="margin-top:-50px">LOGOUT</a>
        </div>
        <div class="jumbotron">
            <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
            <p style="font-size:30px">
                Create A New Challenge.
            </p>
            <form action="Task" method="get">
                <div class="input-group input-group-md"><span class="input-group-addon">Task Name</span>
                    <input type="text" class="form-control" name="taskname">
                </div><br>
                <div class="input-group input-group-md"><span class="input-group-addon">Project Coordinator</span>
                <select class="form-control" name="coordinator">
                    <%  Document doc;
                        while(cur.hasNext()){
                        doc=(Document)cur.next();
                        
                    %>
                    <option value="<%=doc.get("name")%>"><%=doc.get("name")%></option>
                    <%}%>
                </select>
                </div><br>
                <div class="input-group input-group-md"><span class="input-group-addon">Project Members</span>
                <select multiple class="form-control" name="member">
                    <%  Document doc3;
                        while(cur3.hasNext()){
                        doc3=(Document)cur3.next();
                        
                    %>
                    <option value="<%=doc3.get("name")%>"><%=doc3.get("name")%></option>
                    <%}%>
                </select>
                </div><br>
                <div class="input-group input-group-md">
                    <span class="input-group-addon">Start Date</span>
                    <input type="date" class="form-control" name="startdate">
                </div><br>
                <div class="input-group input-group-md">
                    <span class="input-group-addon">End Date</span>
                    <input type="date" class="form-control" name="enddate">
                </div><br>
                <div class="input-group input-group-md">
                    <span class="input-group-addon">Description</span>
                    <textarea row="10" class="form-control" name="description"></textarea>
                </div><br><br><br>
                <div class="input-group input-group-md">
                    <input type="submit" class="btn btn-md btn-primary" value="Post">
                </div>
            </form>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                <p style="font-size:30px">
                Task Assigned Before
                </p>
                <%while(cur2.hasNext()){
                    Document doc2=(Document)cur2.next();
                %>    
                <div class="media">
                <div class="media-left media-top">
                <a href="#">
                    <div class="media-object" style="height: 100px;color: white;text-align:center;font-size:70px;background-color:rgba(54, 159, 173, 0.88);width:100px">C</div>
                </a>
                </div>
                <div class="media-body">
                <h4 class="media-heading"><%=doc2.get("taskname")%></h4>
                <h5 class="media-heading"><%=doc2.get("coordinator")%></h5>
                <h5 class="media-heading"><%=doc2.get("member")%>
                <h5 class="media-heading"><%=doc2.get("startdate")%>---<%=doc2.get("enddate")%></h5>
                
                <p style="font-size:15px"><%=doc2.get("description")%></p>
                </div>
            </div>
            <hr size="20">
            <%}%>
        </div>
</div>
</div>
</div>
    </body>
</html>
