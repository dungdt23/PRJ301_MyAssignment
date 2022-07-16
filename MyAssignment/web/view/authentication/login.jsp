<%-- 
    Document   : authentication
    Created on : Jun 5, 2022, 10:41:18 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="view/authentication/login.css" rel="stylesheet" type="text/css" />
        <title>Login</title>
    </head>
    <body style="background-color: #81F7D2">
        <header style="text-align: center">
            <img src="img/img1.png" alt=""/>
        </header>
        <form action="authentication" method="POST">
            <div style="background-color: #EDB442;font-family: cursive;margin-top: 50px;width: 50%;margin-left: 300px;padding: 40px">
                Campus: <select name="campus">    
                    <c:forEach var="c" items="${requestScope.campus}">
                        <option value="${c}" style="font-family: cursive"">
                            ${c}
                        </option>
                    </c:forEach>
                </select> <Br/>
                Lecture Username: <input type="text" name="username"/> <br/>
                Lecture Password: <input type="password" name="password"/> <br>
                <input type="submit" value="Login" style="font-family: cursive""/>                
            </div>

        </form>
    </body>
</html>
