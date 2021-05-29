package com.projetosAcademicos.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.projetosAcademicos.domain.dto.ProjectDTO;
import com.projetosAcademicos.domain.models.Project;
import com.projetosAcademicos.domain.models.Student;
import com.projetosAcademicos.domain.repositories.ProjectRepository;
import com.projetosAcademicos.domain.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	public List<ProjectDTO> getProjects(){
		return projectRepository.findAll().stream().map(ProjectDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Project> getProjectById(Long id) {
		return projectRepository.findById(id);
	}
	
	public Project create(Project project) {
		return projectRepository.save(project);
	}
	
	public Project update(Project project, Long id) {
		
		Optional<Project> optional = getProjectById(id);
		if (optional.isPresent()) {
			Project projectBD = optional.get();

			projectBD.setArea(project.getArea());
			projectBD.setDocumentURL(project.getDocumentURL());
			projectBD.setFirstKeyWord(project.getFirstKeyWord());
			projectBD.setSecondKeyWord(project.getSecondKeyWord());
			projectBD.setThirdKeyWord(project.getThirdKeyWord());
			projectBD.setResume(project.getResume());
			projectBD.setTeacher(project.getTeacher());
			projectBD.setTitle(project.getTitle());
			projectBD.setStudents(project.getStudents());

			projectRepository.save(projectBD);
			return projectBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar o projeto informado");
		}
	}

	public Student addStudentToProject(Optional<Student> student, Long id) {
		
		if (student.isPresent()) {
			Student studentBD = student.get();
			Project project = getProjectById(id).get();
			
			studentBD.setProject(project);

			studentRepository.save(studentBD);
			
			return studentBD;
		}
		else {
			throw new RuntimeException("Não foi possível adicionar um usuário ao projeto");
		}
	}
	
	public void remove(Long id) {
		Optional<Project> project = getProjectById(id);
		if(project.isPresent()) {
			projectRepository.deleteById(id);
		}
	}

}
