package com.david.players.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.david.players.entity.models.Matches;
import com.david.players.entity.services.IMatchesService;

@RestController
@CrossOrigin(origins="*")
public class MatchController {

	@Autowired
	IMatchesService matchService;
	
	@GetMapping("/Match/{id}")
	public Matches getOne(@PathVariable(value="id")long id) {
		return matchService.get(id);
	}
	
	@GetMapping("/Matches")
	public List<Matches>getAllMatches(){
		return matchService.getAll();
	}
	
	@PostMapping("/Matches")
	public void post(@RequestBody Matches match) {
		matchService.post(match);
	}
	
	@PutMapping("/Matches/{id}")
	public void put(@RequestBody Matches match, @PathVariable(value = "id")long id) {
		matchService.put(match, id);
	}
	
	@DeleteMapping("/Matches/{id}")
	public void delete(@PathVariable(value = "id")long id) {
		matchService.delete(id);
	}
}
