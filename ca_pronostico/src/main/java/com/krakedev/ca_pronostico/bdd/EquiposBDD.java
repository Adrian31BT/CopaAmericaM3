package com.krakedev.ca_pronostico.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.krakedev.ca_pronostico.entidades.Equipos;
import com.krakedev.ca_pronostico.excepciones.KrakeDevException;
import com.krakedev.ca_pronostico.utils.ConexionBDD;


public class EquiposBDD {
	public void insertar(Equipos equipo) throws KrakeDevException{
		Connection con = null; 
		PreparedStatement ps = null;
	
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into equipos(equ_codigo, equ_iso, equ_nombre) values (?,?,?)");
			ps.setInt(1, equipo.getEqu_codigo());
			ps.setString(2, equipo.getEqu_iso());
			ps.setString(3, equipo.getEqu_nombre());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new KrakeDevException("Error al insertar equipos, detalle: "+e.getMessage());
		} catch (KrakeDevException e) {
			throw e;
		} finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Equipos recuperarPorCodigo(int equ_codigoB) throws KrakeDevException{

		Connection con = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		Equipos equipo = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select equ_codigo, equ_iso, equ_nombre from equipos where equ_codigo = ?");
			ps.setInt(1, equ_codigoB);
			rs = ps.executeQuery();		
			if(rs.next()) {
				
				int equ_codigo = rs.getInt("equ_codigo");
				String equ_iso = rs.getString("equ_iso");
				String equ_nombre = rs.getString("equ_nombre");
				
				equipo = new Equipos(equ_codigo, equ_iso, equ_nombre);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar equipos, detalle: "+e.getMessage());
		}
		
		return equipo;
	}
}
