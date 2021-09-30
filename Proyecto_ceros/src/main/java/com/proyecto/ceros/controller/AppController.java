package com.proyecto.ceros.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class AppController 
{
	@GetMapping({"/","/login"})
	public String index()
	{
		return "index";
	}
	
	@GetMapping({"/usuarios"})
	public String usuarios()
	{
		return "usuarios";
	}
	
	@GetMapping({"/clientes"})
	public String clientes()
	{
		return "clientes";
	}
	
	@RequestMapping("/validar")
	public String Validar(HttpServletRequest req, HttpServletRequest resp)
	{
		String Usuario = req.getParameter("usuario");
		String Contrasena = req.getParameter("contrasena");
		
		if (Usuario.equals ("admininicial") && Contrasena.equals("admin123456"))
		{
			return "menu";
		}
		else
		{
			return "error";
		}
	}
}
