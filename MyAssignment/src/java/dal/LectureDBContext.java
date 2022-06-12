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
        LectureDBContext db = new LectureDBContext();
        ArrayList<Lecture> lectures = db.list();
        for (Lecture lecture : lectures) {
            System.out.println(lecture.getLectureName());
        }

        Lecture test = new Lecture();
        test.setCampus("FUHL");
        test.setUsername("a123");
        test.setPassword("123");
        System.out.println(db.get(test));
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
