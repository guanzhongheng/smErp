package com.lcyzh.nmerp.utils;

import gnu.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TooManyListenersException;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/5  11:12 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/05    create
 */
public class SerialPortUtil {

    private static SerialPortUtil serialPortUtil = null;

    static {
        //在该类被ClassLoader加载时就初始化一个SerialTool对象
        if (serialPortUtil == null) {
            serialPortUtil = new SerialPortUtil();
        }
    }

    //私有化SerialTool类的构造方法，不允许其他类生成SerialTool对象
    private SerialPortUtil() {
    }

    /**
     * 获取提供服务的SerialTool对象
     *
     * @return serialPortUtil
     */
    public static SerialPortUtil getSerialPortUtil() {
        if (serialPortUtil == null) {
            serialPortUtil = new SerialPortUtil();
        }
        return serialPortUtil;
    }


    /**
     * 查找所有可用端口
     *
     * @return 可用端口名称列表
     */
    public static final ArrayList<String> findPort() {
        //获得当前所有可用串口
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();

        ArrayList<String> portNameList = new ArrayList<>();

        //将可用串口名添加到List并返回该List
        while (portList.hasMoreElements()) {
            String portName = portList.nextElement().getName();
            portNameList.add(portName);
        }

        return portNameList;
    }

    /**
     * 打开串口
     *
     * @param portName 端口名称
     * @param baudrate 波特率
     * @param databits 数据位
     * @param parity   校验位（奇偶位）
     * @param stopbits 停止位
     * @return 串口对象
     */

    public static final SerialPort openPort(String portName, int baudrate, int databits, int parity, int stopbits) throws NoSuchPortException, PortInUseException {

        //通过端口名识别端口
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);

        //打开端口，并给端口名字和一个timeout（打开操作的超时时间）
        CommPort commPort = portIdentifier.open(portName, 2000);

        //判断是不是串口
        if (commPort instanceof SerialPort) {

            SerialPort serialPort = (SerialPort) commPort;
            try {
                //设置一下串口的波特率等参数
                serialPort.setSerialPortParams(baudrate, databits, stopbits, parity);
            } catch (UnsupportedCommOperationException e) {
            }

            //System.out.println("Open " + portName + " sucessfully !");
            return serialPort;
        } else {
            //不是串口
            throw new IllegalArgumentException("不是串口");
        }
    }

    /**
     * 关闭串口
     *
     * @param serialPort 待关闭的串口对象
     */
    public static void closePort(SerialPort serialPort) {
        if (serialPort != null) {
            serialPort.close();
            serialPort = null;
        }
    }

    /**
     * 往串口发送数据
     *
     * @param serialPort 串口对象
     * @param order      待发送数据
     */
    public static void sendToPort(SerialPort serialPort, byte[] order) throws IOException {
        OutputStream out = null;
        try {
            out = serialPort.getOutputStream();
            out.write(order);
            out.flush();
        } finally {
            try {
                if (out != null) {
                    out.close();
                    out = null;
                }
            } catch (IOException e) {
            }
        }
    }

    /**
     * 从串口读取数据
     *
     * @param serialPort 当前已建立连接的SerialPort对象
     * @return 读取到的数据

     */
    public static byte[] readFromPort(SerialPort serialPort) throws IOException {

        InputStream in = null;
        byte[] bytes = null;

        try {
            in = serialPort.getInputStream();
            int bufflenth = in.available();        //获取buffer里的数据长度

            while (bufflenth != 0) {
                bytes = new byte[bufflenth];    //初始化byte数组为buffer中数据的长度
                in.read(bytes);
                bufflenth = in.available();
            }
        } finally {
            try {
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e) {
            }
        }

        return bytes;

    }

    /**
     * 添加监听器
     *
     * @param port     串口对象
     * @param listener 串口监听器
     */
    public static void addListener(SerialPort port, SerialPortEventListener listener) throws TooManyListenersException {


            //给串口添加监听器
            port.addEventListener(listener);
            //设置当有数据到达时唤醒监听接收线程
            port.notifyOnDataAvailable(true);
            //设置当通信中断时唤醒中断线程
            port.notifyOnBreakInterrupt(true);

    }

    /**
     * 删除监听器
     *
     * @param port     串口对象
     * @param listener 串口监听器
     */
    public static void removeListener(SerialPort port, SerialPortEventListener listener) {
        //删除串口监听器
        port.removeEventListener();
    }

}