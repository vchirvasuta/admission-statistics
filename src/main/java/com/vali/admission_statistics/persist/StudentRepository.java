package com.vali.admission_statistics.persist;

import com.vali.admission_statistics.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
