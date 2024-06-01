package main.java;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<Shift> shifts;

    public Schedule() {
        shifts = new ArrayList<>();
    }

    public void addShift(Shift shift) {
        shifts.add(shift);
    }

    public void removeShift(Shift shift) {
        shifts.remove(shift);
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void displaySchedule() {
        for (Shift shift : shifts) {
            System.out.println(shift);
        }
    }
}
