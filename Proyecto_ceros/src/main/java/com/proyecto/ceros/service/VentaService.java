package com.proyecto.ceros.service;

import java.util.Optional;

import com.proyecto.ceros.model.Venta;

public interface VentaService 
{
	public Iterable<Venta> findAll ();
	public Optional<Venta> findById (Long codigo);
	public Venta save (Venta venta);
	public void delete (Long codigo);
}