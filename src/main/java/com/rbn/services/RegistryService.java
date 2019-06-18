package com.rbn.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rbn.repository.RegistryRepository;

import dtos.ErrorDto;
import dtos.RegistryDto;
import dtos.RegistryResponse;
import entities.Registry;

@Service
public class RegistryService implements IRegistryService {

	private RegistryRepository registryRepository;
	
	public RegistryService(RegistryRepository registryRepository) {
		this.registryRepository = registryRepository;
	}
	
	public RegistryResponse saveRegistry(RegistryDto registry) {
		
		RegistryResponse response = new RegistryResponse();
		
		try {
			registryRepository.save(registry.toRegistry());		
			response.setData(Arrays.asList(registry));
		}catch(Exception ex) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode(2);
			error.setMessage("Error inesperado guardando registro.");
			response.setError(error);
		}		
		
		return response;
	}
	
	public RegistryResponse getRegistry(Long id) {
		
		RegistryResponse response = new RegistryResponse();
		Registry registry;
		try {
			registry = registryRepository.findById(id).orElseThrow(Exception::new);		
			response.setData(Arrays.asList(new RegistryDto(registry)));
		}catch(Exception ex) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode(3);
			error.setMessage("Error inesperado recuperando registro.");
			response.setError(error);
		}		
		
		return response;
	}
	
	public RegistryResponse getRegistrys() {
		
		RegistryResponse response = new RegistryResponse();
		List<RegistryDto> registrys = new ArrayList<>();
		
		try {
			for(Registry registry : registryRepository.findAll()) {
				registrys.add(new RegistryDto(registry));
			}
			response.setData(registrys);
		}catch(Exception ex) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode(3);
			error.setMessage("Error inesperado recuperando todos los registros.");
			response.setError(error);
		}		
		
		return response;
	}
}
