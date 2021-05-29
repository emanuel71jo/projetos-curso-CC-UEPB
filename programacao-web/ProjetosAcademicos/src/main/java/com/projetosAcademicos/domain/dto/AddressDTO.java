package com.projetosAcademicos.domain.dto;

import com.projetosAcademicos.domain.models.Address;

import lombok.Data;

@Data
public class AddressDTO {
	
	private Long id;
	private String street;
	private String number;
	private String cep;
	private String city;
	private String state;
	private String country;
	
	public AddressDTO(Address e) {
		this.id = e.getId();
		this.street = e.getStreet();
		this.number = e.getNumber();
		this.cep = e.getCep();
		this.city = e.getCity();
		this.state = e.getState();
		this.country = e.getCountry();
	}
}
