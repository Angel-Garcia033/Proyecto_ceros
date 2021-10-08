package com.proyecto.ceros.service;

import java.util.Optional;
import com.proyecto.ceros.model.Producto;

public interface ProductosService 
{
	public Iterable<Producto> findAll ();
	public Optional<Producto> findById (Long codigo_producto);
	public Producto save (Producto productos);
	public void delete (Long codigo_producto);	
}