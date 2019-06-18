package com.rbn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbn.services.RegistryService;

import dtos.RegistryResponse;

@Controller
public class RegistryController {
	
	@Autowired
	private RegistryService registryService;
	

	@GetMapping(path="/getRegistry", consumes="application/json")
	@ResponseBody
	public RegistryResponse getRegistry(Long id) {
		return registryService.getRegistry(id);
	}
	
	
	
}
