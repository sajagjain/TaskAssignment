<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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
                <h1>Sign Up</h1>
                <a href="Login.jsp" class="btn btn-lg pull-right btn-primary" style="margin-top:-50px">Login</a>
            </div>
            <br><br>
            <div class="row">
                <div class="col-lg-6 col-md-offset-3 col-sm-offset-2 col-lg-offset-3 col-md-6 col-sm-8 col-xs-12">
            <div class="jumbotron ">
                <br>
                <form action="Signup" method="get">
                    <div class="input-group input-group-md">
                        <span class="input-group-addon">Your Name</span>
                        <input type="text" class="form-control" placeholder="Full Name" name="fullname">
                    </div><br>
                    <div class="input-group input-group-md">
                        <span class="input-group-addon">Email ID</span>
                        <input type="email" class="form-control" name="email">
                    </div><br>
                    <div class="input-group input-group-md">
                        <span class="input-group-addon">Age</span>
                        <input type="text" class="form-control" name="age">
                    </div><br>    
                    <div class="input-group input-group-md">
                        <span class="input-group-addon">Password</span>
                        <input type="password" class="form-control" name="password">
                    </div><br>
                    <div>
                        <select name="role" class="form-control">
                            <option value="Admin" >Admin</option>
                            <option value="Coordinator" >Co-ordinator</option>
                            <option value="Member" >Member</option>
                        </select>
                    </div><br>
                    <div class="input-group input-group-md">
                        <label class="radio-inline"><input type="radio" style="height:15px;width:15px" name="gender" value="male"><span style="font-size: 18px">Male</span></label>
                        <label class="radio-inline"></label>
                        <label class="radio-inline"></label>
                        <label class="radio-inline"><input type="radio" style="height:15px;width:15px" name="gender" value="female"><span style="font-size: 18px">Female</span></label>
                    </div><br>
                    <div class="input-group input-group-md">
                        <p style="font-size: 15px">By Checking this Check box you agree to the Terms and Conditions.</p>
                        <input type="checkbox" style="height:15px;width:15px" value="checked" name="terms">
                    </div><br><br>
                    <input type="submit" class="btn btn-primary btn-md" style="al" value="Sign Up">
                </form>
            </div>
                </div>
            </div>
            
        </div>
    </body>
</html>
