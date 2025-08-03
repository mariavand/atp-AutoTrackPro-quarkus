package org.acme.resources;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entities.Car;

import java.util.List;
import java.util.Optional;

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

    @POST
    @Transactional
    public Response createCar(Car car){
        System.out.println("The car is: " + car);
        Car.persist(car);

//        CarLockingSocketResource.onMessage(CarLockingSocketResource.MessageType.CAR_UNLOCKED);

        return Response.status(Response.Status.CREATED).entity(car).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateCar(@PathParam("id") Long id, Car updatedCar){
        Optional<Car> carOptional = Car.findByIdOptional(id);

        if(carOptional.isPresent()){
            Car existingCar = carOptional.get();
            return Response.ok(existingCar).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }



    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCar(@PathParam("id") Long id){
        boolean deleted = Car.deleteById(id);
        if (deleted) {
//            CarLockingSocketResource.broadcast("Car deleted: ID " + id);
            return Response.noContent().build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build(); // 404 Not Found
        }
    }

}
