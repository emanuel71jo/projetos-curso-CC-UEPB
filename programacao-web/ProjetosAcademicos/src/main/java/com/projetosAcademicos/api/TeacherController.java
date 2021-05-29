package com.projetosAcademicos.api;

import java.util.List;
import java.util.Optional;

import com.projetosAcademicos.domain.dto.TeacherDTO;
import com.projetosAcademicos.domain.models.Teacher;
import com.projetosAcademicos.domain.services.TeacherService;

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
@RequestMapping("/api/v1/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@GetMapping
	public ResponseEntity<List<TeacherDTO>> get() {
		return ResponseEntity.ok(service.getTeachers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> get(@PathVariable("id") Long id) {
		Optional<Teacher> teacher = service.getTeacherById(id);
		return teacher.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/registration/{registration}")
	public ResponseEntity<List<TeacherDTO>> getCarrosByTipo(@PathVariable("registration") String registration) {
		List<TeacherDTO> allTeachers = service.getTeacherByRegistration(registration);
		return allTeachers.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(allTeachers);
	}
	
	@PostMapping
	public String create(@RequestBody Teacher teacher) {
		Teacher c = service.create(teacher);
		return "Professor salvo com sucesso: " + c.getId();
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, @RequestBody Teacher teacher) {
		Teacher c = service.update(teacher, id);
		return "Professor atualizado com sucesso: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	public String remove(@PathVariable("id") Long id) {
		service.remove(id);
		return "Professor removido com sucesso. ";
	}
	
}
