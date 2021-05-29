package com.projetosAcademicos.domain.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "resume")
	private String resume;
	
	@Column(name = "firstKeyWord")
	private String firstKeyWord;
	
	@Column(name = "secondKeyWord")
	private String secondKeyWord;
	
	@Column(name = "thirdKeyWord")
	private String thirdKeyWord;

	@Column(name = "documentURL")
	private String documentURL;
	
	@NotNull()
	@OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name = "fk_teacher_id", foreignKey = @ForeignKey(name = "fk_teacher_id"), referencedColumnName = "id")
	private Teacher teacher;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private List<Student> students;
	
}
