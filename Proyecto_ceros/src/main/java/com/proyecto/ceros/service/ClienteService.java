package com.proyecto.ceros.service;

import java.util.Optional;

import com.proyecto.ceros.model.Cliente;

public interface ClienteService 
{
	public Iterable <Cliente> findAll(); 
	public Optional <Cliente> findById(Long id);
	public Cliente save (Cliente cliente);
	public void delete(Long id);
}