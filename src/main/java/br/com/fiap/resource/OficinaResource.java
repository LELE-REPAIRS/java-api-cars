package br.com.fiap.resource;

import br.com.fiap.bo.OficinaBO;
import br.com.fiap.to.OficinaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/oficina")
public class OficinaResource {
    private OficinaBO oficinaBO = new OficinaBO();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<OficinaTO> resultado = oficinaBO.findAll();
        Response.ResponseBuilder response = null;
        if (response != null){
            response = Response.ok(); // 200 (Ok)
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
    @GET
    @Path("/{id_oficina}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id_oficina") Long idOficina){
        OficinaTO resultado = oficinaBO.findByCodigo(idOficina);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid OficinaTO oficina){
        OficinaTO resultado = oficinaBO.save(oficina);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        }else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id_oficina}")
    public Response delete(@PathParam("id_oficina") Long idOficina) {
        Response.ResponseBuilder response = null;
        if (oficinaBO.delete(idOficina)) {
            response = Response.status(204);  // 204  NO CONTENT
        } else {
            response = Response.status(404);  // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id_oficina}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid OficinaTO oficina, @PathParam("id_oficina") Long idOficina) {
        oficina.setIdOficina(idOficina);
        OficinaTO resultado = oficinaBO.update(oficina);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);  // 201 CREATED
        } else {
            response = Response.status(400);  // 400 BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }
}
