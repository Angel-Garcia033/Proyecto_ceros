package com.proyecto.ceros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String cedula;
	private String nombre;
	private String nombre_completo;
	
	@Column (name="email", nullable=false, unique=true, length=20)
	private String correo;
	private String contrasena;
	private boolean enabled;
	
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
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public String getNombre_completo() 
	{
		return nombre_completo;
	}
	
	public void setNombre_completo(String nombre_completo) 
	{
		this.nombre_completo = nombre_completo;
	}
	
	public String getCorreo() 
	{
		return correo;
	}
	
	public void setCorreo(String correo) 
	{
		this.correo = correo;
	}
	
	public boolean isEnabled() 
	{
		return enabled;
	}
	
	public void setEnabled(boolean enabled) 
	{
		this.enabled = enabled;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	
}