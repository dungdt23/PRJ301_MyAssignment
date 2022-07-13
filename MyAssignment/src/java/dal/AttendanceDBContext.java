/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Group;
import model.Session;
import model.Student;

/**
 *
 * @author Admin
 */
public class AttendanceDBContext extends DBContext<Attendance> {

    public static void main(String[] args) {
        AttendanceDBContext db = new AttendanceDBContext();
        Group g = new Group();
        g.setGroupID("G1");
//        Attendance attendance = new Attendance();
//        Student student0 = new Student();
//        student0.setStudentID("1");
//        Session session0 = new Session();
//        session0.setSessionID("SE1");
//        boolean status = true;
//        attendance.setStudent(student0);
//        attendance.setSession(session0);
//        attendance.setAttendanceStatus(status);
//        db.insert(attendance);
        Student s = new Student();
        s.setStudentID("1");
        HashMap<Student, Integer> totalAbsent = db.totalAbsent(g);
        //System.out.println(totalAbsent.get(s));
        for (Student s0 : totalAbsent.keySet()) {
            System.out.println(s0.getStudentID());
        }

    }

    public ArrayList<Attendance> list(Group entity) {
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "select a.studentID,a.sessionID,a.attendanceStatus,m.groupID,m.[date] from Attendance a,\n"
                    + "(select s.groupID,s.sessionID,s.[date]\n"
                    + "from [Session] s inner join [Group] g \n"
                    + "on s.groupID=g.groupID ) m where a.sessionID=m.sessionID and m.groupID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getGroupID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();
                Student s = new Student();
                s.setStudentID(rs.getString("studentID"));
                Session se = new Session();
                se.setSessionID(rs.getString("sessionID"));
                attendance.setSession(se);
                attendance.setStudent(s);
                attendance.setAttendanceStatus(rs.getString("attendanceStatus").equals("1"));
                attendances.add(attendance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return attendances;
    }

    public HashMap<Student, Integer> totalAbsent(Group entity) {
        HashMap<Student, Integer> totalAbsent = new HashMap<>();
        StudentDBContext dbStudent = new StudentDBContext();
        try {
            String sql = "select a.studentID,count(a.attendanceStatus) as 'totalabsent' from Attendance a ,\n"
                    + "(select s.groupID,s.sessionID,s.[date]\n"
                    + "from [Session] s inner join [Group] g \n"
                    + "on s.groupID=g.groupID ) m where a.sessionID=m.sessionID and m.groupID=? and a.attendanceStatus=0\n"
                    + "group by a.studentID";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getGroupID());
            ResultSet rs = stm.executeQuery();
            ArrayList<Student> students = dbStudent.list(entity);

            while (rs.next()) {
                Student s = new Student();
                s.setStudentID(rs.getString("studentID"));
                Integer absents = rs.getInt("totalabsent");
                totalAbsent.put(s, absents);
            }

            for (Student s : students) {
                boolean check = false;
                for (Student key : totalAbsent.keySet()) {
                    if (s.getStudentID().equals(key.getStudentID())) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    totalAbsent.put(s, 0);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return totalAbsent;
    }

    public ArrayList<Attendance> list(Session entity) {
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "select a.attendanceID,a.studentID,a.attendanceStatus \n"
                    + "from Attendance a\n"
                    + "where a.sessionID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getSessionID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setAttendanceID(rs.getString("attendanceID"));
                a.setAttendanceStatus(rs.getBoolean("attendanceStatus"));
                Student s = new Student();
                s.setStudentID(rs.getString("studentID"));
                a.setStudent(s);
                attendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return attendances;
    }

    @Override
    public ArrayList<Attendance> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendance get(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attendance entity) {
        try {
            String sql = "insert into [dbo].[Attendance]\n"
                    + "           ([studentID]\n"
                    + "           ,[sessionID]\n"
                    + "           ,[attendanceStatus])\n"
                    + "     values\n"
                    + "           (?,\n"
                    + "           ?,\n"
                    + "           ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getStudent().getStudentID());
            stm.setString(2, entity.getSession().getSessionID());
            stm.setBoolean(3, entity.getAttendanceStatus());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Attendance> existedAttendances(Session entity) {
        boolean checkExist = false;
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "select attendanceID,studentID,attendanceStatus \n"
                    + "from Attendance \n"
                    + "where sessionID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getSessionID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                checkExist = true;
                Attendance a = new Attendance();
                a.setAttendanceID(rs.getString("attendanceID"));
                Student s = new Student();
                s.setStudentID(rs.getString("studentID"));
                a.setStudent(s);
                a.setAttendanceStatus(rs.getBoolean("attendanceStatus"));
                attendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!checkExist) {
            attendances=null;
        }
        return attendances;
    }

    @Override
    public void update(Attendance entity) {
        try {
            String sql = "UPDATE [dbo].[Attendance]\n"
                    + "   SET   "
                    + "         "
                    + "      [attendanceStatus] = ?     \n"
                    + " WHERE [Attendance].attendanceID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, entity.getAttendanceStatus());
            stm.setString(2, entity.getAttendanceID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
