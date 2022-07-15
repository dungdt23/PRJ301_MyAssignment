<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="view/search/timetable.css" rel="stylesheet" type="text/css" />
        <title>Timetable</title>
    </head>
    <body>
        <form id="dungdt" action="timetable" method="POST" style="font-family: cursive;text-align: center">
            Campus: <select name="campus">
                <option style="font-family: cursive">${lecture.campus}</option>
            </select> <Br/>
            <input name="lectureName"value="${lecture.lectureName}" type="hidden"/>
            Lecture: <input type="text" name="username" value="${lecture.username}" style="font-family: cursive"  readonly/>
            <input type="submit" value="View" style="font-family: cursive"/> </br>
            <div style="font-weight: bold;font-size: 20px">Activities for ${lecture.username} (${lecture.lectureName})</div>         
            <!--                <input type="submit" value="View Attendance" style="font-family: cursive;background-color: #fa9600;margin-left: -1000px "/> <br>  
            -->     
            <div style="background-color: #fa9600;padding: 5px;color: black">
                <a href="viewattendance?lectureID=${lecture.lectureID}" style="font-family: cursive">View Attendance</a>
                <a href="authentication" style="font-family: cursive">Logout</a><Br>                  
            </div>

            <table border="2" style="width: 100%"> 
                <tr style="background-color: #00dbdb">
                    <td style="background-color: #00dbdb">
                        Calendar <br/>
                        <input id="date" type="date" name="date""/>
                    </td >
                    <c:forEach var="w" items="${requestScope.weekdays1}">
                        <td style="background-color: #00dbdb">${w}</td> 
                    </c:forEach>
                </tr>  
                <c:forEach var="s" items="${requestScope.slots}">
                    <tr>
                        <td style="background-color: #fa9600">
                            ${s.slotID} <br/>
                            ${s.startSlot} - ${s.endSlot} 
                        </td>
                        <c:forEach var="w" items="${requestScope.weekdays}">    
                            <td >
                                <c:forEach var="se" items="${requestScope.sessions}">
                                    <c:if test="${se.timeslot.slotID eq s.slotID and se.date.toString() eq w }">
                                        <a href="attendance?sessionID=${se.sessionID}">
                                            ${se.group.groupID} - at
                                            ${se.room.roomID} <br>
                                            Subject: ${se.group.subject.subjectID}
                                            <c:if test="${se.attendanceStatus eq 'true'}">
                                                <p style="color: green">Attended</p>
                                            </c:if>
                                            <c:if test="${se.attendanceStatus eq 'false'}">
                                                <p style="color: red">Not yet</p>

                                            </c:if>
                                        </a>
                                    </c:if>
                                </c:forEach>     
                            </td>

                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </form>

    </body>
</html>
