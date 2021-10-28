package utilities;

import entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RegExUtilities {

    private static Pattern pattern = Pattern.compile("([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@(gmail|outlook)+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))");

    public static List<Student> getStudentsWithOutlookOrGmail(List<Student> students){
        List<Student> filteredStudents = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            String email = students.get(i).getEmail();
            if(pattern.matcher(email).matches()){
                filteredStudents.add(students.get(i));
            }
        }
        return filteredStudents;
    }

}
