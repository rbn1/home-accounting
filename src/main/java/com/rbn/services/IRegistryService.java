package com.rbn.services;

import dtos.RegistryDto;
import dtos.RegistryResponse;

public interface IRegistryService {

	public RegistryResponse saveRegistry(RegistryDto registry);
	public RegistryResponse getRegistry(Long id);
	public RegistryResponse getRegistrys();
}
