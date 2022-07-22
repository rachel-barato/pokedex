package com.rgama.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgama.pokedex.exception.PokedexEntityNotFoundException;
import com.rgama.pokedex.model.Skill;
import com.rgama.pokedex.repository.SkillRepository;

@Service
public class SkillService {	
	
	@Autowired
	private SkillRepository skillRepository;
	
	public Skill createNewSkill(Skill newSkill) {
		return skillRepository.save(newSkill);
	}
	
	public void deleteSkill(Integer id) {
		skillRepository.deleteById(id);
	}
	
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}
	
	public Skill getSkillById(Integer id) {
		return skillRepository.findById(id)
				.orElseThrow(() -> new PokedexEntityNotFoundException("skill", id));
	}	
}
