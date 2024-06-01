package main.java;

import java.util.Date;

public class Shift {
    private Date shiftDate;
    private String shiftTime;
    private SecurityGuard guard;

    public Shift(Date shiftDate, String shiftTime, SecurityGuard guard) {
        this.shiftDate = shiftDate;
        this.shiftTime = shiftTime;
        this.guard = guard;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public SecurityGuard getGuard() {
        return guard;
    }

    @Override
    public String toString() {
        return "Shift Date: " + shiftDate + ", Shift Time: " + shiftTime + ", Guard: " + guard.getName();
    }
}
