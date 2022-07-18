/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class TimeSlot {
    private String slotID;
    private String startSlot;
    private String endSlot;

    public TimeSlot() {
    }

    public TimeSlot(String slotID, String startSlot, String endSlot) {
        this.slotID = slotID;
        this.startSlot = startSlot;
        this.endSlot = endSlot;
    }

    public String getSlotID() {
        return slotID;
    }

    public String getStartSlot() {
        return startSlot;
    }

    public String getEndSlot() {
        return endSlot;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public void setStartSlot(String startSlot) {
        this.startSlot = startSlot;
    }

    public void setEndSlot(String endSlot) {
        this.endSlot = endSlot;
    }
    
}
