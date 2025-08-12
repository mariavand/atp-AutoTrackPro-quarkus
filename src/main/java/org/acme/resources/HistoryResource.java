package org.acme.resources;

import io.quarkus.security.Authenticated;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entities.History;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;

import static java.lang.System.out;

@Path("/api/history")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class HistoryResource {

    @Inject
    JsonWebToken jwt;
    @GET
    @Authenticated
    @Path("{id}")
    public List<History> findHistoryById(@PathParam("id") Long id){
        return History.findAllByCarId(id);
    }
    @GET
    @Authenticated
    public List<History> listAllHistory(){
        return History.listAll();
    }

    @POST
    @Authenticated
    @Transactional
    public Response createHistory(History history){
        out.println("The car is: " + history);
        History.persist(history);

//        CarLockingSocketResource.onMessage(CarLockingSocketResource.MessageType.CAR_UNLOCKED);

        return Response.status(Response.Status.CREATED).entity(history).build();
    }

    @DELETE
    @Authenticated
    @Path("/{id}")
    @Transactional
    public Response deleteCarHistory(@PathParam("id") Long id){
        Long deleted = History.deleteAllByCarId(id);
        if (deleted > 0) {
            return Response.noContent().build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build(); // 404 Not Found
        }
    }
}
