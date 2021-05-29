package com.projetosAcademicos.domain.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "registration")
	private String registration;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "course")
	private String course;
	
	@NotNull()
	@OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name = "fk_address_id", foreignKey = @ForeignKey(name = "fk_address_id"), referencedColumnName = "id")
	private Address address;
	
}
