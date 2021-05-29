package com.projetosAcademicos.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosAcademicos.domain.dto.StudentDTO;
import com.projetosAcademicos.domain.models.Student;
import com.projetosAcademicos.domain.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<StudentDTO> getStudents(){
		return studentRepository.findAll().stream().map(StudentDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}
	
	public List<StudentDTO> getStudentByRegistration(String registration) {
		return studentRepository.findByRegistration(registration).stream().map(StudentDTO::new).collect(Collectors.toList());
	}
	
	public Student create(Student student) {
		return studentRepository.save(student);
	}
	
	public Student update(Student student, Long id) {
		
		Optional<Student> optional = getStudentById(id);
		if (optional.isPresent()) {
			Student studentBD = optional.get();

			studentBD.setRegistration(student.getRegistration());
			studentBD.setName(student.getName());
			studentBD.setCpf(student.getCpf());
			studentBD.setCourse(student.getCourse());
			studentBD.setAddress(student.getAddress());
			studentBD.setProject(student.getProject());

			studentRepository.save(studentBD);
			return studentBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar o aluno informado");
		}
	}
	
	public void remove(Long id) {
		Optional<Student> student = getStudentById(id);
		if(student.isPresent()) {
			studentRepository.deleteById(id);
		}
	}

}
