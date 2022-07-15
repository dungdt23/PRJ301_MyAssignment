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
        <title>Take Attendance</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="background-color: #81F7D2">
        <form action="attendance" method="POST" style="text-align: center;font-family: cursive"> 
            <input type="hidden" value="${session.sessionID}" name="sessionID" />
            <div style="padding: 5px;color: black">
                <a href="timetable"> Timetable </a>
                <a href="authentication" style="font-family: cursive">Logout</a><Br>                
            </div>
            <table border="2" style="width: 100%;background-color: white">
                <tr style="background-color: #fa9600">
                    <td>
                        Student ID
                    </td>
                    <td>
                        Student Name
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
                <c:forEach var="stu" items="${requestScope.students}">
                    <tr>
                        <td>
                            ${stu.studentID}
                            <input type="hidden"name="${stu.studentID}" value="${stu.studentID}">
                        </td>
                        <td>
                            ${stu.studentName}
                            <input type="hidden"name="'studentName'+'${stu.studentID}'" value="${stu.studentName}">                        
                        </td>                         
                        <td>
                            <img src="img/empty-avatar.jpg" alt=""/>
                        </td>
                        <td >
                            ${stu.gmail}
                            <input type="hidden"name="'gmail'+'${stu.studentID}'" value="${stu.gmail}">                        

                        </td>
                        <td>
                            <c:if test="${requestScope.existedAttendance eq null}">
                                Absent <input type="radio" checked="checked" name="status${stu.studentID}" value="absent"/>
                                Present <input type="radio" name="status${stu.studentID}" value="present"/>                                
                            </c:if>
                            <c:if test="${requestScope.existedAttendance ne null}">
                                <c:forEach var="ea" items="${requestScope.existedAttendance}">
                                    <c:if test="${ea.student.studentID eq stu.studentID}">
                                        <c:if test="${ea.attendanceStatus eq false}">
                                            Absent <input type="radio" checked="checked" name="status${stu.studentID}" value="absent"/>
                                            Present <input type="radio" name="status${stu.studentID}" value="present"/>                                             
                                        </c:if>
                                        <c:if test="${ea.attendanceStatus eq true}">
                                            Absent <input type="radio"  name="status${stu.studentID}" value="absent"/>
                                            Present <input type="radio" checked="checked" name="status${stu.studentID}" value="present"/>                                               
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table> </br>
            <input type="submit" value="Save" style="text-align: center;padding: 10px 20px;font-size: 20px;background-color: #fa9600;border-radius: 10%"/>
        </form>
    </body>
</html>
