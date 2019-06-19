package com.lcyzh.nmerp.component;

import com.lcyzh.nmerp.configuration.ParamConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/17  2:13 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/17    create
 */
public class MyWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private final SerialPortUtils serialPortUtils;
    public MyWebSocketHandler() {
        serialPortUtils = new SerialPortUtils();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！");
        MyChannelHandlerPool.channelGroup.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端断开连接，通道关闭！");
        MyChannelHandlerPool.channelGroup.remove(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame msg) throws Exception {
        System.out.println("客户端收到服务器数据：" + msg.text());
        //收到服务端数据，进行对应操作
        if (msg.text().equals("suspend")) {
            serialPortUtils.setSuspend(true);
        }else if (msg.text().equals("start")){
            // 创建串口必要参数接收类并赋值，赋值串口号，波特率，校验位，数据位，停止位
            if(!serialPortUtils.isOpen()){
                ParamConfig paramConfig = new ParamConfig("COM1", 9600, 0, 8, 1);
                serialPortUtils.init(paramConfig);
            }else{
                serialPortUtils.setSuspend(false);
            }
        }else if(msg.text().equals("stop")){
            serialPortUtils.closeSerialPort();
        }
    }

}