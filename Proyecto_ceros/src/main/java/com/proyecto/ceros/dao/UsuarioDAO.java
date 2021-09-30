package com.proyecto.ceros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ceros.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>
{

}