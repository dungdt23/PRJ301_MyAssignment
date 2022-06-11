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
    private String lectureID;
    private String lectureName;
    private String campus;
    private ArrayList<Group> groupList;

    public Lecture() {
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
