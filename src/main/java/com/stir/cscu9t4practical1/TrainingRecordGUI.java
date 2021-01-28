// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.util.List;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        Entry e1 = new Entry("Test 1", 1, 1, 1990, 1, 2, 3, 8);
        Entry e2 = new Entry("Test 2", 1, 1, 1990, 2, 3, 4, 9);
        Entry e3 = new Entry("Test 3", 2, 1, 1990, 0, 0, 4, 2);
        myAthletes.addEntry(e1);
        myAthletes.addEntry(e2);
        myAthletes.addEntry(e3);

        //fillDisplay(e1);

    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = findAllByDate();
        }
        outputArea.setText(message);
    } // actionPerformed

    public String addEntry(String what) {
        List errors = validateNewEntry();

        if (errors.size() == 0) {
            String message = "Record added\n";
            System.out.println("Adding " + what + " entry to the records");
            String n = name.getText().trim();
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            Entry e = new Entry(n, d, m, y, h, mm, s, km);
            myAthletes.addEntry(e);
            blankDisplay();
            return message;
        } else return convertListToString(errors);
    }


    public String lookupEntry() {
        List errors = validateLookup();

        if (errors.size() == 0) {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record ...");
            String message = myAthletes.lookupEntry(d, m, y);
            blankDisplay();
            return message;
        } else return convertListToString(errors);
    }

    public String findAllByDate() {
        List errors = validateLookup();

        if (errors.size() == 0) {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up records ...");
            String message = myAthletes.findAllByDate(d, m, y);
            blankDisplay();
            return message;
        } else return convertListToString(errors);
    }

    public List validateNewEntry() {
        List<String> errors = new ArrayList<String>();
        if (name.getText().trim().equals("")) {
            errors.add("Name cannot be empty!");
        }
        try {
            Integer.parseInt(day.getText());
            Integer.parseInt(month.getText());
            Integer.parseInt(year.getText());
            Integer.parseInt(hours.getText());
            Integer.parseInt(mins.getText());
            Integer.parseInt(secs.getText());
        } catch (NumberFormatException ex) {
            errors.add("Day, month, year, hours, mins and secs must be integers!");
        }
        try {
            Float.parseFloat(dist.getText());
        } catch (NumberFormatException ex) {
            errors.add("Distance must be a number!");
        }

        if (errors.size() == 0){
            // TODO: Prevent adding same entries.
        }
        return errors;
    }

    public List validateLookup() {
        List<String> errors = new ArrayList<String>();
        try {
            Integer.parseInt(day.getText());
            Integer.parseInt(month.getText());
            Integer.parseInt(year.getText());
        } catch (NumberFormatException ex) {
            errors.add("Day, month and year must be integers!");
        }
        return errors;
    }

    // Converts List to String. Each list item is on a new line.
    public String convertListToString(List<String> list) {
        String message = "";
        for (int i = 0; i < list.size(); i++) {
            message += list.get(i) + "\n";
        }
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay

    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

