package com.rgama.pokedex;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoDePokemonRepository extends JpaRepository<TipoDePokemon, Integer> {
	
	List<TipoDePokemon> findByOrderByTipoAsc();
	
	List<TipoDePokemon> findAll();
	
	TipoDePokemon findById();

}
