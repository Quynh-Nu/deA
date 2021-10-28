package utilities;

import entities.Student;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtilities {

    public static void sortStudentsByTheoryMark(List<Student> students){
        Collections.sort(students, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getTheoryMark() > o2.getTheoryMark() ? -1 : (o1.getTheoryMark() < o2.getTheoryMark()) ? 1 : 0;
            }
        });
    }

    public static void sortStudentsByFinalMark(List<Student> students){
        Collections.sort(students, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFinalMark() > o2.getFinalMark() ? -1 : (o1.getFinalMark() < o2.getFinalMark()) ? 1 : 0;
            }
        });
    }
}
