package com.proyecto.ceros.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ceros.model.Usuario;
import com.proyecto.ceros.dao.UsuarioDAO;

@Service
public class UsuarioServiceImpl implements UsuarioService 
{
	@Autowired
	private UsuarioDAO usuariodao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() 
	{
		return usuariodao.findAll ();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) 
	{
		return usuariodao.findById (id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) 
	{
		return usuariodao.save (usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) 
	{
		usuariodao.deleteById(id);
	}
}