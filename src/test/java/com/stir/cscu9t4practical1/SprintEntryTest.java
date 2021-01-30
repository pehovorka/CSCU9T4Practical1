/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author saemundur
 */
public class SprintEntryTest {
    
    public SprintEntryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getName method, of class SprintEntry.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        String expResult = "Alice";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class SprintEntry.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class SprintEntry.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        int expResult = 2;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class SprintEntry.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        int expResult = 2003;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class SprintEntry.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        int expResult = 0;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMin method, of class SprintEntry.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        int expResult = 16;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSec method, of class SprintEntry.
     */
    @Test
    public void testGetSec() {
        System.out.println("getSec");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        int expResult = 7;
        int result = instance.getSec();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class SprintEntry.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        float expResult = 0.3F;
        float result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getRepetitions method of class SprintEntry
     */
    @Test
    public void testGetRepetitions() {
        System.out.println("getRepetitions");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        int expResult = 4;
        int result = instance.getRepetitions();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getRecovery method of class SprintEntry
     */
    @Test
    public void testGetRecovery() {
        System.out.println("getRepetitions");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        int expResult = 2;
        int result = instance.getRecovery();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntry method, of class SprintEntry.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        Entry instance1 = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 4, 2);
        String expResult1 = "Alice sprinted 4x300m in 0:16:7 with 2 minutes recovery on 1/2/2003\n";
        String result1 = instance1.getEntry();

        Entry instance2 = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 3F, 1, 2);
        String expResult2 = "Alice ran 3km in 0:16:7 with 2 minutes recovery on 1/2/2003\n";
        String result2 = instance2.getEntry();

        Entry instance3 = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 0.3F, 1, 2);
        String expResult3 = "Alice ran 300m in 0:16:7 with 2 minutes recovery on 1/2/2003\n";
        String result3 = instance3.getEntry();

        Entry instance4 = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 3F, 5, 2);
        String expResult4 = "Alice sprinted 5x3km in 0:16:7 with 2 minutes recovery on 1/2/2003\n";
        String result4 = instance4.getEntry();

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }
    
}