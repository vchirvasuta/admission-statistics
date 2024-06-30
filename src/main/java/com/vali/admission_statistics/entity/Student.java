package com.vali.admission_statistics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String studentId; //0

    private String schoolName; //1

    private double gradeRomanian; //2

    private double gradeMath; //5

    private double gradeMean; //12

    private int academicYear;

    public Student() {
    }

    public Student(String studentId, String schoolName, double gradeRomanian, double gradeMath, double gradeMean, int academicYear) {
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.gradeRomanian = gradeRomanian;
        this.gradeMath = gradeMath;
        this.gradeMean = gradeMean;
        this.academicYear = academicYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public double getGradeRomanian() {
        return gradeRomanian;
    }

    public void setGradeRomanian(double gradeRomanian) {
        this.gradeRomanian = gradeRomanian;
    }

    public double getGradeMath() {
        return gradeMath;
    }

    public void setGradeMath(double gradeMath) {
        this.gradeMath = gradeMath;
    }

    public double getGradeMean() {
        return gradeMean;
    }

    public void setGradeMean(double gradeMean) {
        this.gradeMean = gradeMean;
    }

    public long getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }
}
