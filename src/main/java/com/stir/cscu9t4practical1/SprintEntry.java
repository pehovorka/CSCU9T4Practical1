package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {
    private int repetitions, recovery;
    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int repetitions, int recovery) {
        super(n, d, m, y, h, min, s, dist);
        this.repetitions = repetitions;
        this.recovery = recovery;
    } // Constructor

    public String getEntry () {
        return buildEntryString("ran");
    } //getEntry

    public int getRepetitions() {
        return repetitions;
    }

    public int getRecovery() {
        return recovery;
    }
}
