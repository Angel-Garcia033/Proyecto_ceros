package com.proyecto.ceros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ceros.model.Venta;

@Repository
public interface VentaDAO extends JpaRepository<Venta, Long> 
{

}
