package com.example.studentanalyzer;

import java.util.List;

public class StudentAnalyzer {

    /**
     * Analyzes scores and returns the count of students classified as Excellent.
     * @param scores list of scores from 0 to 10 (null scores will be ignored)
     * @return number of students who scored Excellent (>= 8.0)
     * - Ignores invalid scores (< 0 or > 10) and null
     * - Returns 0 if the list is empty or null
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Double score : scores) {
            if (score != null && score >= 0 && score <= 10) {
                if (score >= 8.0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Calculates the average of valid scores (0 to 10, ignoring nulls).
     * @param scores list of scores
     * @return average of valid scores, or 0 if none valid or list is empty/null
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int validCount = 0;

        for (Double score : scores) {
            if (score != null && score >= 0 && score <= 10) {
                sum += score;
                validCount++;
            }
        }

        if (validCount == 0) {
            return 0;
        }

        return sum / validCount;
    }

    /**
     * Main method for demo purposes only.
     * Not included in core logic testing.
     */
    public static void main(String[] args) {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = List.of(9.0, 8.5, 7.0, 11.0, -1.0);

        int excellentCount = analyzer.countExcellentStudents(scores);
        double average = analyzer.calculateValidAverage(scores);

        System.out.println("Number of excellent students: " + excellentCount);
        System.out.printf("Valid average score: %.2f\n", average);
    }
}
