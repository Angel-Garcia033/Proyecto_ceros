package com.proyecto.ceros.service;

import java.util.Optional;

import com.proyecto.ceros.model.DetalleVenta;

public interface DetalleVentaService 
{
	public Iterable<DetalleVenta> findAll ();
	public Optional<DetalleVenta> findById (Long codigo);
	public DetalleVenta save (DetalleVenta detalleventa);
	public void delete (Long codigo);	
}