package com.proyecto.ceros.service;

import java.util.Optional;
import com.proyecto.ceros.model.Usuario;

public interface UsuarioService 
{
	public Iterable<Usuario> findAll ();
	public Optional<Usuario> findById (Long cedula);
	public Usuario save (Usuario usuario);
	public void delete (Long cedula);
}
