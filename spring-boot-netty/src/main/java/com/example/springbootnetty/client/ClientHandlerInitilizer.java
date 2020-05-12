package com.example.springbootnetty.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/9
 * \* Time: 11:24
 * \* Description:
 * \
 */
public class ClientHandlerInitilizer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel channel) throws Exception {


        channel.pipeline()
                .addLast(new StringDecoder())
                .addLast(new StringEncoder())
                .addLast(new NettyClientHandler());

    }
}
