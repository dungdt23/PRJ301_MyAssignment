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
    <body>
        <form action="attendance" method="POST" style="text-align: center;font-family: cursive"> 
            <input type="hidden" value="${session.sessionID}" name="sessionID" />
            <a href="authentication"> Home </a>
            <table border="2" style="width: 100%">
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
                            Absent <input type="radio" checked="checked" name="status${stu.studentID}" value="absent"/>
                            Present <input type="radio" name="status${stu.studentID}" value="present"/>
                        </td>
                    </tr>
                </c:forEach>

                <!--                <tr>
                                    <td>
                                        HE1600001
                                    </td>
                                    <td>
                                        Student Name
                                    </td>
                                    <td>
                                        <img src="../../img/empty-avatar.jpg" alt=""/>                       
                                    </td>
                                    <td>
                                        stuhe160001@fpt.edu.vn
                                    </td>
                                    <td>
                                        Absent <input type="radio" checked="checked" name="status1" value="absent"/>
                                        Present <input type="radio" name="status1" value="present"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        HE1600002
                                    </td>
                                    <td>
                                        Student Name
                                    </td>
                                    <td>
                                        <img src="../../img/empty-avatar.jpg" alt=""/>                       
                                    </td>
                                    <td>
                                        stuhe1600002@fpt.edu.vn
                                    </td>
                                    <td>
                                        Absent <input type="radio" checked="checked" name="status2" value="absent"/>
                                        Present <input type="radio" name="status2" value="present"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        HE1600003
                                    </td>
                                    <td>
                                        Student Name
                                    </td>
                                    <td>
                                        <img src="../../img/empty-avatar.jpg" alt=""/>                       
                                    </td>
                                    <td>
                                        stuhe160003@fpt.edu.vn
                                    </td>
                                    <td>
                                        Absent <input type="radio" checked="checked" name="status3" value="absent"/>
                                        Present <input type="radio" name="status3" value="present"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        HE1600004
                                    </td>
                                    <td>
                                        Student Name
                                    </td>
                                    <td>
                                        <img src="../../img/empty-avatar.jpg" alt=""/>                       
                                    </td>
                                    <td>
                                        stuhe160004@fpt.edu.vn
                                    </td>
                                    <td>
                                        Absent <input type="radio" checked="checked" name="status4" value="absent"/>
                                        Present <input type="radio" name="status4" value="present"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        HE1600005
                                    </td>
                                    <td>
                                        Student Name
                                    </td>
                                    <td>
                                        <img src="../../img/empty-avatar.jpg" alt=""/>                       
                                    </td>
                                    <td>
                                        stuhe160005@fpt.edu.vn
                                    </td>
                                    <td>
                                        Absent <input type="radio" checked="checked" name="status5" value="absent"/>
                                        Present <input type="radio" name="status5" value="present"/>
                                    </td>
                                </tr>-->
            </table> </br>
            <input type="submit" value="Save" style="text-align: center;padding: 10px 20px;font-size: 20px;background-color: #00dbdb;border-radius: 10%"/>
        </form>
    </body>
</html>
