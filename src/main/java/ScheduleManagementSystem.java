package main.java;

import java.util.Date;

public class ScheduleManagementSystem {
    private Schedule schedule;

    public ScheduleManagementSystem() {
        schedule = new Schedule();
    }

    public void addShiftToSchedule(Date shiftDate, String shiftTime, SecurityGuard guard) {
        Shift shift = new Shift(shiftDate, shiftTime, guard);
        schedule.addShift(shift);
        System.out.println("Shift added successfully.");
    }

    public void displaySchedule() {
        schedule.displaySchedule();
    }

    public static void main(String[] args) {
        ScheduleManagementSystem system = new ScheduleManagementSystem();

        SecurityGuard guard1 = new SecurityGuard("John Doe", "john@example.com", "G001");
        SecurityGuard guard2 = new SecurityGuard("Jane Smith", "jane@example.com", "G002");

        system.addShiftToSchedule(new Date(), "Morning", guard1);
        system.addShiftToSchedule(new Date(), "Afternoon", guard2);

        system.displaySchedule();
    }
}
