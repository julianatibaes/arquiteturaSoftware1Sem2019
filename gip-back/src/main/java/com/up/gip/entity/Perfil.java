package com.up.gip.entity;

import java.io.Serializable;

public enum Perfil implements Serializable{
	MASTER(1),
	COMMOM(2),
	ADMIN(3);
	
	private final int valorPerfil;
	
	Perfil(int perfil) {
		valorPerfil = perfil;
	}
	
	public int getPerfil() {
		return valorPerfil;
	}
}
