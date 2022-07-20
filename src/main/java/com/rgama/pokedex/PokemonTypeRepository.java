package com.rgama.pokedex;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PokemonTypeRepository extends JpaRepository<PokemonType, Integer> {
	
	List<PokemonType> findByOrderByNameAsc();
	
	List<PokemonType> findAll();
	
	Optional<PokemonType> findById(Integer id);

}
