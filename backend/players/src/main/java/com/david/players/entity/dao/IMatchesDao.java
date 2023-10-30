package com.david.players.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.david.players.entity.models.Matches;

public interface IMatchesDao extends CrudRepository<Matches, Long>{

}
