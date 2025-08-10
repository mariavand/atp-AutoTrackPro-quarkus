package org.acme.resources;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entities.History;

import java.util.List;

import static java.lang.System.out;

@Path("/api/history")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoryResource {
    @GET
    @Path("{id}")
    public List<History> findHistoryById(@PathParam("id") Long id){
        return History.findAllByCarId(id);
    }
    @GET
    public List<History> listAllHistory(){
        return History.listAll();
    }

    @POST
    @Transactional
    public Response createHistory(History history){
        out.println("The car is: " + history);
        History.persist(history);

//        CarLockingSocketResource.onMessage(CarLockingSocketResource.MessageType.CAR_UNLOCKED);

        return Response.status(Response.Status.CREATED).entity(history).build();
    }
}
