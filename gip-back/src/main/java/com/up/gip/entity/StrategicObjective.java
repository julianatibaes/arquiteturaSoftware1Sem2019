package com.up.gip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "strategic_objective_tb")
public class StrategicObjective implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_strategic_objective;
	
	@NotNull
	@Column(name = "description")
	private String description;

	public Integer getId_strategic_ojective() {
		return id_strategic_objective;
	}

	public void setId_strategic_ojective(Integer id_strategic_ojective) {
		this.id_strategic_objective = id_strategic_ojective;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
