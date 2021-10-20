package com.proyecto.ceros.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.proyecto.ceros.model.Producto;
import com.proyecto.ceros.model.Venta;

@Entity
@Table(name="detalleventa")
public class DetalleVenta 
{
	@Id
	private Long codigo_detalle_venta;
	
	private int cantidad_producto;
	
	@ManyToOne 
	@JoinColumn(nullable = false) 
	private Producto codigo_producto;
	
	@ManyToOne 
	@JoinColumn(nullable = false) 
	private Venta codigo_venta;
	
	private Double iva_venta;
	
	private Double total_venta;
	
	private Double valor_venta;
	
	//==========================================================================

	public Long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(Long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Producto getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Producto codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Venta getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Venta codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public Double getIva_venta() {
		return iva_venta;
	}

	public void setIva_venta(Double iva_venta) {
		this.iva_venta = iva_venta;
	}

	public Double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
}