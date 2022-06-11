/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Group {
    private String groupID;
    private Lecture lecture;
    private Subject subject;
    private ArrayList<Student> studentList;
    private ArrayList<Session> sessionList;

    public Group() {
    }

    public String getGroupID() {
        return groupID;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public Subject getSubject() {
        return subject;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public ArrayList<Session> getSessionList() {
        return sessionList;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void setSessionList(ArrayList<Session> sessionList) {
        this.sessionList = sessionList;
    }
    
    
}
