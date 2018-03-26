package server.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.game.PlayerSession;
import server.game.ServerManager;
import server.network.communication.BaseMessage;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServerChannelHandler extends SimpleChannelInboundHandler<BaseMessage> {
    private final ServerManager serverManager;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {
        log.debug("Opened connection with {}", ctx.channel().remoteAddress());
        PlayerSession session = new PlayerSession(ctx.channel());
        serverManager.addSession(session);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, BaseMessage msg) {
        log.debug("Received communication from {} - {}", ctx.channel().remoteAddress(), msg.toString());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.debug("Closed connection with {}", ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}