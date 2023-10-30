package com.david.players.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.players.entity.dao.IMatchesDao;
import com.david.players.entity.models.Matches;

@Service
public class MatchesServicesImpl implements IMatchesService{
	
	@Autowired
	private IMatchesDao matchDao;
	
	@Override
	public Matches get(long id) {
		return matchDao.findById(id).get();	}

	@Override
	public List<Matches> getAll() {
		return (List<Matches>)matchDao.findAll();
	}

	@Override
	public void post(Matches match) {
		matchDao.save(match);
		
	}

	@Override
	public void put(Matches match, long id) {
		matchDao.findById(id).ifPresent((x)->{
			match.setId(id);
			matchDao.save(match);
		});
		
	}

	@Override
	public void delete(long id) {
		matchDao.deleteById(id);
		
	}

}
