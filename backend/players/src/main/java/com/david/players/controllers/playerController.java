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

import com.david.players.entity.models.players;
import com.david.players.entity.services.IPlayersService;

@RestController
@CrossOrigin(origins="*")
public class playerController {
	
	@Autowired
	IPlayersService playerService;
	
	@GetMapping("/players/{id}")
	public players getOne(@PathVariable(value="id")long id) {
		return playerService.get(id);
	}
	
	@GetMapping("/players")
	public List<players>getAllPlayers(){
		return playerService.getAll();
	}
	
	@PostMapping("/players")
	public void post(@RequestBody players player) {
		playerService.post(player);
	}
	
	@PutMapping("/players/{id}")
	public void put(@RequestBody players player, @PathVariable(value = "id")long id) {
		playerService.put(player, id);
	}
	
	@DeleteMapping("/players/{id}")
	public void delete(@PathVariable(value = "id")long id) {
		playerService.delete(id);
	}
}
