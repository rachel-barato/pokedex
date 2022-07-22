package com.rgama.pokedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgama.pokedex.model.Species;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
	
	Species findByName(String name);
	
	List<Species> findByOrderByNameAsc();

}
