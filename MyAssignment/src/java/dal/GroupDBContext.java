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
import model.Group;
import model.Lecture;
import model.Subject;

/**
 *
 * @author Admin
 */
public class GroupDBContext extends DBContext<Group> {

    @Override
    public ArrayList<Group> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Group> list(Lecture lecture) {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "select groupID \n"
                    + "from [Group] where lectureID = ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lecture.getLectureID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setGroupID(rs.getString("groupID"));
                groups.add(group);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }

    @Override
    public Group get(Group entity) {
        try {
            String sql = "select * from [Group] where groupID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getGroupID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureID(rs.getString("lectureID"));
                Subject subject = new Subject();
                subject.setSubjectID(rs.getString("subjectID"));
                entity.setLecture(lecture);
                entity.setSubject(subject);
                return entity;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LectureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Group entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
