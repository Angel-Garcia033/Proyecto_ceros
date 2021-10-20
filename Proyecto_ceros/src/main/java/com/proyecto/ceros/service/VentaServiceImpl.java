package com.proyecto.ceros.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ceros.dao.VentaDAO;
import com.proyecto.ceros.model.Venta;

@Service
public class VentaServiceImpl implements VentaService
{
	@Autowired
	private VentaDAO ventadao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findAll() 
	{
		return ventadao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Venta> findById(Long codigo) 
	{
		return ventadao.findById(codigo);
	}

	@Override
	@Transactional
	public Venta save(Venta venta) 
	{
		return ventadao.save (venta);
	}

	@Override
	@Transactional
	public void delete(Long codigo) 
	{
		ventadao.deleteById(codigo);
	}
	
}