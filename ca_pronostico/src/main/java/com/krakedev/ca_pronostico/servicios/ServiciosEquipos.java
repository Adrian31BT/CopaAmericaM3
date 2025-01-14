package com.krakedev.ca_pronostico.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.ca_pronostico.bdd.EquiposBDD;
import com.krakedev.ca_pronostico.entidades.Equipos;
import com.krakedev.ca_pronostico.excepciones.KrakeDevException;

@Path("equipos")
public class ServiciosEquipos {
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Equipos equipo) {
		EquiposBDD equiposBDD = new EquiposBDD();
		try {
			equiposBDD.insertar(equipo);
			return Response.ok(equiposBDD).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarPorCodigo/{equ_codigoB}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorUsuario(@PathParam("equ_codigoB") int equ_codigoB){
		EquiposBDD equiposBDD = new EquiposBDD();
		Equipos equipo = null;
		try {
			equipo = equiposBDD.recuperarPorCodigo(equ_codigoB);
			return Response.ok(equipo).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}	
	}
}
