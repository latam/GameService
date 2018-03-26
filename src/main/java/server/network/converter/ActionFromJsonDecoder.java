package server.network.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import server.network.communication.BaseMessage;

import java.util.List;

@Sharable
public class ActionFromJsonDecoder extends MessageToMessageDecoder<ByteBuf> {
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        byte[] msgBytes = new byte[byteBuf.capacity()];
        byteBuf.getBytes(0, msgBytes);
        BaseMessage baseMessage = objectMapper.readValue(msgBytes, BaseMessage.class);

        list.add(baseMessage);
    }
}
