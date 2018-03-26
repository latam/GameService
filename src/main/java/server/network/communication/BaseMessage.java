package server.network.communication;

public class BaseMessage {
    private int id;
    private int messageType;
    private String message;

    public BaseMessage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseMessage{" +
                "id=" + id +
                ", messageType=" + messageType +
                ", server.network.communication='" + message + '\'' +
                '}';
    }
}
