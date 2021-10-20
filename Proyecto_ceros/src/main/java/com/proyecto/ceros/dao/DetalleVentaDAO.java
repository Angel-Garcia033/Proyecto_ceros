package com.proyecto.ceros.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ceros.model.DetalleVenta;

public interface DetalleVentaDAO extends JpaRepository<DetalleVenta, Long>
{

}