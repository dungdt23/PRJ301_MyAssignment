<%-- 
    Document   : login_confirm
    Created on : Jul 12, 2022, 4:30:36 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: #81F7D2">
        <header style="font-weight: bold;font-family: cursive;text-align: center;font-size: 50px;background-color: #EDB442;padding: 60px">
            FPT University Academic Portal 
        </header>   
        <div style="background-color: white;text-align: center;margin-top: 20px">
            <div style="font-weight: bold;font-family: cursive;font-size: 25px">
                Hello  lecture ${lecture.lectureName}
            </div>
            <a href="timetable" style="font-weight: bold;font-family: cursive;font-size: 20px">
                View Timetable
            </a> <br>
            <a href="viewattendance?lectureID=${lecture.lectureID}" style="font-weight: bold;font-family: cursive;font-size: 20px"">
                View Attendance
            </a> <br>
            <a href="authentication" style="font-weight: bold;font-family: cursive;font-size: 20px">
                Logout
            </a> <br>            
        </div>

    </body>
</html>
