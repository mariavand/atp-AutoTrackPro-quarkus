package org.acme.resources;

import io.quarkus.security.Authenticated;
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

            existingCar.owner_name_surname = updatedCar.owner_name_surname;
            existingCar.serial_number = updatedCar.serial_number;
            existingCar.software_version = updatedCar.software_version;
            existingCar.tech_comments = updatedCar.tech_comments;
            existingCar.buying_day = updatedCar.buying_day;
            existingCar.edited_by = updatedCar.edited_by;
            existingCar.last_update_date = updatedCar.last_update_date;
            existingCar.locked_by = updatedCar.locked_by;
            existingCar.general_comments = updatedCar.general_comments;
            existingCar.sales_comments = updatedCar.sales_comments;
            existingCar.battery_change_date = updatedCar.battery_change_date;
            existingCar.payment_status = updatedCar.payment_status;
            existingCar.final_price = updatedCar.final_price;
            existingCar.initial_price = updatedCar.initial_price;
            existingCar.air_conditioning = updatedCar.air_conditioning;
            existingCar.fuel_type = updatedCar.fuel_type;
            existingCar.seats = updatedCar.seats;
            existingCar.transmission = updatedCar.transmission;
            existingCar.bluetooth = updatedCar.bluetooth;
            existingCar.status = updatedCar.status;
            existingCar.color = updatedCar.color;

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
