package com.up.gip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="project_tb")
public class Project implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ElementCollection
	@ManyToOne
	@JoinColumn(name = "fk_user_owner", 
	referencedColumnName="user_name")
	private User owner;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_start")
	private Date startProject;
	
	@NotNull
	@Column(name="title")
	private String title;
	
	@Column(name="field")
	private String field;
	
	@Column(name="perspective")
	private String perspective;
	
	@ElementCollection
	@ManyToOne
	@JoinColumn(name = "fk_program", 
	referencedColumnName="id_program")
	private Program program;
	
	@ElementCollection
	@ManyToOne
	@JoinColumn(name = "fk_strategic_objective", 
	referencedColumnName="id_strategic_objective")
	private StrategicObjective strategic_objective;

	public Integer getId_project() {
		return id;
	}

	public void setId_project(Integer id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getStartProject() {
		return startProject;
	}

	public void setStartProject(Date startProject) {
		this.startProject = startProject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getPerspective() {
		return perspective;
	}

	public void setPerspective(String perspective) {
		this.perspective = perspective;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public StrategicObjective getStrategic_objective() {
		return strategic_objective;
	}

	public void setStrategic_objective(StrategicObjective strategic_objective) {
		this.strategic_objective = strategic_objective;
	}
	
	

}
