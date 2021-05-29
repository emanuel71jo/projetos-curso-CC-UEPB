package com.projetosAcademicos.domain.dto;

import com.projetosAcademicos.domain.models.Address;
import com.projetosAcademicos.domain.models.Teacher;

import lombok.Data;

@Data
public class TeacherDTO {
	
	private Long id;
	private String name;
	private String registration;
	private String course;
	private Address address;
	
	public TeacherDTO(Teacher c) {
		this.id = c.getId();
		this.name = c.getName();
		this.registration = c.getRegistration();
		this.course = c.getCourse();
		this.address = c.getAddress();
	}
}
