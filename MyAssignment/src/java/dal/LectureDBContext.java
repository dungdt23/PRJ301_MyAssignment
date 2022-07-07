/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lecture;
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class LectureDBContext extends DBContext<Lecture> {

    public static void main(String[] args) {
        Lecture lecture = new Lecture();
        lecture.setLectureID("1");
        LectureDBContext dbLecture = new LectureDBContext();
        lecture = dbLecture.getLectureByID(lecture);
        System.out.println(lecture.getLectureName());
    }

    @Override
    public ArrayList<Lecture> list() {
        ArrayList<Lecture> lectures = new ArrayList<>();
        try {
            String sql = "select * from Lecture";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureID(rs.getString("lectureID"));
                lecture.setLectureName(rs.getString("lectureName"));
                lecture.setCampus(rs.getString("campus"));
                lectures.add(lecture);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LectureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lectures;
    }

    public Lecture getLectureByUsername(Lecture entity) {
        try {
            String sql = "select lectureID,campus,password,lectureName \n"
                    + "from Lecture  where username=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getUsername());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                entity.setLectureID(rs.getString("lectureID"));
                entity.setCampus(rs.getString("campus"));
                entity.setLectureName(rs.getString("lectureName"));
                entity.setPassword(rs.getString("password"));
                return entity;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LectureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Lecture getLectureByID(Lecture entity) {
        try {
            String sql = "select lectureID,campus,password,lectureName,username \n"
                    + "from Lecture  where lectureID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getLectureID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                entity.setLectureID(rs.getString("lectureID"));
                entity.setCampus(rs.getString("campus"));
                entity.setLectureName(rs.getString("lectureName"));
                entity.setPassword(rs.getString("password"));
                entity.setUsername(rs.getString("username"));
                return entity;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LectureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Lecture get(Lecture entity) {
        try {
            String sql = "select * from Lecture";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String campus = rs.getString("campus");
                if (entity.getUsername().equals(username) && entity.getPassword().equals(password) && entity.getCampus().equals(campus)) {
                    entity.setLectureID(rs.getString("lectureID"));
                    entity.setLectureName(rs.getString("lectureName"));
                    return entity;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LectureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
