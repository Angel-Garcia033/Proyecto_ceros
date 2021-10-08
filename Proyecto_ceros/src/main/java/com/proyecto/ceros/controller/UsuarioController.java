package com.proyecto.ceros.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ceros.model.Cliente;
import com.proyecto.ceros.model.Usuario;
import com.proyecto.ceros.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController 
{
	@Autowired
	private UsuarioService usuarioService;
	
	//Crear usuarios
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Usuario usuario)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	//Leer un usuario
	@GetMapping("/{cedula}")
	public ResponseEntity<?> read (@PathVariable(value="cedula") Long cedula)
	{
		Optional <Usuario> oUsuario = usuarioService.findById(cedula);
		
		if (!oUsuario.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(oUsuario); 
		}
	}
	
	//Actualizar un usuario
	@PutMapping("/{cedula}")
	public ResponseEntity<?> update (@RequestBody Usuario usuarioDetails, @PathVariable(value = "cedula") Long cedula)
	{
		Optional <Usuario> uUsuario = usuarioService.findById(cedula);
		
		if (!uUsuario.isPresent())
		{
			return ResponseEntity.notFound().build();
		}

		uUsuario.get().setCedula(usuarioDetails.getCedula());
		uUsuario.get().setCorreo(usuarioDetails.getCorreo());
		uUsuario.get().setEnabled(usuarioDetails.isEnabled());
		uUsuario.get().setNombre(usuarioDetails.getNombre());
		uUsuario.get().setNombre_completo(usuarioDetails.getNombre_completo());
		uUsuario.get().setContrasena(usuarioDetails.getContrasena());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(uUsuario.get()));
	}
	
	//Borrar usuario
	@DeleteMapping("/{cedula}")
	public ResponseEntity<?> delete	(@PathVariable(value = "cedula") Long cedula)
	{
		if (!usuarioService.findById(cedula).isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		usuarioService.delete(cedula);
		return ResponseEntity.ok().build();
	}

	//Listar todos los usuarios
	@GetMapping
	public List<Usuario> readAll()
	{
		List<Usuario> usuario = StreamSupport.stream (usuarioService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return usuario;
	}
}