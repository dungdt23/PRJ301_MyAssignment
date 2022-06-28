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
        <form action="timetable" method="POST" style="text-align: center;font-family: cursive">
            Campus: <select name="campus">
                <option style="font-family: cursive">${lecture.campus}</option>
            </select> <Br/>
            <input name="lectureName"value="${lecture.lectureName}" type="hidden"/>
            Lecture: <input type="text" name="lecture" value="${lecture.username}" style="font-family: cursive"  readonly/>
            <input type="submit" value="View" style="font-family: cursive"/> </br>
            <div style="font-weight: bold;font-size: 20px">Activities for ${lecture.username} (${lecture.lectureName})</div>
            <input type="submit" value="View Attendance" style="font-family: cursive;background-color: #fa9600;margin-left: -1000px "/> <br>
            <table border="2" style> 
                <tr style="background-color: #00dbdb">
                    <td style="background-color: #00dbdb">
                        Calendar <br/>
                        <input id="date" type="date" name="date"/>
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
                                        </a>
                                    </c:if>
                                </c:forEach>     
                            </td>

                        </c:forEach>
                    </tr>
                </c:forEach>


                <!--                <tr>
                                    <td style="background-color: #fa9600">
                                        Slot 1
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                </tr>                       
                                <tr>
                                    <td style="background-color: #fa9600">
                                        Slot 2
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                </tr> 
                                <tr>
                                    <td style="background-color: #fa9600"> 
                                        Slot 3
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                </tr> 
                                <tr>
                                    <td style="background-color: #fa9600">
                                        Slot 4
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                </tr> 
                                <tr>
                                    <td style="background-color: #fa9600">
                                        Slot 5
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                </tr> 
                                <tr>
                                    <td style="background-color: #fa9600">
                                        Slot 6
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                </tr> 
                                <tr>
                                    <td style="background-color: #fa9600">
                                        Slot 7
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                </tr> 
                                <tr>
                                    <td style="background-color: #fa9600">
                                        Slot 8
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                    <td>
                                        <a href="attendance">
                
                                        </a>
                                    </td>
                                </tr> -->
            </table>
        </form>
    </body>
</html>
