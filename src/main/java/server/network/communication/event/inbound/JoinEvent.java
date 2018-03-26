package server.network.communication.event.inbound;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.network.communication.event.AbstractEvent;
import server.network.communication.event.EventType;

@NoArgsConstructor
@Getter
@Setter
public class JoinEvent extends AbstractEvent {
    private long characterId;

    public JoinEvent(long characterId) {
        super(EventType.JOIN_EVENT);
        this.characterId = characterId;
    }
}
