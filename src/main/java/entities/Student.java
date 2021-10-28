package entities;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String email;
    private double bonus;
    private double reportMark;
    private double appMark;
    private double theoryMark;
    private double finalMark;

    public Student() {
    }

    public Student(int id, String name, String email, double bonus, double reportMark, double appMark, double theoryMark) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.reportMark = reportMark;
        this.appMark = appMark;
        this.theoryMark = theoryMark;
        this.finalMark = 0d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getReportMark() {
        return reportMark;
    }

    public void setReportMark(double reportMark) {
        this.reportMark = reportMark;
    }

    public double getAppMark() {
        return appMark;
    }

    public void setAppMark(double appMark) {
        this.appMark = appMark;
    }

    public double getTheoryMark() {
        return theoryMark;
    }

    public void setTheoryMark(double theoryMark) {
        this.theoryMark = theoryMark;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }

    @Override
    public String toString() {
        return this.id +
                "," + this.name +
                "," + this.email +
                "," + this.bonus +
                "," + this.reportMark +
                "," + this.appMark +
                "," + this.theoryMark +
                "," + this.finalMark + '\n';
    }
}
