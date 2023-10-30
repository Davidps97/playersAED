package com.david.players.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.players.entity.dao.ITeamsDao;
import com.david.players.entity.models.Teams;

@Service
public class TeamsServicesImpl implements ITeamsService{
	
	@Autowired
	private ITeamsDao teamsDao;

	@Override
	public Teams get(long id) {
		return teamsDao.findById(id).get();
	}

	@Override
	public List<Teams> getAll(){
		return (List<Teams>)teamsDao.findAll();
	}

	@Override
	public void post(Teams team) {
		teamsDao.save(team);
		
	}

	@Override
	public void put(Teams team, long id) {
		teamsDao.findById(id).ifPresent((x)->{
			team.setId(id);
			teamsDao.save(team);
		});
		
	}

	@Override
	public void delete(long id) {
		teamsDao.deleteById(id);
		
	}
	
	
}
