package server.network.communication.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractEvent {
    private EventType type;

    public AbstractEvent(EventType type) {
        this.type = type;
    }
}
