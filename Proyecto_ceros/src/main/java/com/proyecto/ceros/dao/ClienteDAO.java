package com.proyecto.ceros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ceros.model.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository <Cliente, Long>
{
	
}