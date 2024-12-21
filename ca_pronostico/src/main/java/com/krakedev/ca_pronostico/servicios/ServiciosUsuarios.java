package com.krakedev.ca_pronostico.servicios;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.ca_pronostico.bdd.UsuariosBDD;
import com.krakedev.ca_pronostico.entidades.Usuarios;
import com.krakedev.ca_pronostico.excepciones.KrakeDevException;

@Path("usuarios")
public class ServiciosUsuarios {
	@Path("buscarPorCedula/{cedula}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorUsuario(@PathParam("cedula") String usu_cedulaB){
		UsuariosBDD usuariosBDD = new UsuariosBDD();
		Usuarios usuario = null;
		try {
			usuario = usuariosBDD.recuperarPorCedula(usu_cedulaB);
			return Response.ok(usuario).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}	
	}
}
