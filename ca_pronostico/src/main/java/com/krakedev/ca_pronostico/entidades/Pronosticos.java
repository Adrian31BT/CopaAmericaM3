package com.krakedev.ca_pronostico.entidades;

public class Pronosticos {
	private int pro_codigo;
	private Usuarios usuario;
	private Partidos partido;
	private int pro_marcador1;
	private int pro_marcador2;
	
	public Pronosticos() {
		super();
	}

	public Pronosticos(int pro_codigo, Usuarios usuario, Partidos partido, int pro_marcador1, int pro_marcador2) {
		super();
		this.pro_codigo = pro_codigo;
		this.usuario = usuario;
		this.partido = partido;
		this.pro_marcador1 = pro_marcador1;
		this.pro_marcador2 = pro_marcador2;
	}

	public int getPro_codigo() {
		return pro_codigo;
	}

	public void setPro_codigo(int pro_codigo) {
		this.pro_codigo = pro_codigo;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Partidos getPartido() {
		return partido;
	}

	public void setPartido(Partidos partido) {
		this.partido = partido;
	}

	public int getPro_marcador1() {
		return pro_marcador1;
	}

	public void setPro_marcador1(int pro_marcador1) {
		this.pro_marcador1 = pro_marcador1;
	}

	public int getPro_marcador2() {
		return pro_marcador2;
	}

	public void setPro_marcador2(int pro_marcador2) {
		this.pro_marcador2 = pro_marcador2;
	}

	@Override
	public String toString() {
		return "Pronosticos [pro_codigo=" + pro_codigo + ", usuario=" + usuario + ", partido=" + partido
				+ ", pro_marcador1=" + pro_marcador1 + ", pro_marcador2=" + pro_marcador2 + "]";
	}

	
}