package com.krakedev.ca_pronostico.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.ca_pronostico.entidades.Equipos;
import com.krakedev.ca_pronostico.entidades.Partidos;
import com.krakedev.ca_pronostico.excepciones.KrakeDevException;
import com.krakedev.ca_pronostico.utils.ConexionBDD;

public class PartidosBDD {
	public Partidos recuperarPorCodigo(int par_codigoB) throws KrakeDevException{

		Connection con = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		Partidos partido = null;
		Equipos equipo1 = null;
		Equipos equipo2 = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select par.par_codigo, par.equ_codigo1, equ1.equ_iso as equ_iso1, equ1.equ_nombre as equ_nombre1, par.equ_codigo2, equ2.equ_iso as equ_iso2, equ2.equ_nombre as equ_nombre2, par.par_fecha, par.par_hora \r\n"
					+ "from partidos par\r\n"
					+ "inner join equipos equ1 on par.equ_codigo1 = equ1.equ_codigo\r\n"
					+ "inner join equipos equ2 on par.equ_codigo2 = equ2.equ_codigo"
					+ "where par.par_codigo=?");
			ps.setInt(1, par_codigoB);
			rs = ps.executeQuery();		
			if(rs.next()) {
				
				int par_codigo = rs.getInt("par_codigo");
				
				int equ_codigo1 = rs.getInt("equ_codigo1");
				String equ_iso1 = rs.getString("equ_iso1");
				String equ_nombre1 = rs.getString("equ_nombre1");
				
				int equ_codigo2 = rs.getInt("equ_codigo2");
				String equ_iso2 = rs.getString("equ_iso2");
				String equ_nombre2 = rs.getString("equ_nombre2");
				
				equipo1 = new Equipos();
				equipo1.setEqu_codigo(equ_codigo1);
				equipo1.setEqu_iso(equ_iso1);
				equipo1.setEqu_nombre(equ_nombre1);
				
				equipo2 = new Equipos();
				equipo2.setEqu_codigo(equ_codigo2);
				equipo2.setEqu_iso(equ_iso2);
				equipo2.setEqu_nombre(equ_nombre2);
				
				Date par_fecha = rs.getDate("par_fecha");
				Time par_hora = rs.getTime("par_hora");
				
				partido = new Partidos(par_codigo, equipo1, equipo2, par_fecha, par_hora);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar partidos, detalle: "+e.getMessage());
		}
		
		return partido;
	}
	
	public ArrayList<Partidos> recuperarPartidos() throws KrakeDevException{

		Connection con = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		Partidos partido = null;
		Equipos equipo1 = null;
		Equipos equipo2 = null;
		
		ArrayList<Partidos> partidos = new ArrayList<Partidos>();
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select par.par_codigo, par.equ_codigo1, equ1.equ_iso as equ_iso1, equ1.equ_nombre as equ_nombre1, par.equ_codigo2, equ2.equ_iso as equ_iso2, equ2.equ_nombre as equ_nombre2, par.par_fecha, par.par_hora \r\n"
					+ "from partidos par\r\n"
					+ "inner join equipos equ1 on par.equ_codigo1 = equ1.equ_codigo\r\n"
					+ "inner join equipos equ2 on par.equ_codigo2 = equ2.equ_codigo");
			rs = ps.executeQuery();		
			while(rs.next()) {
				
				int par_codigo = rs.getInt("par_codigo");
				
				int equ_codigo1 = rs.getInt("equ_codigo1");
				String equ_iso1 = rs.getString("equ_iso1");
				String equ_nombre1 = rs.getString("equ_nombre1");
				
				int equ_codigo2 = rs.getInt("equ_codigo2");
				String equ_iso2 = rs.getString("equ_iso2");
				String equ_nombre2 = rs.getString("equ_nombre2");
				
				equipo1 = new Equipos();
				equipo1.setEqu_codigo(equ_codigo1);
				equipo1.setEqu_iso(equ_iso1);
				equipo1.setEqu_nombre(equ_nombre1);
				
				equipo2 = new Equipos();
				equipo2.setEqu_codigo(equ_codigo2);
				equipo2.setEqu_iso(equ_iso2);
				equipo2.setEqu_nombre(equ_nombre2);
				
				Date par_fecha = rs.getDate("par_fecha");
				Time par_hora = rs.getTime("par_hora");
				
				
				partido = new Partidos(par_codigo, equipo1, equipo2, par_fecha, par_hora);
				partidos.add(partido);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar partidos, detalle: "+e.getMessage());
		}
		
		return partidos;
	}
}