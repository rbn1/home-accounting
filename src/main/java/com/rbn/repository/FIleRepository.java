package com.rbn.repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import dtos.ErrorDto;
import dtos.RegistryDto;
import dtos.RegistryResponse;

@Repository
public class FIleRepository {

	@Value("${app.files.path}")
	private String filesPath;
	
	public RegistryResponse saveRagistry(RegistryDto registry) {
		RegistryResponse registryResponse = new RegistryResponse();
		BufferedWriter writer;
		String dateToString;
		Date registryDate;
		
		try {
			registryDate = registry.getDate();
			dateToString = registryDate.getYear() +"-" + registryDate.getMonth() + "-" + registryDate.getDay();
			filesPath += "/" + dateToString + ".txt";
			
			writer = new BufferedWriter(new FileWriter(filesPath,true));

			writer.append(registry.getId().toString()).append(";");
			writer.append(registry.getDate().toLocaleString()).append(";");
			writer.append(registry.getReason()).append(";");
			writer.append(registry.getAmount().toString()).append(";");
			
			writer.append("\n");
		} catch (IOException e) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode(1);
			error.setMessage("Error escribiendo los datos en el fichero");
			registryResponse.setError(error);
		}
		
		registryResponse.setData(Arrays.asList(registry));		
		
		return registryResponse;
	}
	
/*	public List<RegistryResponse> getRegistrys(){
		
		RegistryResponse registryResponse = new RegistryResponse();
		BufferedWriter writer;
		String dateToString;
		Date registryDate;
		
		try {
			registryDate = registry.getDate();
			dateToString = registryDate.getYear() +"-" + registryDate.getMonth() + "-" + registryDate.getDay();
			filesPath += "/" + dateToString + ".txt";
			
			writer = new BufferedWriter(new FileWriter(filesPath,true));

			writer.append(registry.getId().toString()).append(";");
			writer.append(registry.getDate().toLocaleString()).append(";");
			writer.append(registry.getReason()).append(";");
			writer.append(registry.getAmount().toString()).append(";");
			
			writer.append("\n");
		} catch (IOException e) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode(1);
			error.setMessage("Error escribiendo los datos en el fichero");
			registryResponse.setError(error);
		}
		
		registryResponse.setData(Arrays.asList(registry));		
		
		return registryResponse;
	}*/
	
}
