package com.david.players.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.players.entity.dao.IPlayersDao;
import com.david.players.entity.models.players;

@Service
public class playersServicesImpl implements IPlayersService{
	
	@Autowired
	private IPlayersDao playerDao;

	@Override
	public players get(long id) {
		
		return playerDao.findById(id).get();
	}
	@Override
	public List<players> getAll() {
		
		return (List<players>)playerDao.findAll();
	}

	@Override
	public void post(players player) {
		playerDao.save(player);
		
	}

	@Override
	public void put(players player, long id) {
		playerDao.findById(id).ifPresent((x)->{
			player.setId(id);
			playerDao.save(player);
		});
		
	}

	@Override
	public void delete(long id) {
		playerDao.deleteById(id);
		
	}
	
}