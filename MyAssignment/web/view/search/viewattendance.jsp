<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : viewattendance
    Created on : Jun 30, 2022, 9:56:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>View Attendance</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="viewattendance" method="POST" style="text-align: center;font-family: cursive">  
            Lecture <input type="text" name="lecture" value="${lecture.username}" style="font-family: cursive;width: 8%"  readonly/>
            -Group <select name="group">
                <c:forEach var="g" items="${requestScope.groups}">
                    <option style="font-family: cursive">${g.groupID}</option>
                </c:forEach>
            </select> 
<!--            - Subject <select name="subject">
                <c:forEach  var="sub" items="${requestScope.subjects}"> 
                    <option style="font-family: cursive">${sub.subjectID}-${sub.subjectName}</option>
                </c:forEach>
            </select>  -->
            <input type="submit" value="View" style="font-family: cursive"/> <br> 
            <c:if test="${attendances ne null and groups ne null}">
                <div style="font-weight: bold; font-size: 20px">Attendance for lecture ${lecture.lectureName} - PRJ301 - SE1631 - Slot 1 - DE201C</div>
            </c:if>
            <table border="2" style="width: 100%">
                <tr style="background-color: #fa9600">
                    <td>
                        Session 
                    </td>
                    <td>
                        HE1600001 <br>
                        Student Name
                    </td>
                    <td>
                        HE1600002 <br>
                        Student Name
                    </td>
                    <td>
                        HE1600003 <br>
                        Student Name
                    </td>
                    <td>
                        HE1600004 <br>
                        Student Name
                    </td>
                    <td>
                        HE1600005 <br>
                        Student Name
                    </td>
                </tr>
                <tr>
                    <td>
                        No.1 <br>
                        01/06/2022
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td >
                    <td style="color: #05F700">
                        Present 
                    </td>
                    <td style="color: #05F700">
                        Present 
                    </td>
                </tr>
                <tr>
                    <td>
                        No.2 <br>
                        03/06/2022
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td>
                    <td style="color: red">
                        Absent
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td >
                    <td style="color: #05F700">
                        Present 
                    </td>
                    <td style="color: red">
                        Absent 
                    </td>
                </tr>
                <tr>
                    <td>
                        No.3 <br>
                        05/06/2022
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td >
                    <td style="color: #05F700">
                        Present 
                    </td>
                    <td style="color: #05F700">
                        Present 
                    </td>
                </tr>
                <tr>
                    <td>
                        No.4 <br>
                        07/06/2022
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td >
                    <td style="color: #05F700">
                        Present 
                    </td>
                    <td style="color: #05F700">
                        Present 
                    </td>
                </tr>
                <tr>
                    <td>
                        No.5 <br>
                        09/06/2022
                    </td>
                    <td style="color: #05F700">
                        Present
                    </td>
                    <td style="color: red">
                        Absent 
                    </td>
                    <td style="color: red">
                        Absent 
                    </td>
                    <td style="color: #05F700">
                        Present 
                    </td>
                    <td style="color: #05F700">
                        Present 
                    </td>
                </tr>
                <tr>
                    <td>
                        Absent so far <br>
                        Total 5 
                    </td>
                    <td>
                        0%
                    </td>
                    <td>
                        40%
                    </td> 
                    <td>
                        20%
                    </td>
                    <td>
                        0%
                    </td>
                    <td>
                        20%
                    </td>                    
                </tr>

            </table> </br>
        </form>
    </body>
</html>
