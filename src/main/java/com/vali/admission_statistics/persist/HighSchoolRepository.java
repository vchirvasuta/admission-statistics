package com.vali.admission_statistics.persist;

import com.vali.admission_statistics.entity.HighSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighSchoolRepository extends JpaRepository<HighSchool, Long> {
}
