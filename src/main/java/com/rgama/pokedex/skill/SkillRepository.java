package com.rgama.pokedex.skill;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
	
	List<Skill> findAll();

}
