package com.dennisvonbargen.commons.csv.test;

import com.dennisvonbargen.commons.csv.CSVTool;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVToolTest {

    private class TestPerson {
        String firstName;
        String surName;
        int age;
        char favoriteLetter;
        double heightMeter;
        boolean likesPasta;

        TestPerson(String firstName, String surName, int age, char favoriteLetter, double heightMeter,
                          boolean likesPasta) {
            this.firstName = firstName;
            this.surName = surName;
            this.age = age;
            this.favoriteLetter = favoriteLetter;
            this.heightMeter = heightMeter;
            this.likesPasta = likesPasta;
        }
    }

    private List<TestPerson> people;
    private String peopleString;

    @Before
    public void setUp() {
        people = new ArrayList<TestPerson>();
        people.add(new TestPerson("Dennis", "von Bargen", 24, 'D', 1.75, true));
        people.add(new TestPerson("John", "Doe", 41, 'K', 1.81, false));
        people.add(new TestPerson("Olivia", "Svensson", 22, 'W', 1.67, true));
        people.add(new TestPerson("Allan", "Jönsson", 64, 'P', 1.77, false));

        peopleString = "\"Dennis\",\"von Bargen\",24,D,1.75,true\n"
                + "\"John\",\"Doe\",41,K,1.81,false\n"
                + "\"Olivia\",\"Svensson\",22,W,1.67,true\n"
                + "\"Allan\",\"Jönsson\",64,P,1.77,false\n";
    }

    @Test
    public void testCSV() {
        StringBuilder sb = new StringBuilder();
        for (TestPerson p : people) {
            sb.append(CSVTool.getLine(p.firstName,
                    p.surName,
                    p.age,
                    p.favoriteLetter,
                    p.heightMeter,
                    p.likesPasta));
        }
        assertEquals(peopleString, sb.toString());
    }
}
