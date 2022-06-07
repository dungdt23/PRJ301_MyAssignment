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
    private int startSlot;
    private int endSlot;

    public TimeSlot() {
    }

    public TimeSlot(String slotID, int startSlot, int endSlot) {
        this.slotID = slotID;
        this.startSlot = startSlot;
        this.endSlot = endSlot;
    }

    public String getSlotID() {
        return slotID;
    }

    public int getStartSlot() {
        return startSlot;
    }

    public int getEndSlot() {
        return endSlot;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public void setStartSlot(int startSlot) {
        this.startSlot = startSlot;
    }

    public void setEndSlot(int endSlot) {
        this.endSlot = endSlot;
    }
    
}
