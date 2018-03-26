package server.network.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import server.network.communication.BaseMessage;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;

@Sharable
public class ActionToJsonEncoder extends MessageToMessageEncoder<BaseMessage> {
    private final Charset charset;

    public ActionToJsonEncoder() {
        this(Charset.defaultCharset());
    }

    public ActionToJsonEncoder(Charset charset) {
        if(charset == null) {
            throw new NullPointerException("charset");
        } else {
            this.charset = charset;
        }
    }

    protected void encode(ChannelHandlerContext channelHandlerContext, BaseMessage baseMessage, List<Object> list) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = objectMapper.writeValueAsString(baseMessage);

        if(jsonMessage.length() != 0) {
            list.add(ByteBufUtil.encodeString(channelHandlerContext.alloc(), CharBuffer.wrap(jsonMessage), this.charset));
        }
    }
}
