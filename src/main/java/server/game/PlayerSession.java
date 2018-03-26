package server.game;

import io.netty.channel.Channel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.game.actor.PlayerActor;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlayerSession {
    private String id;
    private Channel channel;
    private PlayerActor actor;

    public PlayerSession(Channel channel) {
        this.channel = channel;
        id = UUID.randomUUID().toString();
    }
}
