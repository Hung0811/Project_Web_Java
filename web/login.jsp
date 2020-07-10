<%-- 
    Document   : login
    Created on : Jun 24, 2020, 8:20:31 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <style>
            .card{
                margin:0 auto;
                margin-top:10vh;
                background: #fff;
                box-shadow: 0px 0px 10px 0px #000;
            }
            .card-title{
                font-size:2rem;
                margin-bottom: 2rem;
                text-align: center;

            }
            label{
                font-weight: bold;
                margin-bottom: 0.2rem;
            }
            hr{
                width:80%;
                margin-top: 20px;
                border-top: 1px solid rgba(0,0,0,1);
            }
            .o{
                background: #fff;
                width:25px;
                margin:-29px auto 10px;
            }
            body{
                background: url("https://i.pinimg.com/originals/38/6f/47/386f47c88a7aaa497ec6edc1c02cc9b6.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>

        <title>Login Page</title>

    </head>
    <body>
        <div class="container">
            <div class="card" style="width: 22rem;">
                <div class="card-body">
                    <h5 class="card-title">Sign in</h5>
                    <form action="MainController" method="POST">
                        <div class="form-group">
                            <label for="exampleInputEmail1" >User name</label>
                            <input type="text" class="form-control" placeholder="Enter user name" name="txtUserName"/>                           
                        </div>    

                        <label for="exampleInputPassword1" >Password</label>
                        <input type="password" class="form-control" placeholder="Enter password" name="txtPassword">
                        <c:if test="${not empty sessionScope.LOGIN_FAIL}">
                            <font color="red"><small>${sessionScope.LOGIN_FAIL}</small></font> 
                            </c:if>
                        <br/>
                        <c:remove var="LOGIN_FAIL" scope="session"></c:remove>

                        <button type="submit" class="btn btn-primary btn-block" name="btnAction" value="Login">Sign in</button>
                        <hr>
                        <p class="o">OR</p>
                        <button type="submit" class="btn btn-primary btn-block" name="btnAction" value="Register">Register</button>  
                        </br>
                        </br>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
