<%-- 
    Document   : newBook
    Created on : Jul 8, 2020, 7:08:58 AM
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
            .nav-link:hover{
                background-color: dimgray;
            }
            .nav-item{
                margin-right: 1rem;
            }
            .form-inline{
                margin-right: 2rem;
            }
            .navbar{
                overflow: hidden;
                position: fixed;
                top: 0;
                width: 100%;
                z-index: 100;
            }
            .main{
                margin-top: 70px;
            }
            h2{
                text-align: center;
            }
            .form-control{
                border: 1px solid;
            }
            .form-group{
                margin-bottom: 0.5rem;
            }

        </style>
        <title>Add New Book Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home.jsp"><img src="Resource/logo_FPT.png" style="height: 30px"/> FPT Library</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="home.jsp">HOME <span class="sr-only">(current)</span></a>
                        </li>
                        <c:if test="${sessionScope.USER.roleID!='RL001'}">  
                            <li class="nav-item">
                                <a class="nav-link" href="#">YOUR HISTORY</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="viewCart.jsp">YOUR CART</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.USER.roleID=='RL001'}">  
                            <li class="nav-item">
                                <a class="nav-link" href="#">ORDER LIST</a>
                            </li>
                        </c:if>
                    </ul>
                    <form class="form-inline my-2 my-lg-0" action="MainController">
                        <c:if test="${sessionScope.USER!=null}">
                            <c:if test="${not empty sessionScope.USER}">
                                <button class="btn btn-light my-2 my-sm-0 " type="submit" value="Logout" name="btnAction">LOGOUT</button>
                            </c:if>       
                        </c:if>
                        <c:if test="${sessionScope.USER==null}">
                            <button class="btn btn-light my-2 my-sm-0 btnRegister" type="submit" value="Logout" name="btnAction">LOGIN</button>
                        </c:if>

                    </form>
                </div>
            </div>

        </nav>

        <div class="container-fluid main row">
            <div class="col-3"></div>
            <div class="col-6">
                <h2>INFORMATION OF NEW BOOK</h2>
                <form action="MainController" method="POST">
                    <div class="form-group">
                        <label >Book ID</label>
                        <input type="text" class="form-control" placeholder="Enter bookId" name="txtBookID"/> 
                        <c:if test="${not empty sessionScope.ERROR_ADD_NEW_BOOK.errorBookID}">
                            <font color="red"><small>${sessionScope.ERROR_ADD_NEW_BOOK.errorBookID}</small></font> 
                            </c:if>
                    </div>    
                    <div class="form-group">
                        <label >Name</label>
                        <input type="text" class="form-control" placeholder="Enter book's name"  name="txtBookName"/> 
                        <c:if test="${not empty sessionScope.ERROR_ADD_NEW_BOOK.errorBookName}">
                            <font color="red"><small>${sessionScope.ERROR_ADD_NEW_BOOK.errorBookName}</small></font> 
                            </c:if>
                    </div>  
                    <div class="form-group">
                        <label  >Author</label>
                        <input type="text" class="form-control" placeholder="Enter book's author"  name="txtAuthor"/>      
                        <c:if test="${not empty sessionScope.ERROR_ADD_NEW_BOOK.errorAuthor}">
                            <font color="red"><small>${sessionScope.ERROR_ADD_NEW_BOOK.errorAuthor}</small></font> 
                            </c:if>
                    </div>  
                    <div class="form-group">
                        <label >Public Date</label>
                        <input type="date" class="form-control" placeholder="Enter book's public date"  name="txtPublicDate"/>    
                        <c:if test="${not empty sessionScope.ERROR_ADD_NEW_BOOK.errorPublicDate}">
                            <font color="red"><small>${sessionScope.ERROR_ADD_NEW_BOOK.errorPublicDate}</small></font> 
                            </c:if>
                    </div> 
                    <label>Link Image</label>
                    <div class="input-group mb-3">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" id="inputGroupFile02" name="txtLinkImage">
                            <label class="custom-file-label" for="inputGroupFile02" aria-describedby="inputGroupFileAddon02" style="border: 1px solid;">Choose file</label> 
                        </div>
                    </div>
                    <c:if test="${not empty sessionScope.ERROR_ADD_NEW_BOOK.errorLinkImage}">
                        <font color="red"><small>${sessionScope.ERROR_ADD_NEW_BOOK.errorLinkImage}</small></font> 
                        </c:if>
                    <div class="form-group">
                        <label  >Quantity</label>
                        <input type="text" class="form-control" min="0" placeholder="Enter book's quantity" name="txtQuantity"/>  
                        <c:if test="${not empty sessionScope.ERROR_ADD_NEW_BOOK.errorQuantity}">
                            <font color="red"><small>${sessionScope.ERROR_ADD_NEW_BOOK.errorQuantity}</small></font> 
                            </c:if>
                    </div>  
                    <div>
                        <label>Price</label>
                        <div class="form-group input-group">
                            <input type="text" class="form-control" name="txtPrice" placeholder="Enter book's price" >
                            <div class="input-group-append">
                                <span class="input-group-text" style="border: 1px solid;">$</span>
                            </div>          

                        </div>  
                        <c:if test="${not empty sessionScope.ERROR_ADD_NEW_BOOK.errorPrice}">
                            <font color="red"><small>${sessionScope.ERROR_ADD_NEW_BOOK.errorPrice}</small></font> 
                            </c:if>
                    </div>

                    <br>
                    <button type="submit" class="btn btn-primary btn-block" name="btnAction" value="Submit New Book">Submit</button>
                    </br>
                </form>
            </div>
            <div class="col-3"></div>

            <c:remove var="ERROR_ADD_NEW_BOOK" scope="session"></c:remove>
        </div>    
    </body>
    <script>
// Add the following code if you want the name of the file appear on select
        $(".custom-file-input").on("change", function () {
            var fileName = $(this).val().split("\\").pop();
            $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
        });
    </script>
</html>
