package com.david.players.entity.services;

import java.util.List;

import com.david.players.entity.models.Matches;

public interface IMatchesService {
	
	public Matches get(long id);
	public List <Matches> getAll();
	public void post(Matches match);
	public void put(Matches match, long id);
	public void delete(long id);
}
