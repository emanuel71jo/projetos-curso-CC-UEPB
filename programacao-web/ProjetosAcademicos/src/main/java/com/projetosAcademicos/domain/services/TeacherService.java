package com.projetosAcademicos.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.projetosAcademicos.domain.dto.TeacherDTO;
import com.projetosAcademicos.domain.models.Teacher;
import com.projetosAcademicos.domain.repositories.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<TeacherDTO> getTeachers(){
		return teacherRepository.findAll().stream().map(TeacherDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Teacher> getTeacherById(Long id) {
		return teacherRepository.findById(id);
	}
	
	public List<TeacherDTO> getTeacherByRegistration(String registration) {
		return teacherRepository.findByRegistration(registration).stream().map(TeacherDTO::new).collect(Collectors.toList());
	}
	
	public Teacher create(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	public Teacher update(Teacher teacher, Long id) {
		
		Optional<Teacher> optional = getTeacherById(id);
		if (optional.isPresent()) {
			Teacher teacherBD = optional.get();

			teacherBD.setRegistration(teacher.getRegistration());
			teacherBD.setName(teacher.getName());
			teacherBD.setCourse(teacher.getCourse());
			teacherBD.setAddress(teacher.getAddress());

			teacherRepository.save(teacherBD);
			return teacherBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar o professor informado");
		}
	}
	
	public void remove(Long id) {
		Optional<Teacher> teacher = getTeacherById(id);
		if(teacher.isPresent()) {
			teacherRepository.deleteById(id);
		}
	}

}
