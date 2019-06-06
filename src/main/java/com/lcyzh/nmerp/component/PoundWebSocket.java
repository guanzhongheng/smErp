package com.lcyzh.nmerp.component;

import com.lcyzh.nmerp.utils.SerialPortUtil;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/5  10:35 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/05    create
 */
@ServerEndpoint(value = "/websocket")
@Component
public class PoundWebSocket {
    private Logger LOGGER = LoggerFactory.getLogger(PoundWebSocket.class);

    /**
     * @Description: 保存所有在线socket连接
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:40 AM
     */
    private static Map<String, PoundWebSocket> webSocketMap = new LinkedHashMap<>();
    /**
     * @Description: 记录当前在线数目
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:42 AM
     */
    private static int count = 0;
    /**
     * @Description: 当前连接（每个webSocket连入都会创建一个MyWebSocket实例）
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:44 AM
     */
    private Session session;

    /**
     * @Description: 创建监听串口
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:47 AM
     */
    private static SerialPort serialPort;
    /**
     * @Description: 创建监听器
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:48 AM
     */
    private static SerialPortEventListener serialPortEventListener;
    /**
     * @Description: 监听串口
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:49 AM
     */
    private static String PORT_NAME;
    /**
     * @Description: 监听串口波特率
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:50 AM
     */
    private static int BAUD_RATE;
    /**
     * @Description: 数据位
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:51 AM
     */
    private static int DATA_BITS;

    /**
     * @Description: 停止位
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:52 AM
     */
    private static int STOP_BITS;

    /**
     * @Description: 奇偶位
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:53 AM
     */
    private static int PARITY;
    /**
     * @Description: 地磅型号
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/5 10:54 AM
     */
    private static String MODEL;


    /**
     * 处理连接建立
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        PORT_NAME = "com1Listener";
        BAUD_RATE = 2000;
        MODEL = "COM1";
        DATA_BITS = SerialPort.DATABITS_8;
        STOP_BITS = SerialPort.STOPBITS_1;
        PARITY = SerialPort.PARITY_NONE;

        this.session = session;
        webSocketMap.put(session.getId(), this);
        addCount();
//        logger.info("新的连接加入：{}", session.getId());
        try {
            //确保串口已被关闭，未关闭会导致重新监听串口失败
            if (serialPort != null) {
                SerialPortUtil.closePort(serialPort);
                serialPort = null;
            }
            //创建串口 COM5位串口名称 9600波特率
            if (serialPort == null && StringUtils.isNotEmpty(PORT_NAME) && StringUtils.isNotEmpty(MODEL)) {
                serialPort = SerialPortUtil.openPort(PORT_NAME, BAUD_RATE, DATA_BITS, PARITY, STOP_BITS);
//                logger.info("创建串口：{}", serialPort);
                //设置串口监听
                SerialPortUtil.addListener(serialPort, new SerialPortEventListener() {

                    @Override
                    public void serialEvent(SerialPortEvent serialPortEvent) {
                        if (serialPortEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                            try {
                                //读取串口数据
                                byte[] bytes = SerialPortUtil.readFromPort(serialPort);
                                //根据型号解析字符串
                                parsingString2(bytes);
                                System.out.println("收到的数据：" + new String(bytes, "GB2312") + "----" + new Date());

                            } catch (IOException e) {
                                LOGGER.error(e.toString());
                            }
                        }
                    }
                });
            }
        } catch (Exception ex) {
            LOGGER.error(ex.toString());
        }
    }

    /**
     * 解析字符串 方法1
     *
     * @param bytes 获取的字节码
     */
    private void parsingString1(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        //将ASCII码转成字符串
        for (int i = 0; i < bytes.length; i++) {
            sb.append((char) Integer.parseInt(String.valueOf(bytes[i])));
        }

        //解析字符串
        String[] strs = sb.toString().trim().split("\\+");
        int weight = 0;
        for (int j = 0; j < strs.length; j++) {
            if (strs[j].trim().length() >= 6) {
                weight = Integer.parseInt(strs[j].trim().substring(0, 6));
                //发送数据
                sendMessageToAll(String.valueOf(weight));
                break;
            }
        }
    }

