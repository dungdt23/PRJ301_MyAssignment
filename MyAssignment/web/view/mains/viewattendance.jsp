<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    <body style="background-color: #81F7D2">
        <form action="viewattendance" method="POST" style="text-align: center;font-family: cursive">  
            <div style="text-align: center;font-family: cursive;font-size: 35px;font-weight: bold">   
                View Attendance
            </div><br>
            Lecture <input type="text" name="username" value="${lecture.username}" style="font-family: cursive;width: 8%"  readonly/>
            -Group <select name="group">
                    <option style="font-family: cursive">----</option>
                <c:forEach var="g" items="${requestScope.groups}">
                    <option style="font-family: cursive">${g.groupID}</option>
                </c:forEach>
            </select>   
            <input type="hidden" name="lectureID" value="${lecture.lectureID}" style="font-family: cursive"/>            
            <input type="submit" value="View" style="font-family: cursive"/> <br> 
            <a href="timetable"> Home </a>
            <a href="authentication" style="font-family: cursive">Logout</a><Br> 
            <c:if test="${requestScope.students ne null}">
                <table border="2" style="width: 100%;background-color: white">
                    <tr style="background-color: #fa9600">
                        <td>
                            Session 
                        </td>
                        <c:forEach var="s" items="${requestScope.students}">
                            <td>
                                ${s.studentID} <br>
                                ${s.studentName}
                            </td>
                        </c:forEach>
                    </tr>
                    <c:set var="secCount" value="0" scope="page" />
                    <c:forEach var="se" items="${requestScope.sessions}">
                        <c:set var="secCount" value="${secCount + 1}" scope="page"/>
                        <tr> 
                            <td>
                                No. ${secCount} <br>
                                ${se.date}                   
                            </td>  
                            <c:forEach var="s" items="${requestScope.students}">
                                <td>
                                    <c:forEach var="a" items="${requestScope.attendances}">
                                        <c:if test="${a.student.studentID eq s.studentID and a.session.sessionID eq se.sessionID}">
                                            <c:if test="${a.attendanceStatus eq 'true'}">
                                                <p style="color: green">present</p>
                                            </c:if>
                                            <c:if test="${a.attendanceStatus eq 'false'}">
                                                <p style="color: red">absent</p>
                                            </c:if>

                                        </c:if>

                                    </c:forEach>

                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                    <tr >
                        <td>
                            Absent so far <br>
                            Total ${total}
                        </td>
                        <c:forEach var="s" items="${requestScope.students}">
                            <td>
                                <c:forEach var="a" items="${requestScope.absents}">
                                    <c:if test="${a.key.studentID eq s.studentID}">                                 
                                        <p><fmt:formatNumber value = "${(a.value / total) * 100}" 
                                                          type = "number" maxFractionDigits = "2"/>%</p> 
                                        </c:if>
                                    </c:forEach>
                            </td>
                        </c:forEach>
                    </tr>
                </table> </br>               
            </c:if>
        </form>
    </body>
</html>
