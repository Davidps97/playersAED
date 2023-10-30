package com.david.players.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.david.players.entity.models.Teams;

public interface ITeamsDao extends CrudRepository<Teams, Long>{

}
