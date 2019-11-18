package org.framework.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 *
 * netty 客户端
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-09-29 11:08
 * @Version 1.0
 */

public class TimeClient {
    public static void main(String[] args) throws Exception{
        int port = 8086;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        new TimeClient().connect(port,"127.0.0.1");
    }

    private void connect(int port, String host) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new TimeClientHandler());
                    }
                });
        //发起异步操作
        ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
        channelFuture.channel().closeFuture().sync();

    }

}
