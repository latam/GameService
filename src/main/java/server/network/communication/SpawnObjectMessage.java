package server.network.communication;

public class SpawnObjectMessage {
    private Long objectId;
    private float positionX;
    private float positionY;
    private float positionZ;

    public SpawnObjectMessage() {
    }

    public SpawnObjectMessage(Long objectId, float positionX, float positionY, float positionZ) {
        this.objectId = objectId;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(float positionZ) {
        this.positionZ = positionZ;
    }
}
