package server.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.game.instance.GameInstanceHandler;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServerManager {
    private final GameInstanceHandler instanceHandler;

    @Getter
    private Set<PlayerSession> sessions = new HashSet<>();

    public void addSession(PlayerSession session) {
        log.debug("Session {} registered", session.getId());
        sessions.add(session);
    }

    public void removeSession() {

    }
}
