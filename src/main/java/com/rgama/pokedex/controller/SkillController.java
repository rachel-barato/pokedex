package com.rgama.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgama.pokedex.model.Skill;
import com.rgama.pokedex.service.SkillService;

@RestController
@RequestMapping(path="/skills")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@PostMapping()
	public ResponseEntity<Skill> createNewSkill(@RequestBody Skill newSkill) {
		return ResponseEntity.ok(skillService.createNewSkill(newSkill));
	}
	
	@GetMapping()
	public ResponseEntity<List<Skill>> getAllSkills() {
		return ResponseEntity.ok(skillService.getAllSkills());
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<String> deleteSkill(@PathVariable Integer id) {
		skillService.deleteSkill(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Skill> getSkillById(@PathVariable Integer id) {
		return ResponseEntity.ok(skillService.getSkillById(id));
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Skill> replaceSkill(@RequestBody Skill newSkill, @PathVariable Integer id) {
		return ResponseEntity.ok(skillService.replaceSkill(newSkill, id));
	}
}
