package org.acme.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entities.History;

import java.util.List;

@Path("/api/history")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoryResource {
    @GET
    @Path("{id}")
    public History findHistoryById(@PathParam("id") Long id){
        return (History) History.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }
    @GET
    public List<History> listAllHistory(){
        return History.listAll();
    }
}
