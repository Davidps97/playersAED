package com.david.players.entity.services;

import java.util.List;

import com.david.players.entity.models.Teams;

public interface ITeamsService {
	
	public Teams get(long id);
	public List <Teams> getAll();
	public void post(Teams team);
	public void put(Teams team, long id);
	public void delete(long id);
}
