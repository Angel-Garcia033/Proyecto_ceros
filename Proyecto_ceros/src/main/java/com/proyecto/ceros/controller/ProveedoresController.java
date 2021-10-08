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

import com.proyecto.ceros.model.Proveedor;
import com.proyecto.ceros.service.ProveedoresService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController 
{
	@Autowired
	private ProveedoresService proveedoresService;
	
	//Crear proveedores
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Proveedor proveedores)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresService.save(proveedores));
	}
	
	//Leer un proveedor
	@GetMapping("/{nitproveedor}")
	public ResponseEntity<?> read (@PathVariable(value="nitproveedor") Long nitproveedor)
	{
		Optional <Proveedor> oproveedores = proveedoresService.findById(nitproveedor);
		
		if (!oproveedores.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(oproveedores); 
		}
	}
	
	//Actualizar un proveedor
	@PutMapping("/{nitproveedor}")
	public ResponseEntity<?> update (@RequestBody Proveedor proveedoresDetails, @PathVariable(value = "nitproveedor") Long nitproveedor)
	{
		Optional <Proveedor> uproveedores = proveedoresService.findById(nitproveedor);
		
		if (!uproveedores.isPresent())
		{
			return ResponseEntity.notFound().build();
		}

		uproveedores.get().setNitproveedor(proveedoresDetails.getNitproveedor());
		uproveedores.get().setCiudad_proveedor(proveedoresDetails.getCiudad_proveedor());
		uproveedores.get().setDireccion_proveedor(proveedoresDetails.getDireccion_proveedor());
		uproveedores.get().setNombre_proveedor(proveedoresDetails.getNombre_proveedor());
		uproveedores.get().setTelefono_proveedor(proveedoresDetails.getTelefono_proveedor());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresService.save(uproveedores.get()));
	}
	
	//Borrar un proveedor
	@DeleteMapping("/{nitproveedor}")
	public ResponseEntity<?> delete	(@PathVariable(value = "nitproveedor") Long nitproveedor)
	{
		if (!proveedoresService.findById(nitproveedor).isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		proveedoresService.delete(nitproveedor);
		return ResponseEntity.ok().build();
	}

	//Listar todos los proveedores
	@GetMapping
	public List<Proveedor> readAll()
	{
		List<Proveedor> proveedores = StreamSupport.stream (proveedoresService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return proveedores;
	}
}