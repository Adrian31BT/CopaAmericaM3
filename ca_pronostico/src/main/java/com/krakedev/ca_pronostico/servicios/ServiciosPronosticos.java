package com.krakedev.ca_pronostico.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.ca_pronostico.bdd.PronosticosDBB;
import com.krakedev.ca_pronostico.entidades.Pronosticos;
import com.krakedev.ca_pronostico.excepciones.KrakeDevException;



@Path("pronosticos")
public class ServiciosPronosticos {
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Pronosticos pronostico) {
		PronosticosDBB pronosticosDBB = new PronosticosDBB();
		try {
			pronosticosDBB.insertar(pronostico);
			return Response.ok(pronosticosDBB).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarPorUsuario/{cedula}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorUsuario(@PathParam("cedula") String usu_cedulaB){
		PronosticosDBB pronosticosDBB = new PronosticosDBB();
		ArrayList<Pronosticos> pronosticos = null;
		try {
			pronosticos = pronosticosDBB.buscarPorUsuario(usu_cedulaB);
			return Response.ok(pronosticos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}	
	}
}