package br.com.fiap.resource;

import br.com.fiap.bo.CarroBO;
import br.com.fiap.to.CarroTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/carro")
public class CarroResource {
    private CarroBO carroBO = new CarroBO();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<CarroTO> resultado = carroBO.findAll();
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
    @Path("/{id_carro}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id_carro") Long idCarro){
        CarroTO resultado = carroBO.findByCodigo(idCarro);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/cliente/{id_cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigoCliente(@PathParam("id_cliente") Long idCliente){
        CarroTO resultado = carroBO.findByCodigoCliente(idCliente);
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
    public Response save(@Valid CarroTO carro){
        CarroTO resultado = carroBO.save(carro);
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
    @Path("/{id_carro}")
    public Response delete(@PathParam("id_carro") Long idCarro) {
        Response.ResponseBuilder response = null;
        if (carroBO.delete(idCarro)) {
            response = Response.status(204);  // 204  NO CONTENT
        } else {
            response = Response.status(404);  // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id_carro}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid CarroTO carro, @PathParam("id_carro") Long idCarro) {
        carro.setIdCarro(idCarro);
        CarroTO resultado = carroBO.update(carro);
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
