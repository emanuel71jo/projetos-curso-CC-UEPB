package com.projetosAcademicos.domain.repositories;

import com.projetosAcademicos.domain.models.Project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>{}
