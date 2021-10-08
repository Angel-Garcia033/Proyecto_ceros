package com.proyecto.ceros.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ceros.dao.ProductosDAO;
import com.proyecto.ceros.model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService
{
	@Autowired
	private ProductosDAO productosdao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() 
	{
		return productosdao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Long codigo_producto) 
	{
		return productosdao.findById(codigo_producto);
	}

	@Override
	@Transactional
	public Producto save(Producto productos) 
	{
		return productosdao.save (productos);
	}

	@Override
	@Transactional
	public void delete(Long codigo_producto) 
	{
		productosdao.deleteById(codigo_producto);
	}	
}