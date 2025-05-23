import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        // Tạo danh sách điểm để kiểm thử
        List<Double> scores = Arrays.asList(9.0, 7.5, 8.5, -1.0, 10.5, 6.0, 8.0, null);

        // Gọi phương thức đếm học sinh giỏi
        int excellentCount = analyzer.countExcellentStudents(scores);
        System.out.println("Số học sinh đạt loại Giỏi: " + excellentCount);

        // Gọi phương thức tính điểm trung bình hợp lệ
        double average = analyzer.calculateValidAverage(scores);
        System.out.println("Điểm trung bình hợp lệ: " + average);
    }
}
