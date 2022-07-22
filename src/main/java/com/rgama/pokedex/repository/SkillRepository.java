package com.rgama.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgama.pokedex.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