    /**
     * 解析字符串 方法2
     *
     * @param bytes 获取的字节码
     */
    private void parsingString2(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        //将ASCII码转成字符串
        for (int i = 0; i < bytes.length; i++) {
            sb.append((char) Integer.parseInt(String.valueOf(bytes[i])));
        }
        //解析字符串
        String[] strs = sb.toString().trim().split("\\+");
        double weight = 0;
        for (int j = 0; j < strs.length; j++) {
            if (strs[j].trim().length() >= 6) {
                weight = Double.parseDouble(strs[j].trim().substring(0, 6)) / 10;
                //发送数据
                sendMessageToAll(String.valueOf(weight));
                break;
            }
        }
    }

    /**
     * 解析字符串 方法3
     *
     * @param bytes 获取的字节码
     */
    private void parsingString3(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        //将ASCII码转成字符串
        for (int i = 0; i < bytes.length; i++) {
            sb.append((char) Integer.parseInt(String.valueOf(bytes[i])));
        }

//        logger.info("sb:" + sb.toString());
        sb.reverse();

        //解析字符串
        String[] strs = sb.toString().trim().split("\\=");
        double weight = 0;
        for (int j = 0; j < strs.length; j++) {
            if (strs[j].trim().length() >= 6) {
                weight = Double.parseDouble(strs[j].trim());
                //发送数据
                sendMessageToAll(String.valueOf(weight));
                break;
            }
        }
    }

    /**
     * 解析字符串 方法3
     *
     * @param bytes 获取的字节码
     */
    private void parsingString4(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        //将ASCII码转成字符串
        for (int i = 0; i < bytes.length; i++) {
            sb.append((char) Integer.parseInt(String.valueOf(bytes[i])));
        }

//        logger.info("sb:" + sb.reverse());
        //字符串反转
        sb.reverse();

        //解析字符串
        String[] strs = sb.toString().trim().split("\\=");
        int weight = 0;
        for (int j = 0; j < strs.length; j++) {
            if (strs[j].trim().length() >= 6) {
                weight = Integer.parseInt(strs[j].trim().substring(0, 6));
                //发送数据
                sendMessageToAll(String.valueOf(weight));
                break;
            }
        }
    }

    /**
     * 接受消息
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        LOGGER.info("收到客户端{}消息：{}", session.getId(), message);
        try {
            this.sendMessage(message);
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
    }

    /**
     * 处理错误
     *
     * @param error
     * @param session
     */
    @OnError
    public void onError(Throwable error, Session session) {
        LOGGER.info("发生错误{},{}", session.getId(), error.getMessage());
    }

    /**
     * 处理连接关闭
     */
    @OnClose
    public void onClose() {
        webSocketMap.remove(this.session.getId());
        reduceCount();
        LOGGER.info("连接关闭:{}", this.session.getId());

        //连接关闭后关闭串口，下一次打开连接重新监听串口
        if (serialPort != null) {
            SerialPortUtil.closePort(serialPort);
            serialPort = null;
        }
    }

    /**
     * 群发消息
     *
     * @param message
     */
    public void sendMessageToAll(String message) {
        for (int i = 0; i < webSocketMap.size(); i++) {
            try {
//                logger.info("session:id=" + session.getId());
                this.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    /**
     * 发送消息
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
//        logger.info("session:id=" + session.getId());
        this.session.getBasicRemote().sendText(message);
    }

    //广播消息
    public static void broadcast() {
        PoundWebSocket.webSocketMap.forEach((k, v) -> {
            try {
                v.sendMessage("这是一条测试广播");
            } catch (Exception e) {
            }
        });
    }

    //获取在线连接数目
    public static int getCount() {
        return count;
    }

    //操作count，使用synchronized确保线程安全
    public static synchronized void addCount() {
        PoundWebSocket.count++;
    }

    public static synchronized void reduceCount() {
        PoundWebSocket.count--;
    }
}