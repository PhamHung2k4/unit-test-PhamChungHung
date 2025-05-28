package com.example.studentanalyzer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    @Test
    public void testMainMethod() {
        StudentAnalyzer.main(new String[]{});
    }

    @Test
    public void testCountExcellentStudents() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(2, analyzer.countExcellentStudents(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)));
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(8.0, 9.5, 10.0)));
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0, 5.0, 7.9)));
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(0.0, 10.0)));
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.1, null, 7.5)));

        // New test: list of only null values
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(null, null, null)));
    }

    @Test
    public void testCalculateValidAverage() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(8.17, analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)), 0.01);
        assertEquals(0, analyzer.calculateValidAverage(Collections.emptyList()));
        assertEquals(7.5, analyzer.calculateValidAverage(Arrays.asList(6.0, 7.5, 9.0)));
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(-1.0, 15.0, 11.0)));
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)));
        assertEquals(7.75, analyzer.calculateValidAverage(Arrays.asList(8.5, null, 7.0)));

        // New test: list of only null values
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(null, null, null)));
    }

    @Test
    public void testNullInput() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(null));
        assertEquals(0.0, analyzer.calculateValidAverage(null));
    }

}
