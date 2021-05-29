package com.projetosAcademicos.domain.dto;

import com.projetosAcademicos.domain.models.Student;
import com.projetosAcademicos.domain.models.Address;
import com.projetosAcademicos.domain.models.Project;

import lombok.Data;

@Data
public class StudentDTO {
	
	private Long id;
	private String name;
	private String registration;
	private String cpf;
	private String course;
	private Address address;
	private Project project;
	
	public StudentDTO(Student c) {
		this.id = c.getId();
		this.name = c.getName();
		this.registration = c.getRegistration();
		this.cpf = c.getCpf();
		this.course = c.getCourse();
		this.address = c.getAddress();
		this.project = c.getProject();
	}
}
