package com.david.players.entity.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="teams")
public class Teams implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String localKit;
	private String awayKit;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocalKit() {
		return localKit;
	}
	public void setLocalKit(String localKit) {
		this.localKit = localKit;
	}
	public String getAwayKit() {
		return awayKit;
	}
	public void setAwayKit(String awayKit) {
		this.awayKit = awayKit;
	}
	public Teams(long id, String name, String localKit, String awayKit) {
		super();
		this.id = id;
		this.name = name;
		this.localKit = localKit;
		this.awayKit = awayKit;
	}
	
	public Teams() {
		
	}
}
