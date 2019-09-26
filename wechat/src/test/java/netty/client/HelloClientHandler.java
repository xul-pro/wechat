package netty.client;

import org.apache.log4j.Logger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class HelloClientHandler extends SimpleChannelInboundHandler<String> {
	
	private static Logger log = Logger.getLogger(HelloClientHandler.class);
	
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("Server say : " + msg);
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       log.info("Client active ");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("Client close ");
        super.channelInactive(ctx);
    }
}
