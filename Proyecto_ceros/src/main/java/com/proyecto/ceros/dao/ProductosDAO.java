package com.proyecto.ceros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.ceros.model.Producto;

@Repository
public interface ProductosDAO extends JpaRepository<Producto, Long>
{

}