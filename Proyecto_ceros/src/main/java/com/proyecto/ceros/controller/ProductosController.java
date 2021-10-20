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

import com.proyecto.ceros.model.Producto;
import com.proyecto.ceros.service.ProductosService;

@RestController
@RequestMapping("/api/productos")
public class ProductosController 
{
	@Autowired
	private ProductosService productosService;
	
	//Crear productos
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Producto productos)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(productosService.save(productos));
	}
	
	//Leer un producto
	@GetMapping("/{codigo_producto}")
	public ResponseEntity<?> read (@PathVariable(value="codigo_producto") Long codigo_producto)
	{
		Optional <Producto> oproductos = productosService.findById(codigo_producto);
		
		if (!oproductos.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(oproductos); 
		}
	}
	
	//Actualizar un producto
	@PutMapping("/{codigo_producto}")
	public ResponseEntity<?> update (@RequestBody Producto productoDetails, @PathVariable(value = "codigo_producto") Long codigo_producto)
	{
		Optional <Producto> uproductos = productosService.findById(codigo_producto);
		
		if (!uproductos.isPresent())
		{
			return ResponseEntity.notFound().build();
		}

		uproductos.get().setProveedores(productoDetails.getProveedores());
		uproductos.get().setCodigo_producto(productoDetails.getCodigo_producto());
		uproductos.get().setIvacompra(productoDetails.getIvacompra());
		uproductos.get().setNombre_producto(productoDetails.getNombre_producto());
		uproductos.get().setPrecio_compra(productoDetails.getPrecio_compra());
		uproductos.get().setPrecio_venta(productoDetails.getPrecio_venta());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(productosService.save(uproductos.get()));
	}
	
	//Borrar un producto
	@DeleteMapping("/{codigo_producto}")
	public ResponseEntity<?> delete	(@PathVariable(value = "codigo_producto") Long codigo_producto)
	{
		if (!productosService.findById(codigo_producto).isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		productosService.delete(codigo_producto);
		return ResponseEntity.ok().build();
	}

	//Listar todos los productos
	@GetMapping
	public List<Producto> readAll()
	{
		List<Producto> productos = StreamSupport.stream (productosService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return productos;
	}
}