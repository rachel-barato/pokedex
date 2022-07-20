package com.rgama.pokedex;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
	
	List<Species> findAll();
	
	Species findByName(String name);
	
	List<Species> findByOrderByNameAsc();

}
