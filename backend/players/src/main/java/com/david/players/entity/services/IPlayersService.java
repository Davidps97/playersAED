package com.david.players.entity.services;

import java.util.List;

import com.david.players.entity.models.players;

public interface IPlayersService {
	public players get(long id);
	public List <players> getAll();
	public void post(players player);
	public void put(players player, long id);
	public void delete(long id);
}
