package com.projetosAcademicos.domain.repositories;

import java.util.List;

import com.projetosAcademicos.domain.models.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	List<Teacher> findByRegistration(String registration);
}
