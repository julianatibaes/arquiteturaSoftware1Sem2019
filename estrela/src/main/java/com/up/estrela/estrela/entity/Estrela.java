package com.up.estrela.estrela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="estrela")
public class Estrela {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="idade")
	private int idade;
	
	@Column(name="massa")
	private double massa;
	
	@Column(name="temperatura")
	private float temperatura;
	
	@Column(name="diametro")
	private float diametro;

	
	/*
	 * @ManyToOne
@JoinColumn(name = "TableBColumn", referencedColumnName = "TableAColumn")
private TableA session_UserName;

@OneToMany(mappedBy="cart")
    private Set<Items> items;

	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getMassa() {
		return massa;
	}

	public void setMassa(double massa) {
		this.massa = massa;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public float getDiametro() {
		return diametro;
	}

	public void setDiametro(float diametro) {
		this.diametro = diametro;
	}

}