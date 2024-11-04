package br.com.fiap.resource;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.to.ClienteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/cliente")
public class ClienteResource {
    private ClienteBO clienteBO = new ClienteBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<ClienteTO> resultado = clienteBO.findAll();
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
    @Path("/{id_cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id_cliente") Long idCliente){
        ClienteTO resultado = clienteBO.findByCodigo(idCliente);
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ClienteTO cliente) {
        ClienteTO resultado = clienteBO.save(cliente);
        if (resultado != null) {
            return Response.status(Response.Status.CREATED).entity(resultado).build(); // 201 CREATED
        } else {
            return Response.status(400).entity("Erro ao salvar cliente. Verifique os dados e tente novamente.").build();  // 400 Bad Request
        }
    }

    @DELETE
    @Path("/{id_cliente}")
    public Response delete(@PathParam("id_cliente") Long idCliente) {
        Response.ResponseBuilder response = null;
        if (clienteBO.delete(idCliente)) {
            response = Response.status(204);  // 204  NO CONTENT
        } else {
            response = Response.status(404);  // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id_cliente}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ClienteTO cliente, @PathParam("id_cliente") Long idCliente) {
        cliente.setIdCliente(idCliente);
        ClienteTO resultado = clienteBO.update(cliente);
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
