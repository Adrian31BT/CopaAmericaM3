package com.krakedev.ca_pronostico.entidades;

public class Equipos {
	private int equ_codigo;
	private String equ_iso;
	private String equ_nombre;
	
	public Equipos() {
		super();
	}

	public Equipos(int equ_codigo, String equ_iso, String equ_nombre) {
		super();
		this.equ_codigo = equ_codigo;
		this.equ_iso = equ_iso;
		this.equ_nombre = equ_nombre;
	}

	public int getEqu_codigo() {
		return equ_codigo;
	}

	public void setEqu_codigo(int equ_codigo) {
		this.equ_codigo = equ_codigo;
	}

	public String getEqu_iso() {
		return equ_iso;
	}

	public void setEqu_iso(String equ_iso) {
		this.equ_iso = equ_iso;
	}

	public String getEqu_nombre() {
		return equ_nombre;
	}

	public void setEqu_nombre(String equ_nombre) {
		this.equ_nombre = equ_nombre;
	}

	@Override
	public String toString() {
		return "Equipos [equ_codigo=" + equ_codigo + ", equ_iso=" + equ_iso + ", equ_nombre=" + equ_nombre + "]";
	}
	
}
