package com.david.players.entity.models;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="matches")
public class Matches implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String localTeam;
    private String awayTeam;
    private Timestamp matchDateTime;
    private String stadium;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLocalTeam() {
		return localTeam;
	}
	public void setLocalTeam(String localTeam) {
		this.localTeam = localTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public Timestamp getMatchDateTime() {
		return matchDateTime;
	}
	public void setMatchDateTime(Timestamp matchDateTime) {
		this.matchDateTime = matchDateTime;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public Matches(long id, String localTeam, String awayTeam, Timestamp matchDateTime, String stadium) {
		super();
		this.id = id;
		this.localTeam = localTeam;
		this.awayTeam = awayTeam;
		this.matchDateTime = matchDateTime;
		this.stadium = stadium;
	}
    
    public Matches() {
    	
    }
}
