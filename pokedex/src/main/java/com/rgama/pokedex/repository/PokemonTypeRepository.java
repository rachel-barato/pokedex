package com.rgama.pokedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgama.pokedex.model.PokemonType;


public interface PokemonTypeRepository extends JpaRepository<PokemonType, Integer> {
	
	List<PokemonType> findByOrderByNameAsc();

}
