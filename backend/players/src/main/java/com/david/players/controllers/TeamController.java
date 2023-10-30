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

import com.david.players.entity.models.Teams;
import com.david.players.entity.services.ITeamsService;

@RestController
@CrossOrigin(origins="*")
public class TeamController {

	@Autowired
	ITeamsService TeamService;
	
	@GetMapping("/Teams/{id}")
	public Teams getOne(@PathVariable(value="id")long id) {
		return TeamService.get(id);
	}
	
	@GetMapping("/Teams")
	public List<Teams>getAllTeams() {
		return TeamService.getAll();
	}
	
	@PostMapping("/Teams")
	public void post(@RequestBody Teams teams) {
		TeamService.post(teams);
	}
	
	@PutMapping("/Teams/{id}")
	public void put (@RequestBody Teams teams, @PathVariable(value = "id")long id) {
		TeamService.put(teams, id);
	}
	
	@DeleteMapping("Teams/{id}")
	public void delete(@PathVariable(value = "id")long id) {
		TeamService.delete(id);
	}
}
