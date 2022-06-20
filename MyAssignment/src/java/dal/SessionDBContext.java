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
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class SessionDBContext extends DBContext<Session> {
    public static void main(String[] args) {
        SessionDBContext db = new SessionDBContext();
        Session session = db.demo();
        System.out.println(session.getGroup().getGroupID());
    }

    public ArrayList<Session> list(String lectureID, String slotID) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "select s.sessionID,s.groupID,s.roomID,s.slotID from \n"
                    + "(select e.lectureID,e.lectureName,g.groupID \n"
                    + "from Lecture  e inner join [Group] g \n"
                    + "on e.lectureID=g.lectureID\n"
                    + "where e.lectureID = ? ) as a, Session as s where a.groupID=s.groupID and s.slotID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lectureID);
            stm.setString(2, slotID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                session.setSessionID(rs.getString("sessionID"));
                Group group = new Group();
                group.setGroupID(rs.getString("groupID"));
                Room room = new Room();
                room.setRoomID("roomID");
                TimeSlot timeslot = new TimeSlot();
                timeslot.setSlotID("slotID");
                session.setGroup(group);
                session.setRoom(room);
                session.setTimeslot(timeslot);
                sessions.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    public Session demo() {
        Session session = new Session();
        try {
            String sql = "select s.sessionID,s.groupID,s.roomID,s.slotID from \n"
                    + "(select e.lectureID,e.lectureName,g.groupID \n"
                    + "from Lecture  e inner join [Group] g \n"
                    + "on e.lectureID=g.lectureID\n"
                    + "where e.lectureID = 1 ) as a, Session as s where a.groupID=s.groupID and s.slotID='slot1'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                session.setSessionID(rs.getString("sessionID"));
                Group group = new Group();
                group.setGroupID(rs.getString("groupID"));
                Room room = new Room();
                room.setRoomID(rs.getString("roomID"));
                TimeSlot timeslot = new TimeSlot();
                timeslot.setSlotID("slotID");
                session.setGroup(group);
                session.setRoom(room);
                session.setTimeslot(timeslot);
                return session;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
