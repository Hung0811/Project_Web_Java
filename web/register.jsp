<%-- 
    Document   : register
    Created on : Jun 25, 2020, 9:45:22 AM
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
                width:90%;
                margin-top: 20px;
                border-top: 1px solid rgba(0,0,0,1);
            }
            .card-title{
                background: #fff;
                width:130px;
                margin:-39px auto 10px;
            }
            .form-group{
                margin-bottom: 0.5rem;
            }
            body{
                background: url("https://i.pinimg.com/originals/38/6f/47/386f47c88a7aaa497ec6edc1c02cc9b6.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }

        </style>
        <title>Register Page</title>
    </head>
    <body>
        <div class="container" >
            <div class="card" style="width: 22rem;">
                <div class="card-body">
                    <hr>
                    <h5 class="card-title">Register</h5>
                    <form action="MainController" method="POST">
                        <div class="form-group">
                            <label for="exampleInputEmail1" >Full name</label>
                            <input type="text" class="form-control"placeholder="Enter full name" name="txtFullName"/>
                            <c:if test="${not empty sessionScope.ERROR_USER.errorFullName}">
                                <font color="red"><small>${sessionScope.ERROR_USER.errorFullName}</small></font> 
                            </c:if>
                        </div> 
                        <div class="form-group">
                            <label for="exampleInputEmail1" >User name</label>
                            <input type="text" class="form-control"placeholder="Enter user name" name="txtUserName"/>
                            <c:if test="${not empty sessionScope.ERROR_USER.errorUserName}">
                                <font color="red"><small>${sessionScope.ERROR_USER.errorUserName}</small></font> 
                                </c:if>

                        </div>    
                        <div class="form-group">
                            <label for="exampleInputPassword1" >Password</label>
                            <input type="password" class="form-control" placeholder="Enter password" name="txtPassword">
                            <c:if test="${not empty sessionScope.ERROR_USER.errorPassword}">  
                                <font color="red"><small>${sessionScope.ERROR_USER.errorPassword}</small></font> 
                                </c:if>

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1" >Re-Password</label>
                            <input type="password" class="form-control" placeholder="Confirm password" name="txtRepassword">
                            <c:if test="${not empty sessionScope.ERROR_USER.errorRePassword}">
                                <font color="red"><small>${sessionScope.ERROR_USER.errorRePassword}</small></font>
                                </c:if>         
                        </div>
                        <c:remove var="ERROR_USER" scope="session"></c:remove>
                        <br/>
                        <button type="submit" class="btn btn-primary btn-block" name="btnAction" value="Register Now">Register Now</button>  
                        </br>
                        </br>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
