package com.projetosAcademicos.api;

import java.util.List;
import java.util.Optional;

import com.projetosAcademicos.domain.dto.StudentDTO;
import com.projetosAcademicos.domain.models.Student;
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
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> get() {
		List<StudentDTO> students = service.getStudents();
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> get(@PathVariable("id") Long id) {
		Optional<Student> student = service.getStudentById(id);
		return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/registration/{registration}")
	public ResponseEntity<List<StudentDTO>> getCarrosByTipo(@PathVariable("registration") String registration) {
		List<StudentDTO> allStudents = service.getStudentByRegistration(registration);
		return allStudents.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(allStudents);
	}
	
	@PostMapping
	public String create(@RequestBody Student student) {
		Student c = service.create(student);
		return "Aluno salvo com sucesso: " + c.getId();
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, @RequestBody Student student) {
		Student c = service.update(student, id);
		return "Aluno atualizado com sucesso: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	public String remove(@PathVariable("id") Long id) {
		service.remove(id);
		return "Aluno removido com sucesso. ";
	}
	
}
