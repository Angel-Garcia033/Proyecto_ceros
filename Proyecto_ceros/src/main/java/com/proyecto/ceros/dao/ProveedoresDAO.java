package com.proyecto.ceros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.ceros.model.Proveedor;

@Repository
public interface ProveedoresDAO extends JpaRepository<Proveedor, Long> 
{

}