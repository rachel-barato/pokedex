package com.rgama.pokedex;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoDePokemonRepository extends JpaRepository<TipoDePokemon, Integer> {
	
	List<TipoDePokemon> findByOrderByTipoAsc();
	
	List<TipoDePokemon> findAll();
	
	Optional<TipoDePokemon> findById(Integer id);

}
