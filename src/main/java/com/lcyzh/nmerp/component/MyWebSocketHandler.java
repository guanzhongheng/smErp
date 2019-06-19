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
    private static final ExecutorService singleExe = Executors.newSingleThreadExecutor();
    private final Task task;
    private final SerialPortUtils serialPortUtils;
    private static volatile boolean stop = false;


    public MyWebSocketHandler() {
        serialPortUtils = new SerialPortUtils();
        task = new Task();
        singleExe.submit(task);
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
        if (msg.equals("suspend")) {
            stop=false;
        }else if (msg.equals("start")){
            // 创建串口必要参数接收类并赋值，赋值串口号，波特率，校验位，数据位，停止位
            ParamConfig paramConfig = new ParamConfig("COM1", 9600, 0, 8, 1);
            serialPortUtils.init(paramConfig);
            stop=true;
        }else if(msg.equals("stop")){
            serialPortUtils.closeSerialPort();
        }
    }



    class Task implements Runnable {

        @Override
        public void run() {
            while (stop) {
                //把收到的电子秤信息发给前端
                MyChannelHandlerPool.channelGroup.writeAndFlush(new TextWebSocketFrame(serialPortUtils.getData()));
            }
        }
    }
}