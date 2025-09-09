package org.acme.resources;

import io.quarkus.websockets.next.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.entities.Car;

import java.util.Optional;

@WebSocket(path = "/carSocket/")
public class CarLockingSocketResource {

    public enum MessageType {CAR_LOCKED, CAR_UNLOCKED, OPEN_CONNECTION, CLOSE_CONNECTION}
    public record CarLockingMessage(MessageType type, String email, boolean locked, Integer carId) {
    }

    @Inject
    WebSocketConnection connection;

    @OnOpen(broadcast = false)
    public CarLockingMessage onOpen(){

        return new CarLockingMessage(MessageType.OPEN_CONNECTION, null, false, null);
    }

    @OnClose
    public void onClose() {
        CarLockingMessage departure = new CarLockingMessage(MessageType.CLOSE_CONNECTION, null, false, null);
        connection.broadcast().sendTextAndAwait(departure);
    }

    @Transactional
    @OnTextMessage(broadcast = true)
    public CarLockingMessage onMessage(CarLockingMessage msg) {
        System.out.println(msg);

        if(msg.type == MessageType.CAR_LOCKED){
            Optional<Car> carOptional = Car.findByIdOptional(msg.carId);
            if(carOptional.isPresent()){
                Car existingCar = carOptional.get();

                existingCar.locked_by = msg.email;

                System.out.println("locking in progress");
            }
        } else if (msg.type == MessageType.CAR_UNLOCKED) {
            Optional<Car> carOptional = Car.findByIdOptional(msg.carId);
            if(carOptional.isPresent()){
                Car existingCar = carOptional.get();
                existingCar.locked_by = "";
            }

            System.out.println("unlocking in progress");
        }

        return msg;
    }
}
