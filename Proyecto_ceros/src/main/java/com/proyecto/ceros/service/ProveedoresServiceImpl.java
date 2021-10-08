package com.proyecto.ceros.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ceros.dao.ProveedoresDAO;
import com.proyecto.ceros.model.Proveedor;

@Service
public class ProveedoresServiceImpl implements ProveedoresService
{
	@Autowired
	private ProveedoresDAO proveedoresdao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Proveedor> findAll() 
	{
		return proveedoresdao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedor> findById(Long nitproveedor) 
	{
		return proveedoresdao.findById(nitproveedor);
	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedores) 
	{
		return proveedoresdao.save(proveedores);
	}

	@Override
	@Transactional
	public void delete(Long nitproveedor) 
	{
		proveedoresdao.deleteById(nitproveedor);
	}	
}