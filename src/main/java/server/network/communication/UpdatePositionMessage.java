package server.network.communication;

public class UpdatePositionMessage {
    public int objectId;
    public float positionX;
    public float positionY;

    public UpdatePositionMessage(int objectId, float positionX, float positionY) {
        this.objectId = objectId;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
