package com.projetosAcademicos.domain.repositories;

import com.projetosAcademicos.domain.models.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>{}
