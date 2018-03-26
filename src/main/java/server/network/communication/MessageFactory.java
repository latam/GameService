package server.network.communication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.game.actor.PlayerActor;

public class MessageFactory {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static BaseMessage spawnPlayerMessage(PlayerActor playerActor) {
        BaseMessage message = new BaseMessage();
        message.setId(0);
        message.setMessageType(0);

        String subMessage = "";
        try {
            SpawnObjectMessage spawnObjectMessage = new SpawnObjectMessage(playerActor.id, playerActor.positionX, playerActor.positionY, playerActor.positionZ);
            subMessage = objectMapper.writeValueAsString(spawnObjectMessage);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        message.setMessage(subMessage);

        return message;
    }
}
