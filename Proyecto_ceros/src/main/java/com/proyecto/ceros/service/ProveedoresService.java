package com.proyecto.ceros.service;

import java.util.Optional;
import com.proyecto.ceros.model.Proveedor;

public interface ProveedoresService 
{
	public Iterable<Proveedor> findAll ();
	public Optional<Proveedor> findById (Long nitproveedor);
	public Proveedor save (Proveedor proveedores);
	public void delete (Long nitproveedor);
}