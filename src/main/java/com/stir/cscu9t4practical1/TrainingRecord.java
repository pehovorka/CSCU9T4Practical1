// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor

    // add a record to the list
    public void addEntry(Entry e) {
        tr.add(e);
    } // addClass

    // look up the entry of a given day and month
    public String lookupEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result = current.getEntry();
            }
        }
        return result;
    } // lookupEntry

    // look up all entries of a given day and month
    public String findAllByDate(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";

        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result += current.getEntry();
            }
        }

        if (result.equals("")) {
            result = "No entries found";
        }
        return result;
    } // findAllByDate


    public String findByName(String name) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";

        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().toLowerCase().contains(name.trim().toLowerCase())) {
                result += current.getEntry();
            }
        }

        if (result.equals("")) {
            result = "No entries found";
        }
        return result;
    } // findByName

    public String removeEntry(String name, int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";

        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y && current.getName().equals(name)) {
                result = "This entry has been removed: " + current.getEntry();
                iter.remove();
            }
        }

        if (result.equals("")) {
            result = "No such entry!";
        }
        return result;
    } // removeEntry


    // Count the number of entries
    public int getNumberOfEntries() {
        return tr.size();
    }

    // Clear all entries
    public void clearAllEntries() {
        tr.clear();
    }

    // Check if entry with the same name exists on specified day
    public boolean entryAlreadyExists(int d, int m, int y, String n) {
        ListIterator<Entry> iter = tr.listIterator();

        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y && current.getName().equals(n)) {
                return true;
            }
        }
        return false;
    }

} // TrainingRecord