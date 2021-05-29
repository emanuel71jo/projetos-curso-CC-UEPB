package com.projetosAcademicos.domain.repositories;

import java.util.List;

import com.projetosAcademicos.domain.models.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByRegistration(String registration);
}
