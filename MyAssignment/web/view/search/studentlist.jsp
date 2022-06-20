<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : studentlist
    Created on : Jun 9, 2022, 9:24:00 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="view/search/studentlist.css" rel="stylesheet" type="text/css" />
        <title>Attendance</title>
    </head>
    <body>
        <form action="attendance" method="POST"> 
            <table border="2">
                <tr>
                    <td>
                        StudentID
                    </td>
                    <td>
                        StudentName
                    </td>
                    <td>
                        Avatar
                    </td>
                    <td>
                        Gmail
                    </td>
                    <td>
                        Status
                    </td>
                </tr>
                <c:forEach var="s" items="${requestScope.students}">
                    <tr>
                        <td>
                            ${s.studentID}
                        </td>
                        <td>
                            ${s.studentName}
                        </td>
                        <td>
                            <img src="img/avatar.jpg" alt=""/>                       
                        </td>
                        <td>
                            None
                        </td>
                        <td>
                            Absent <input type="radio" checked="checked" name="'status'+'${s.studentID}'" value="absent"/>
                            Present <input type="radio" name="'status'+'${s.studentID}'" value="present"/>
                        </td>
                    </tr>

                </c:forEach>
            </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
