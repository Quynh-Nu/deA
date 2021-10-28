package utilities;

import entities.Student;
import java.util.List;

public class DashboardUtilities {

    private List<Student> students;

    public DashboardUtilities(List<Student> students){
        this.students = students;
    }

    private int getNumberOfStudents(){
        return students.size();
    }

    private int getFailedStudentsNumber(){
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getFinalMark() < 4.5d){
                count = count + 1;
            }
        }
        return count;
    }

    private int getPassedStudentsNumber(){
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getFinalMark() > 4.5d){
                count = count + 1;
            }
        }
        return count;
    }

    private int getAverageStudentsNumber(){
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getFinalMark() >= 5.0d && students.get(i).getFinalMark() < 6.5d){
                count = count + 1;
            }
        }
        return count;
    }

    private int getGreatStudentsNumber(){
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getFinalMark() >= 6.5d && students.get(i).getFinalMark() < 8.0d){
                count = count + 1;
            }
        }
        return count;
    }

    private int getExcellentStudentsNumber(){
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getFinalMark() >= 8.0d && students.get(i).getFinalMark() <= 10.0d){
                count = count + 1;
            }
        }
        return count;
    }

    private double percentageOfPassedStudents(){
        return (double) getPassedStudentsNumber()/getNumberOfStudents();
    }

    private double percentageOfFailedStudents(){
        return (double) getFailedStudentsNumber()/getNumberOfStudents();
    }
    private double percentageOfAverageStudents(){
        return (double) getAverageStudentsNumber()/getNumberOfStudents();
    }
    private double percentageOfGreatStudents(){
        return (double) getGreatStudentsNumber()/getNumberOfStudents();
    }
    private double percentageOfExcellentStudents(){
        return (double) getExcellentStudentsNumber()/getNumberOfStudents();
    }


    public void printDashBoard(){
        System.out.println("------------------Thong ke sinh vien------------------");
        System.out.println("So luong sinh vien " + getNumberOfStudents());
        System.out.println("------------------------------------------------------");
        System.out.println("So luong sinh vien dat: " + getPassedStudentsNumber()+ " chiem ty le " +
                (percentageOfPassedStudents()*100)+ "%");
        System.out.println("------------------------------------------------------");
        System.out.println("So luong sinh vien khong dat: " + getFailedStudentsNumber()+ " chiem ty le " +
                (percentageOfFailedStudents()*100) + "%");
        System.out.println("------------------------------------------------------");
        System.out.println("So luong sinh vien gioi: " + getExcellentStudentsNumber()+ " chiem ty le " +
                (percentageOfExcellentStudents()*100) + "%");
        System.out.println("------------------------------------------------------");
        System.out.println("So luong sinh vien kha: " + getGreatStudentsNumber()+ " chiem ty le " +
                (percentageOfGreatStudents()*100) + "%");
        System.out.println("------------------------------------------------------");
        System.out.println("So luong sinh vien trung binh: " + getAverageStudentsNumber()+ " chiem ty le " +
                (percentageOfAverageStudents() * 100) + "%");
        System.out.println("------------------------------------------------------");
    }
}
