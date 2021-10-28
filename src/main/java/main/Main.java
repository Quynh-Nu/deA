package main;

import entities.Student;
import utilities.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileUtlities fileUtilities = new FileUtlities();
        List<Student> students = fileUtilities.readDataFromCSV("data.csv");

        CalculatorUtilities.calculateFinalMarkForStudents(students);
        System.out.println("Danh sach sinh vien khi chua sap xep: " + '\n');
        System.out.println(students);

        SortUtilities.sortStudentsByTheoryMark(students);
        System.out.println("Danh sach sinh vien co diem ly thuyet xep tu cao xuong thap: " + '\n');
        System.out.println(students);

        SortUtilities.sortStudentsByFinalMark(students);
        System.out.println("Danh sach sinh vien co diem tong ket xep tu cao xuong thap: " + '\n');
        System.out.println(students);

        fileUtilities.writeDataToFile(students, "output.csv");

        DashboardUtilities dashboardUtilities = new DashboardUtilities(students);
        dashboardUtilities.printDashBoard();

        System.out.println("Danh sach sinh vien co email Outlook hoac Gmail: " + '\n');
        List<Student> matchedStudents = RegExUtilities.getStudentsWithOutlookOrGmail(students);
        fileUtilities.writeDataToFile(matchedStudents, "outlook.bin");

        fileUtilities.printDataToConsole("outlook.bin");

    }
}
