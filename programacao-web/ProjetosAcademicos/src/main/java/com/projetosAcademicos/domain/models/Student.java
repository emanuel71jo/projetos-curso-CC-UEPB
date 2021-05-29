package com.projetosAcademicos.domain.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "registration")
	private String registration;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "course")
	private String course;
	
	@NotNull()
	@OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name = "fk_address_id", foreignKey = @ForeignKey(name = "fk_address_id"), referencedColumnName = "id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "fk_project_id")
	@JsonBackReference
	private Project project;

}
