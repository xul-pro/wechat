package netty.server;


import org.apache.log4j.Logger;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyHelloServer {
	
	private static Logger log = Logger.getLogger(NettyHelloServer.class);
	/**
	 * 服务端监听的端口地址
	 */
	private static final int portNumber = 7878;

	public static void main(String[] args) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup);
			b.channel(NioServerSocketChannel.class); 
			b.childHandler(new HelloServerInitializer());

			ChannelFuture f = b.bind(portNumber).sync();      // 服务器绑定端口监听
			f.channel().closeFuture().sync();                // 监听服务器关闭监听

			// 可以简写为
			/* b.bind(portNumber).sync().channel().closeFuture().sync(); */
		} catch (Exception e) {
			log.error("系统异常", e);
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
