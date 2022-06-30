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
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class TimeSlotDBContext extends DBContext<TimeSlot>{
    
    

    @Override
    public TimeSlot get(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TimeSlot> list() {
              ArrayList<TimeSlot> slots = new ArrayList<>();
        try {
            String sql = "select slotID,startSlot,endSlot from TimeSlot";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                TimeSlot slot = new TimeSlot();
                slot.setSlotID(rs.getString("slotID"));
                slot.setStartSlot(rs.getInt("startSlot"));
                slot.setEndSlot(rs.getInt("endSlot"));
                slots.add(slot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slots;   
    }
    public static void main(String[] args) {
        TimeSlotDBContext db = new TimeSlotDBContext();
        ArrayList<TimeSlot> test = db.list();
        for (TimeSlot timeSlot : test) {
            System.out.println(timeSlot.getSlotID());
        }
    }
    
}
