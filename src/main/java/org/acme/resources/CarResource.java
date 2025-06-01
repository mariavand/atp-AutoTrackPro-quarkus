package org.acme.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entities.Car;

import java.util.List;

//Active Record Pattern
@Path("/api/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {
    @GET
    @Path("{id}")
    public Car findCarById(@PathParam("id") Long id){
        return (Car) Car.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }
    @GET
    public List<Car> listAllCars(){
        return Car.listAll();
    }

}
