<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : timetable
    Created on : Jun 7, 2022, 5:48:18 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="view/search/timetable.css" rel="stylesheet" type="text/css" />
        <title>Timetable</title>
    </head>
    <body>
        <form action="authentication" method="POST">
            Campus: <select name="campus">
                <option>FU-HL</option>
            </select> <Br/>
            Lecture: <input type="text" name="lecture"/>
            <input type="submit" value="View"/>
            <table border="2"> 
                <tr style="background-color: #81DAF5">
                    <td style="background-color: #81DAF5">
                        YEAR <br/>
                        <select>
                            <option>2022</option>
                        </select>
                    </td >
                    <td style="background-color: #81DAF5">MON</td>
                    <td style="background-color: #81DAF5">TUE</td>
                    <td style="background-color: #81DAF5">WED</td>
                    <td style="background-color: #81DAF5">THUR</td>
                    <td style="background-color: #81DAF5">FRI</td>
                    <td style="background-color: #81DAF5">SAT</td>
                    <td style="background-color: #81DAF5">SUN</td>
                </tr>  

                <tr>
                    <td style="background-color: #81DAF5">
                        WEEK
                        <select>
                            <option>06/06-12/06</option>                            
                        </select>
                    </td>
                    <td style="background-color: #81DAF5">06/06</td>
                    <td style="background-color: #81DAF5">07/06</td>
                    <td style="background-color: #81DAF5">08/06</td>
                    <td style="background-color: #81DAF5">09/06</td>
                    <td style="background-color: #81DAF5">10/06</td>
                    <td style="background-color: #81DAF5">11/06</td>
                    <td style="background-color: #81DAF5">12/06</td>
                </tr>  
                <c:forEach var="s" items="${requestScope.slots}">
                    <tr>
                        <td>
                            ${s.slotID}
                        </td>
                        <td>
                            PRJ301-View Materials
                            at DE-C201                           
                        </td>
                        <td>
                            MAS291-View Materials
                            at DE-C201
                        </td>
                        <td>
                            MAS291-View Materials
                            at DE-C201
                        </td>
                        <td>
                            MAS291-View Materials
                            at DE-C201
                        </td>
                        <td>
                            PRJ301-View Materials
                            at DE-C201
                        </td>
                        <td>
                            PRJ301-View Materials
                            at DE-C201
                        </td>
                        <td>
                            PRJ301-View Materials
                            at DE-C201
                        </td>
                    </tr>  
                </c:forEach>
            </table>
        </form>
    </body>
</html>
