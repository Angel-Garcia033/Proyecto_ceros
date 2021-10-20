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

import com.proyecto.ceros.model.DetalleVenta;
import com.proyecto.ceros.service.DetalleVentaService;

@RestController
@RequestMapping("/api/detalleventa")
public class DetalleVentaController 
{
	@Autowired
	private DetalleVentaService detalleventaService;
	
	//Crear detalle venta
	@PostMapping
	public ResponseEntity<?> create (@RequestBody DetalleVenta detalleventa)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleventaService.save(detalleventa));
	}
	
	//Leer un detalle venta
	@GetMapping("/{codigo}")
	public ResponseEntity<?> read (@PathVariable(value="codigo") Long codigo)
	{
		Optional <DetalleVenta> odetalleventa = detalleventaService.findById(codigo);
		
		if (!odetalleventa.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(odetalleventa); 
		}
	}
	
	//Actualizar un detalle venta
	@PutMapping("/{codigo}")
	public ResponseEntity<?> update (@RequestBody DetalleVenta detalleventaDetails, @PathVariable(value = "codigo") Long codigo)
	{
		Optional <DetalleVenta> udetalleventa = detalleventaService.findById(codigo);
		
		if (!udetalleventa.isPresent())
		{
			return ResponseEntity.notFound().build();
		}

		udetalleventa.get().setCodigo_detalle_venta(detalleventaDetails.getCodigo_detalle_venta());
		udetalleventa.get().setCantidad_producto(detalleventaDetails.getCantidad_producto());
		udetalleventa.get().setCodigo_producto(detalleventaDetails.getCodigo_producto());
		udetalleventa.get().setCodigo_venta(detalleventaDetails.getCodigo_venta());
		udetalleventa.get().setIva_venta(detalleventaDetails.getIva_venta());
		udetalleventa.get().setTotal_venta(detalleventaDetails.getTotal_venta());
		udetalleventa.get().setValor_venta(detalleventaDetails.getValor_venta());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleventaService.save(udetalleventa.get()));
	}
	
	//Borrar un detalle venta
	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> delete	(@PathVariable(value = "codigo") Long codigo)
	{
		if (!detalleventaService.findById(codigo).isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		detalleventaService.delete(codigo);
		return ResponseEntity.ok().build();
	}

	//Listar todos los detalle venta
	@GetMapping
	public List<DetalleVenta> readAll()
	{
		List<DetalleVenta> detalleventa = StreamSupport.stream (detalleventaService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return detalleventa;
	}
}