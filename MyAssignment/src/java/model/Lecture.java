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
public class Lecture {
    private String username;
    private String password;
    private String lectureID;
    private String lectureName;
    private String campus;
    private ArrayList<Group> groupList;

    public Lecture() {
    }

    @Override
    public String toString() {
        return "Lecture{" + "username=" + username + ", password=" + password + ", lectureID=" + lectureID + ", lectureName=" + lectureName + ", campus=" + campus + ", groupList=" + groupList + '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLectureID() {
        return lectureID;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getCampus() {
        return campus;
    }

    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void setLectureID(String lectureID) {
        this.lectureID = lectureID;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setGroupList(ArrayList<Group> groupList) {
        this.groupList = groupList;
    }
    
}
