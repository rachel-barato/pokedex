package com.rgama.pokedex;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<Especie, Integer> {
	
	List<Especie> findAll();
	
	Especie findByEspecie(String nome);

}
