package com.proyecto.ceros.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ceros.dao.ClienteDAO;
import com.proyecto.ceros.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService
{
	@Autowired
	private ClienteDAO clientedao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findAll() 
	{
		return clientedao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Long id) 
	{
		return clientedao.findById(id);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) 
	{
		return clientedao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) 
	{
		clientedao.deleteById(id);
	}	
}