/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Session {
    private String sessionID;
    private Group group;
    private Room room;
    private TimeSlot timeslot;
    private ArrayList<Attendance> attendanceList;
    private Date date;

    @Override
    public String toString() {
        return "Session{" + "sessionID=" + sessionID + ", group=" + group + ", room=" + room + ", timeslot=" + timeslot + ", attendanceList=" + attendanceList + ", date=" + date + '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Session() {
    }

    public String getSessionID() {
        return sessionID;
    }

    public Group getGroup() {
        return group;
    }

    public Room getRoom() {
        return room;
    }

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public ArrayList<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
    }

    public void setAttendanceList(ArrayList<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }
    
}
