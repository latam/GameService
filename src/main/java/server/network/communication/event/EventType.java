package server.network.communication.event;

import lombok.Getter;

public enum EventType {
    JOIN_EVENT(0);


    EventType(int id) {
        this.id = id;
    }

    @Getter
    private int id;
}
