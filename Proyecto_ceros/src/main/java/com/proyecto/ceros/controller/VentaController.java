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

import com.proyecto.ceros.model.Venta;
import com.proyecto.ceros.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController 
{
	@Autowired
	private VentaService ventaService;
	
	//Crear ventas
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Venta venta)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(venta));
	}
	
	//Leer una venta
	@GetMapping("/{codigo}")
	public ResponseEntity<?> read (@PathVariable(value="codigo") Long codigo)
	{
		Optional <Venta> oventa = ventaService.findById(codigo);
		
		if (!oventa.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(oventa); 
		}
	}
	
	//Actualizar una venta
	@PutMapping("/{codigo}")
	public ResponseEntity<?> update (@RequestBody Venta ventaDetails, @PathVariable(value = "codigo") Long codigo)
	{
		Optional <Venta> uventa = ventaService.findById(codigo);
		
		if (!uventa.isPresent())
		{
			return ResponseEntity.notFound().build();
		}

		uventa.get().setCodigo_venta(ventaDetails.getCodigo_venta());
		uventa.get().setCedula(ventaDetails.getCedula());
		uventa.get().setCedula_usuario(ventaDetails.getCedula_usuario());
		uventa.get().setIvaventa(ventaDetails.getIvaventa());
		uventa.get().setTotal_venta(ventaDetails.getTotal_venta());
		uventa.get().setValor_venta(ventaDetails.getValor_venta());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(uventa.get()));
	}
	
	//Borrar una venta
	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> delete	(@PathVariable(value = "codigo") Long codigo)
	{
		if (!ventaService.findById(codigo).isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		ventaService.delete(codigo);
		return ResponseEntity.ok().build();
	}

	//Listar todas las ventas
	@GetMapping
	public List<Venta> readAll()
	{
		List<Venta> venta = StreamSupport.stream (ventaService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return venta;
	}
}