package server.game.instance;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractGameInstance implements Runnable {
    private final int TargetTicksPerSecond = 20;
    private final long optimalTickTime = 1000000000 / TargetTicksPerSecond;
    private long lastTickTime = System.nanoTime();

    private boolean running = true;

    @Getter
    private String name = "default";

    public AbstractGameInstance(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        log.info("Started instance - {}", name);

        long updateDuration;
        double deltaTime;

        while(running) {
            updateDuration = System.nanoTime() - lastTickTime;
            lastTickTime = System.nanoTime();

            deltaTime = updateDuration / ((double)optimalTickTime);

            this.update(deltaTime);
            threadSleep();
        }
    }

    protected abstract void update(double deltaTime);

    private void threadSleep() {
        try {
            Thread.sleep( (lastTickTime-System.nanoTime() + optimalTickTime) / 1000000);
        } catch (Exception e) {

        }
    }
}
