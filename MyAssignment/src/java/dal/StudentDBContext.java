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
import model.Room;
import model.Session;
import model.Student;
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class StudentDBContext extends DBContext<Student> {

    public static void main(String[] args) {
        Group group = new Group();
        group.setGroupID("G1");
        StudentDBContext dbStudent = new StudentDBContext();
        ArrayList<Student> students = dbStudent.list(group);
        for (Student student : students) {
            System.out.println(student.getStudentID());
        }
    }

    public ArrayList<Student> list(Session session) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select stu.studentID,stu.studentName,stu.gmail from Student stu inner join\n"
                    + "(select e.studentID from Session s inner join Enroll e on s.groupID=e.groupID\n"
                    + "where s.sessionID=? ) a on stu.studentID=a.studentID";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, session.getSessionID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setStudentName(rs.getString("studentName"));
                student.setGmail(rs.getString("gmail"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public ArrayList<Student> list(Group group) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select s.studentID,s.studentName \n"
                    + "from Student s, (select e.studentID from Enroll e where e.groupID=?) a\n"
                    + "where s.studentID=a.studentID";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, group.getGroupID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setStudentName(rs.getString("studentName"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student get(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
