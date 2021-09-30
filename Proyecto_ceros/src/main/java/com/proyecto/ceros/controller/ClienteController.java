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
import com.proyecto.ceros.service.ClienteService;

@RestController
@RequestMapping ("/api/cliente")
public class ClienteController 
{
	@Autowired
	private ClienteService clienteservice;
	
	//Crear un nuevo cliente
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteservice.save(cliente));
	}
	
	//Mostrar un cliente
	@GetMapping ("/{id}")
	public ResponseEntity<?> read(@PathVariable(value= "id") Long clienteid)
	{
		Optional<Cliente> ucliente = clienteservice.findById(clienteid);
		
		if (!ucliente.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(ucliente);
	}
	
	//Actualizar un cliente
	@PutMapping ("/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente clienteDetails, @PathVariable(value = "id") Long clienteid)
	{
		Optional<Cliente> icliente = clienteservice.findById(clienteid);
		
		if (!icliente.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		icliente.get().setCedula(clienteDetails.getCedula());
		icliente.get().setNombre_completo(clienteDetails.getNombre_completo());
		icliente.get().setDireccion(clienteDetails.getDireccion());
		icliente.get().setTelefono(clienteDetails.getTelefono());
		icliente.get().setCorreo_electronico(clienteDetails.getCorreo_electronico());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteservice.save(icliente.get()));
	}
	
	//Eliminar un cliente
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long clienteid)
	{
		if (!clienteservice.findById(clienteid).isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		clienteservice.delete(clienteid);
		
		return ResponseEntity.ok().build();
	}
	
	//Mostrar todos los clientes
	@GetMapping
	public List<Cliente> readAll()
	{
		List<Cliente> cliente = StreamSupport.stream (clienteservice.findAll().spliterator(), false).collect(Collectors.toList());
		
		return cliente;
	}
}