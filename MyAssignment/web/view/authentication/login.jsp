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
    <body>
        <header>
            <img src="img/img1.png"/>
        </header>
        <form action="authentication" method="POST">
            Campus: <select name="campus">    
                <c:forEach var="c" items="${requestScope.campus}">
                    <option value="${c}">
                        ${c}
                    </option>
                </c:forEach>
            </select> <Br/>
            Lecture Username: <input type="text" name="username"/> <br/>
            Lecture Password: <input type="password" name="password"/>
            <input type="submit" value="View"/>
        </form>
    </body>
</html>
