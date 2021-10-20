package com.proyecto.ceros.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ceros.dao.DetalleVentaDAO;
import com.proyecto.ceros.model.DetalleVenta;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService
{
	@Autowired
	private DetalleVentaDAO detalleventadao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<DetalleVenta> findAll() 
	{
		return detalleventadao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetalleVenta> findById(Long codigo) 
	{
		return detalleventadao.findById(codigo);
	}

	@Override
	@Transactional
	public DetalleVenta save(DetalleVenta detalleventa) 
	{
		return detalleventadao.save (detalleventa);
	}

	@Override
	@Transactional
	public void delete(Long codigo) 
	{
		detalleventadao.deleteById(codigo);
	}	
}