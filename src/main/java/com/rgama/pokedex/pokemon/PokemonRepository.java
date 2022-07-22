package com.rgama.pokedex.pokemon;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

	List<Pokemon> findAll();
	
	Optional<Pokemon> findById(Integer Id);
}
