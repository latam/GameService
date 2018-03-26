package server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import server.network.communication.BaseMessage;
import server.network.communication.UpdatePositionMessage;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class RepeatTask implements Runnable {
    private static RepeatTask instance;
    public static RepeatTask getInstance() {
        if(instance == null) {
            instance = new RepeatTask();
        }
        return instance;
    }

    private ChannelGroup channels;
    private Random random;
    private List<TestObject> objects;

    private RepeatTask() {
        this.channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
        objects = new CopyOnWriteArrayList<TestObject>();
        random = new Random();
    }

    public void run() {
        float angle = 0;

        while(true) {
            System.out.println("Repeat task " + LocalTime.now().toString());

            for(TestObject object : objects) {

                object.positionX = random.nextInt(5);
                object.positionY = random.nextInt(5);

                BaseMessage message = new BaseMessage();
                message.setId(random.nextInt(100) + 1);
                message.setMessageType(1);

                ObjectMapper objectMapper = new ObjectMapper();
                String subMessage = "";
                try {
                    UpdatePositionMessage updatePositionMessage = new UpdatePositionMessage(object.objectId, object.positionX, object.positionY);
                    subMessage = objectMapper.writeValueAsString(updatePositionMessage);
                } catch (JsonProcessingException e) {
                    System.out.println(e.getMessage());
                }

                message.setMessage(subMessage);

                for (Channel channel : channels) {
                    if (channel.isActive()) {
                        System.out.println("Sent to [" + channel.remoteAddress() + "] - " + message.toString());
                        channel.writeAndFlush(message);
                    }
                }
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                }
            }
        }
    }

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }

    public void removeChannel(Channel channel) {
        this.channels.remove(channel);
    }
}