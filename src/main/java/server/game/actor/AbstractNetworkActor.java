package server.game.actor;

public abstract class AbstractNetworkActor implements NetworkActor {
    public Long id;

    public float positionX;
    public float positionY;
    public float positionZ;

    public abstract void update(float dt);
}
