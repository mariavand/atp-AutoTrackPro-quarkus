package org.acme.resources;

import io.quarkus.websockets.next.*;
import jakarta.inject.Inject;

@WebSocket(path = "/carSocket/")
public class CarLockingSocketResource {

    public enum MessageType {CAR_LOCKED, CAR_UNLOCKED, OPEN_CONNECTION, CLOSE_CONNECTION}
    public record CarLockingMessage(MessageType type, String message) {
    }

    @Inject
    WebSocketConnection connection;

    @OnOpen(broadcast = true)
    public CarLockingMessage onOpen(){
        return new CarLockingMessage(MessageType.OPEN_CONNECTION, null);
    }

    @OnClose
    public void onClose() {
        CarLockingMessage departure = new CarLockingMessage(MessageType.CLOSE_CONNECTION, null);
        connection.broadcast().sendTextAndAwait(departure);
    }

    @OnTextMessage(broadcast = true)
    public CarLockingMessage onMessage(CarLockingMessage message) {
        return message;
    }
}
