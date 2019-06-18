package com.rbn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
