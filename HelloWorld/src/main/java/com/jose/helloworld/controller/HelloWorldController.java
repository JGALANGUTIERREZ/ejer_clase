package com.jose.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dao.DAOCliente;

@Controller
public class HelloWorldController {

	@Autowired
	DAOCliente daoCliente;
	
	@Autowired
	public ModelAndView mostrar(){
		
	}
}
