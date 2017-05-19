package com.jose.helloworld.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOCliente;
import modelos.Cliente;

@Controller

public class HolaMundoControlador {

	@Autowired
	DAOCliente daoCliente;
	
	@RequestMapping("/hola")
	public ModelAndView muestraMensaje(
			HttpSession sesion,
			@RequestParam(value="nombre",required=false,defaultValue="Mundo")String nombre){
		
		
		ModelAndView mv=new ModelAndView("holamundo");
		
		Cliente c=daoCliente.read(1);
		
		
		List<Cliente> lista=daoCliente.listar();
		mv.addObject("lista",lista);
		
		
		return mv;
		
	}
	
}
