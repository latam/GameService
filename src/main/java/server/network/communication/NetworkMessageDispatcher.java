package server.network.communication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.game.ServerManager;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NetworkMessageDispatcher {
    private final ServerManager serverManager;
}
