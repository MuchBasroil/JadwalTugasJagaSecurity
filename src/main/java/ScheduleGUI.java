package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleGUI {
    private ScheduleManagementSystem scheduleManagementSystem;

    private Schedule schedule;

    public ScheduleGUI() {
        scheduleManagementSystem = new ScheduleManagementSystem();
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("Security Guard Scheduling System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 50, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 50, 165, 25);
        panel.add(emailText);

        JLabel guardIdLabel = new JLabel("Guard ID:");
        guardIdLabel.setBounds(10, 80, 80, 25);
        panel.add(guardIdLabel);

        JTextField guardIdText = new JTextField(20);
        guardIdText.setBounds(100, 80, 165, 25);
        panel.add(guardIdText);

        JLabel dateLabel = new JLabel("Date (yyyy-MM-dd):");
        dateLabel.setBounds(10, 110, 120, 25);
        panel.add(dateLabel);

        JTextField dateText = new JTextField(20);
        dateText.setBounds(130, 110, 135, 25);
        panel.add(dateText);

        JLabel timeLabel = new JLabel("Shift Time:");
        timeLabel.setBounds(10, 140, 80, 25);
        panel.add(timeLabel);

        String[] shiftTimes = {"Morning", "Afternoon", "Night"};
        JComboBox<String> timeCombo = new JComboBox<>(shiftTimes);
        timeCombo.setBounds(100, 140, 165, 25);
        panel.add(timeCombo);

        JButton addButton = new JButton("Add Shift");
        addButton.setBounds(10, 180, 120, 25);
        panel.add(addButton);

        JButton displayButton = new JButton("Display Schedule");
        displayButton.setBounds(150, 180, 160, 25);
        panel.add(displayButton);

        JTextArea scheduleTextArea = new JTextArea();
        scheduleTextArea.setBounds(10, 220, 450, 130);
        panel.add(scheduleTextArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String email = emailText.getText();
                String guardId = guardIdText.getText();
                String dateStr = dateText.getText();
                String shiftTime = (String) timeCombo.getSelectedItem();

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date shiftDate = sdf.parse(dateStr);

                    SecurityGuard guard = new SecurityGuard(name, email, guardId);
                    scheduleManagementSystem.addShiftToSchedule(shiftDate, shiftTime, guard);
                    JOptionPane.showMessageDialog(panel, "Shift added successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid date format.");
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleTextArea.setText("");
                for (Shift shift : schedule.getShifts()) {
                    scheduleTextArea.append(shift.toString() + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScheduleGUI();
            }
        });
    }
}
