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
                <option>FU-HL</option>
            </select> <Br/>
            Lecture: <input type="text" name="lecture"/>
            <input type="submit" value="View"/>
        </form>
    </body>
</html>
