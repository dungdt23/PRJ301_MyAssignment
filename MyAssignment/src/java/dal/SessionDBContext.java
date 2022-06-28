/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Lecture;
import model.Room;
import model.Session;
import model.Subject;
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class SessionDBContext extends DBContext<Session> {
    
    public static void main(String[] args) {
        SessionDBContext dbSession = new SessionDBContext();
        Lecture lecture = new Lecture();
        lecture.setLectureID("1");
        
        ArrayList<Session> list = dbSession.list(lecture);
        DateDBContext dbDate = new DateDBContext();
        Date date = new Date();
        ArrayList<Date> week = dbDate.getWeek(date);

//        for (Date date1 : week) {
//            System.out.println(date1);
//        }
        TimeSlotDBContext dbSlot = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = dbSlot.list();

//        for (TimeSlot slot : slots) {
//            System.out.println(slot.getSlotID());
//        }
//        for (Session session1 : list) {
//            System.out.println(session1.getSessionID());
//            }
        for (TimeSlot slot1 : slots) {
            //System.out.println(slot1.getSlotID());
            for (Date date1 : week) {
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String strdate1 = format1.format(date1);
                //System.out.println(date1);
                for (Session session1 : list) {
                    //System.out.println(session1.getSessionID() + session1.getTimeslot().getSlotID() + session1.getDate().toString() + " ");
                    if (session1.getTimeslot().getSlotID().equals(slot1.getSlotID()) && session1.getDate().toString().equals(strdate1)) {
                        System.out.println(session1.getSessionID() + session1.getTimeslot().getSlotID() + session1.getDate() + " ");
                        System.out.println("123");
                    }
                }
            }
            System.out.println("end");
        }
        
    }
    
    public ArrayList<Session> list(Lecture lecture) {
        ArrayList<Session> sessions = new ArrayList<>();
        String lectureID = lecture.getLectureID();
        try {
            String sql = "select s.sessionID,a.groupID,a.subjectID,s.roomID,s.date,s.slotID from Session s,\n"
                    + "(select l.lectureID,l.lectureName,g.groupID ,g.subjectID\n"
                    + "from Lecture l inner join [Group] g \n"
                    + "on l.lectureID=g.lectureID where l.lectureID=?) a \n"
                    + "where s.groupID=a.groupID";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lectureID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                session.setSessionID(rs.getString("sessionID"));
                Group group = new Group();
                group.setGroupID(rs.getString("groupID"));
                Room room = new Room();
                room.setRoomID(rs.getString("roomID"));
                TimeSlot timeslot = new TimeSlot();
                timeslot.setSlotID(rs.getString("slotID"));
                session.setGroup(group);
                session.setRoom(room);
                session.setTimeslot(timeslot);
                session.setDate(rs.getDate("date"));
                Subject subject = new Subject();
                subject.setSubjectID(rs.getString("subjectID"));
                group.setSubject(subject);
                sessions.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }
    
    @Override
    public ArrayList<Session> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Session get(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void insert(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void update(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void delete(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
