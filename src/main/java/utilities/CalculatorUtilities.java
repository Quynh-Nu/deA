package utilities;

import entities.Student;
import java.util.List;

public class CalculatorUtilities {

    private static double roundToNearestMark(Student student){
        return Math.round(calculateFinalMark(student) * 2)/ 2.0;
    }

    private static double calculateFinalMark(Student student){
        return (student.getBonus() * 0.1
                + student.getReportMark() * 0.3
                + student.getAppMark() * 0.15
                + student.getTheoryMark() * 0.45);
    }

    public static void calculateFinalMarkForStudents(List<Student> students){
        for (int i = 0; i < students.size(); i++) {
            double finalMark = roundToNearestMark(students.get(i));
            students.get(i).setFinalMark(finalMark);
        }
    }
}
