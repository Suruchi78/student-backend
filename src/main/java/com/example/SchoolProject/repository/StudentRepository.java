package com.example.SchoolProject.repository;

import com.example.SchoolProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface StudentRepository extends JpaRepository<Student, Long> {
}
