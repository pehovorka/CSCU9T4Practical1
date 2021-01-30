// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.util.List;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private String tempos[] = {"slow", "moderate", "fast"};

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField terr = new JTextField(6);
    private JTextField place = new JTextField(6);
    private JTextField repetitions = new JTextField(2);
    private JTextField recovery = new JTextField(2);
    private JComboBox tempo = new JComboBox(tempos);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labterr = new JLabel("Terrain:");
    private JLabel labtempo = new JLabel("Tempo:");
    private JLabel labplace = new JLabel("Place:");
    private JLabel labrepetitions = new JLabel("Repetitions:");
    private JLabel labrecovery = new JLabel("Recovery minutes between:");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JRadioButton rbInput = new JRadioButton("Input data");
    private JRadioButton rbView = new JRadioButton("View data");


    private String entryTypes[] = {"Cycling", "Swimming", "Running"};
    private JComboBox entryTypesSelect = new JComboBox(entryTypes);

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbInput);
        bg.add(rbView);
        add(rbInput);
        rbInput.addActionListener(this);
        add(rbView);
        rbView.addActionListener(this);
        rbInput.setSelected(true);
        add(labn);
        add(name);
        name.setEditable(true);
        add(entryTypesSelect);
        entryTypesSelect.addActionListener(this);
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

        // Running
        add(labrepetitions);
        add(repetitions);
        repetitions.setEditable(true);
        add(labrecovery);
        add(recovery);
        recovery.setEditable(true);

        // Cycling
        add(labterr);
        add(terr);
        terr.setEditable(true);
        add(labtempo);
        add(tempo);

        // Swimming
        add(labplace);
        add(place);
        place.setEditable(true);


        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        lookUpByDate.setVisible(false);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        findAllByDate.setVisible(false);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 300);
        setVisible(true);
        blankDisplay();
        setElementsVisibility();


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
            message = addEntry(entryTypesSelect.getSelectedItem().toString());
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = findAllByDate();
        }
        // Input data
        if (event.getSource() == rbInput) {
            // Visible
            labn.setVisible(true);
            name.setVisible(true);
            entryTypesSelect.setVisible(true);
            labh.setVisible(true);
            hours.setVisible(true);
            labmm.setVisible(true);
            mins.setVisible(true);
            labs.setVisible(true);
            secs.setVisible(true);
            labdist.setVisible(true);
            dist.setVisible(true);
            addR.setVisible(true);
            // Hidden
            lookUpByDate.setVisible(false);
            findAllByDate.setVisible(false);


            setElementsVisibility();
        }
        // View data
        if (event.getSource() == rbView) {
            // Visible
            lookUpByDate.setVisible(true);
            findAllByDate.setVisible(true);
            // Hidden
            labn.setVisible(false);
            name.setVisible(false);
            entryTypesSelect.setVisible(false);
            labh.setVisible(false);
            hours.setVisible(false);
            labmm.setVisible(false);
            mins.setVisible(false);
            labs.setVisible(false);
            secs.setVisible(false);
            labdist.setVisible(false);
            dist.setVisible(false);
            addR.setVisible(false);


            setElementsVisibility();
        }

        if (event.getSource() == entryTypesSelect) {
            setElementsVisibility();
        }

        outputArea.setText(message);
    } // actionPerformed

    private void setElementsVisibility() {
        if (rbInput.isSelected()) {
            switch (entryTypesSelect.getSelectedItem().toString()) {
                case "Cycling":
                    // Visible
                    labterr.setVisible(true);
                    terr.setVisible(true);
                    labtempo.setVisible(true);
                    tempo.setVisible(true);
                    // Hidden
                    labplace.setVisible(false);
                    place.setVisible(false);
                    labrepetitions.setVisible(false);
                    repetitions.setVisible(false);
                    labrecovery.setVisible(false);
                    recovery.setVisible(false);
                    break;
                case "Swimming":
                    // Hidden
                    labterr.setVisible(false);
                    terr.setVisible(false);
                    labtempo.setVisible(false);
                    tempo.setVisible(false);
                    labrepetitions.setVisible(false);
                    repetitions.setVisible(false);
                    labrecovery.setVisible(false);
                    recovery.setVisible(false);
                    // Visible
                    labplace.setVisible(true);
                    place.setVisible(true);
                    break;
                case "Running":
                    // Hidden
                    labterr.setVisible(false);
                    terr.setVisible(false);
                    labtempo.setVisible(false);
                    tempo.setVisible(false);
                    labplace.setVisible(false);
                    place.setVisible(false);
                    // Visible
                    labrepetitions.setVisible(true);
                    repetitions.setVisible(true);
                    labrecovery.setVisible(true);
                    recovery.setVisible(true);
                    break;
                default:
                    // Hidden
                    labterr.setVisible(false);
                    terr.setVisible(false);
                    labtempo.setVisible(false);
                    tempo.setVisible(false);
                    labplace.setVisible(false);
                    place.setVisible(false);
                    labrepetitions.setVisible(false);
                    repetitions.setVisible(false);
                    labrecovery.setVisible(false);
                    recovery.setVisible(false);
            }
        } else {
            labterr.setVisible(false);
            terr.setVisible(false);
            labtempo.setVisible(false);
            tempo.setVisible(false);
            labplace.setVisible(false);
            place.setVisible(false);
            labrepetitions.setVisible(false);
            repetitions.setVisible(false);
            labrecovery.setVisible(false);
            recovery.setVisible(false);
        }

    }

    public String addEntry(String what) {
        List errors = validateNewEntry(what);

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

            switch (what) {
                case "Cycling":
                    Entry cycleE = new CycleEntry(n, d, m, y, h, mm, s, km, terr.getText(), tempo.getSelectedItem().toString());
                    myAthletes.addEntry(cycleE);
                    break;
                case "Swimming":
                    Entry swimE = new SwimEntry(n, d, m, y, h, mm, s, km, place.getText());
                    myAthletes.addEntry(swimE);
                    break;
                case "Running":
                    int rep = Integer.parseInt(repetitions.getText());
                    int rec = Integer.parseInt(recovery.getText());
                    Entry sprintE = new SprintEntry(n, d, m, y, h, mm, s, km, rep, rec);
                    myAthletes.addEntry(sprintE);
                    break;
                default:
                    Entry e = new Entry(n, d, m, y, h, mm, s, km);
                    myAthletes.addEntry(e);
            }
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

    public List validateNewEntry(String what) {
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

        // Specific checks depending on entry type
        switch (what) {
            case "Cycling":
                if (terr.getText().trim().equals("")) errors.add("You must specify terrain!");
                break;
            case "Swimming":
                if (place.getText().trim().equals("")) errors.add("You must specify place!");
                break;
            case "Running":
                try {
                    Integer.parseInt(repetitions.getText());
                    Integer.parseInt(recovery.getText());
                } catch (NumberFormatException ex) {
                    errors.add("Repetitions and Recovery Minutes must be integers!");
                }
                break;
            default:

        }


        // Prevent duplicate entries
        if (errors.size() == 0) {
            int d = Integer.parseInt(day.getText());
            int m = Integer.parseInt(month.getText());
            int y = Integer.parseInt(year.getText());
            String n = name.getText().trim();
            if (myAthletes.entryAlreadyExists(d, m, y, n)) {
                errors.add("This entry already exists! Change name or date.");
            }
            ;
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
        repetitions.setText("");
        recovery.setText("");
        terr.setText("");
        place.setText("");

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

