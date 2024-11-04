package br.com.fiap.resource;

import br.com.fiap.bo.TiposServicoBO;
import br.com.fiap.to.TiposServicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/servico")
public class TiposServicoResource {
    private TiposServicoBO tiposServicoBO = new TiposServicoBO();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<TiposServicoTO> resultado = tiposServicoBO.findAll();
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
    @Path("/{id_servico}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id_servico") Long idServico){
        TiposServicoTO resultado = tiposServicoBO.findByCodigo(idServico);
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
    public Response save(@Valid TiposServicoTO tiposServico){
        TiposServicoTO resultado = tiposServicoBO.save(tiposServico);
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
    @Path("/{id_servico}")
    public Response delete(@PathParam("id_servico") Long idServico) {
        Response.ResponseBuilder response = null;
        if (tiposServicoBO.delete(idServico)) {
            response = Response.status(204);  // 204  NO CONTENT
        } else {
            response = Response.status(404);  // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id_servico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid TiposServicoTO tiposServico, @PathParam("id_servico") Long idServico) {
        tiposServico.setIdServico(idServico);
        TiposServicoTO resultado = tiposServicoBO.update(tiposServico);
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
