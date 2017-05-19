package com.jose.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOCliente;
import modelos.Cliente;

@Controller
public class HolaMundoControlador {

	@Autowired
	DAOCliente daoCliente;
	
	@RequestMapping("/hola")
	public ModelAndView muestraMensaje(
			@RequestParam(value="nombre",required=false,defaultValue="Mundo")String nombre){
		
		
		ModelAndView mv=new ModelAndView("holamundo");
		
		Cliente c=daoCliente.read(1);
		
		mv.addObject("mensaje","Hola. Bienvenido al MVC de Spring");
		mv.addObject("nombre",nombre);
		
		return mv;
		
	}
	
}
