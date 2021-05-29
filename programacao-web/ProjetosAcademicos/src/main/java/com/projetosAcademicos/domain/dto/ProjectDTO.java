package com.projetosAcademicos.domain.dto;

import java.util.List;

import com.projetosAcademicos.domain.models.Project;
import com.projetosAcademicos.domain.models.Student;
import com.projetosAcademicos.domain.models.Teacher;

import lombok.Data;

@Data
public class ProjectDTO {
	
	private Long id;
	private String title;
	private String area;	
	private String resume;	
	private String firstKeyWord;	
	private String secondKeyWord;	
	private String thirdKeyWord;	
	private String documentURL;
	private Teacher teacher;
	private List<Student> students;

	public ProjectDTO(Project c) {
		this.id = c.getId();
		this.title = c.getTitle();
		this.area = c.getArea();
		this.resume = c.getResume();
		this.firstKeyWord = c.getFirstKeyWord();
		this.secondKeyWord = c.getSecondKeyWord();
		this.thirdKeyWord = c.getThirdKeyWord();
		this.documentURL = c.getDocumentURL();
		this.teacher = c.getTeacher();
		this.students = c.getStudents();
	}
}
