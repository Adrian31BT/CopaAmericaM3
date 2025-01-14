package com.krakedev.ca_pronostico.entidades;

public class Usuarios {
	private String usu_cedula;
	private String usu_nombres;
	private String usu_apellidos;

	public Usuarios() {
		super();
	}
	
	public Usuarios(String usu_cedula, String usu_nombres, String usu_apellidos) {
		super();
		this.usu_cedula = usu_cedula;
		this.usu_nombres = usu_nombres;
		this.usu_apellidos = usu_apellidos;
	}

	public String getUsu_cedula() {
		return usu_cedula;
	}
	public void setUsu_cedula(String usu_cedula) {
		this.usu_cedula = usu_cedula;
	}
	public String getUsu_nombres() {
		return usu_nombres;
	}
	public void setUsu_nombres(String usu_nombres) {
		this.usu_nombres = usu_nombres;
	}
	public String getUsu_apellidos() {
		return usu_apellidos;
	}
	public void setUsu_apellidos(String usu_apellidos) {
		this.usu_apellidos = usu_apellidos;
	}
	@Override
	public String toString() {
		return "Usuarios [usu_cedula=" + usu_cedula + ", usu_nombres=" + usu_nombres + ", usu_apellidos="
				+ usu_apellidos + "]";
	}
}
