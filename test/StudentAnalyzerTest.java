import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    StudentAnalyzer analyzer = new StudentAnalyzer();

    // ✅ Trường hợp bình thường - nhiều điểm hợp lệ và không hợp lệ
    @Test
    public void testCountExcellentStudents_MixedScores() {
        List<Double> scores = Arrays.asList(8.5, 7.0, -1.0, 9.0, 11.0);
        int result = analyzer.countExcellentStudents(scores);
        assertEquals(2, result);  // 8.5 và 9.0 là học sinh giỏi
    }

    @Test
    public void testCalculateValidAverage_MixedScores() {
        List<Double> scores = Arrays.asList(8.5, 7.0, -1.0, 9.0, 11.0);
        double result = analyzer.calculateValidAverage(scores);
        double expected = (8.5 + 7.0 + 9.0) / 3;
        assertEquals(expected, result, 0.001);
    }

    // ✅ Trường hợp bình thường - tất cả hợp lệ
    @Test
    public void testAllValidScores() {
        List<Double> scores = Arrays.asList(8.0, 9.0, 7.5);
        assertEquals(2, analyzer.countExcellentStudents(scores));
        assertEquals((8.0 + 9.0 + 7.5) / 3, analyzer.calculateValidAverage(scores), 0.001);
    }

    // ✅ Trường hợp biên - danh sách trống
    @Test
    public void testEmptyList() {
        List<Double> scores = Collections.emptyList();
        assertEquals(0, analyzer.countExcellentStudents(scores));
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    // ✅ Trường hợp biên - chỉ có 0 và 10
    @Test
    public void testOnlyZeroAndTen() {
        List<Double> scores = Arrays.asList(0.0, 10.0, 0.0, 10.0);
        assertEquals(2, analyzer.countExcellentStudents(scores)); // hai điểm 10
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    // ✅ Trường hợp ngoại lệ - toàn điểm không hợp lệ
    @Test
    public void testInvalidScoresOnly() {
        List<Double> scores = Arrays.asList(-5.0, 11.0, -2.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }
}
