/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Attendance {
   private String attendanceID;
   private Student student;
   private Session session;
   private boolean attendanceStatus;

    public Attendance() {
    }

    public String getAttendanceID() {
        return attendanceID;
    }

    public Student getStudent() {
        return student;
    }

    public Session getSession() {
        return session;
    }

    public boolean getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceID(String attendanceID) {
        this.attendanceID = attendanceID;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setAttendanceStatus(boolean attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }
   
}
