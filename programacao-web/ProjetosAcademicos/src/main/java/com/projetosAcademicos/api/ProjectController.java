package com.projetosAcademicos.api;

import java.util.List;
import java.util.Optional;

import com.projetosAcademicos.domain.dto.ProjectDTO;
import com.projetosAcademicos.domain.models.Project;
import com.projetosAcademicos.domain.models.Student;
import com.projetosAcademicos.domain.services.ProjectService;
import com.projetosAcademicos.domain.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService service;

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<ProjectDTO>> get() {
		List<ProjectDTO> projects = service.getProjects();

		return ResponseEntity.ok(projects);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Project> get(@PathVariable("id") Long id) {
		Optional<Project> project = service.getProjectById(id);

		return project.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public String create(@RequestBody Project project) {
		Project c = service.create(project);
		return "Projeto salvo com sucesso: " + c.getId();
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, @RequestBody Project project) {
		Project c = service.update(project, id);
		return "Projeto atualizado com sucesso: " + c.getId();
	}

	@PutMapping("/{id}/student/{studentId}")
	public String addStudentToProject(@PathVariable("id") Long id, @PathVariable("studentId") Long studentId) {
		Optional<Student> studentOptional = studentService.getStudentById(studentId);

		Student c = service.addStudentToProject(studentOptional, id);
		return "Aluno adicionado ao projeto com sucesso: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	public String remove(@PathVariable("id") Long id) {
		service.remove(id);
		return "Projeto removido com sucesso. ";
	}
}
