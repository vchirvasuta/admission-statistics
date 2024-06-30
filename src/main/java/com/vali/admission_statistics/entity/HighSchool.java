package com.vali.admission_statistics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class HighSchool {

    //Liceu	Specializare	Numar Clase	Numar locuri	Nr Locuri romi	Media

    @Id
    @GeneratedValue
    private long id;

    private String highSchoolName;

    private String major;

    private double noClasses;

    private int noPlacesTotal;

    private int noPlacesRoma;

    private double lastMean;

    private int academicYear;

    public HighSchool(String highSchoolName, String major, double noClasses, int noPlacesTotal, int noPlacesRoma, double lastMean, int academicYear) {
        this.highSchoolName = highSchoolName;
        this.major = major;
        this.noClasses = noClasses;
        this.noPlacesTotal = noPlacesTotal;
        this.noPlacesRoma = noPlacesRoma;
        this.lastMean = lastMean;
        this.academicYear = academicYear;
    }

    @Override
    public String toString() {
        return "HighSchool{" +
                "id=" + id +
                ", highSchoolName='" + highSchoolName + '\'' +
                ", major='" + major + '\'' +
                ", noClasses=" + noClasses +
                ", noPlacesTotal=" + noPlacesTotal +
                ", noPlacesRoma=" + noPlacesRoma +
                ", lastMean=" + lastMean +
                ", academicYear=" + academicYear +
                '}';
    }
}

