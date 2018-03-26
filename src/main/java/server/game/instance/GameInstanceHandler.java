package server.game.instance;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameInstanceHandler {
    private Map<String, GameInstance> instances;
    private Map<String, Thread> instanceThreads;

    public GameInstanceHandler() {
        instances = new HashMap<>();
        instanceThreads = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            GameInstance instance = new GameInstance("Instance" + i);
            instances.putIfAbsent(instance.getName(), instance);
            instanceThreads.putIfAbsent(instance.getName(), new Thread(instance));
        }
    }

    public void startAllInstances() {
        instanceThreads.values().forEach(thread -> thread.start());
    }
}
