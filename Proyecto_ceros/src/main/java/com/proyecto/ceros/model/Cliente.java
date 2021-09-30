package com.proyecto.ceros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="cliente")
public class Cliente 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String cedula;
	private String nombre_completo;
	private String direccion;
	private String telefono;
	private String correo_electronico;
	
	//==========================================================================
	
	public long getId() 
	{
		return id;
	}
	
	public void setId(long id) 
	{
		this.id = id;
	}
	
	public String getCedula() 
	{
		return cedula;
	}
	
	public void setCedula(String cedula) 
	{
		this.cedula = cedula;
	}
	
	public String getNombre_completo()
	{
		return nombre_completo;
	}
	
	public void setNombre_completo(String nombre_completo) 
	{
		this.nombre_completo = nombre_completo;
	}
	
	public String getDireccion() 
	{
		return direccion;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public String getTelefono() 
	{
		return telefono;
	}
	
	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	public String getCorreo_electronico() 
	{
		return correo_electronico;
	}
	
	public void setCorreo_electronico(String correo_electronico)
	{
		this.correo_electronico = correo_electronico;
	}
}