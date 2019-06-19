package com.lcyzh.nmerp.component;

import com.lcyzh.nmerp.configuration.ParamConfig;
import com.lcyzh.nmerp.utils.CustException;
import gnu.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

/**
 * @Project : nm-erp
 * @Description : /**
 * * 串口参数的配置 串口一般有如下参数可以在该串口打开以前进行配置： 包括串口号，波特率，输入/输出流控制，数据位数，停止位和奇偶校验。
 * *注：串口操作类一定要继承SerialPortEventListener
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/17  5:26 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/17    create
 */
public class SerialPortUtils implements SerialPortEventListener {
    // 检测系统中可用的通讯端口类
    private CommPortIdentifier commPortId;
    // 枚举类型
    private Enumeration<CommPortIdentifier> portList;
    // RS232串口
    private SerialPort serialPort;
    // 输入流
    private InputStream inputStream;
    // 输出流
    private OutputStream outputStream;
    // 保存串口返回信息
    private String data;
    // 保存串口返回信息十六进制
    private String dataHex;

    /**
     * @Description: 初始化串口
     * @Param: [paramConfig] 存放串口连接必要参数的对象（会在下方给出类代码）
     * @return: void
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/17 5:41 PM
     */
    @SuppressWarnings("unchecked")
    public void init(ParamConfig paramConfig) {
        // 获取系统中所有的通讯端口
        portList = CommPortIdentifier.getPortIdentifiers();
        // 记录是否含有指定串口
        boolean isExsist = false;
        // 循环通讯端口
        while (portList.hasMoreElements()) {
            commPortId = portList.nextElement();
            // 判断是否是串口
            if (commPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                // 比较串口名称是否是指定串口
                if (paramConfig.getSerialNumber().equals(commPortId.getName())) {
                    // 串口存在
                    isExsist = true;
                    // 打开串口
                    try {
                        // open:（应用程序名【随意命名】，阻塞时等待的毫秒数）
                        serialPort = (SerialPort) commPortId.open(Object.class.getSimpleName(), 2000);
                        // 设置串口监听
                        serialPort.addEventListener(this);
                        // 设置串口数据时间有效(可监听)
                        serialPort.notifyOnDataAvailable(true);
                        // 设置串口通讯参数:波特率，数据位，停止位,校验方式
                        serialPort.setSerialPortParams(paramConfig.getBaudRate(), paramConfig.getDataBit(),
                                paramConfig.getStopBit(), paramConfig.getCheckoutBit());
                    } catch (PortInUseException e) {
                        throw new CustException("端口被占用");
                    } catch (TooManyListenersException e) {
                        throw new CustException("监听器过多");
                    } catch (UnsupportedCommOperationException e) {
                        throw new CustException("不支持的COMM端口操作异常");
                    }
                    // 结束循环
                    break;
                }
            }
        }
        // 若不存在该串口则抛出异常
        if (!isExsist) {
            throw new CustException("不存在该串口！");
        }
    }

    /**
     * 实现接口SerialPortEventListener中的方法 读取从串口中接收的数据
     */
    @Override
    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
            case SerialPortEvent.BI: // 通讯中断
            case SerialPortEvent.OE: // 溢位错误
            case SerialPortEvent.FE: // 帧错误
            case SerialPortEvent.PE: // 奇偶校验错误
            case SerialPortEvent.CD: // 载波检测
            case SerialPortEvent.CTS: // 清除发送
            case SerialPortEvent.DSR: // 数据设备准备好
            case SerialPortEvent.RI: // 响铃侦测
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 输出缓冲区已清空
                break;
            case SerialPortEvent.DATA_AVAILABLE: // 有数据到达
                // 调用读取数据的方法
                readComm();
                break;
            default:
                break;
        }
    }

    /**
     * @Description: 读取串口返回信息
     * @Param: []
     * @return: void
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/17 5:31 PM
     */
    public void readComm() {
        try {
            inputStream = serialPort.getInputStream();
            // 通过输入流对象的available方法获取数组字节长度
            byte[] readBuffer = new byte[inputStream.available()];
            // 从线路上读取数据流
            int len = 0;
            while ((len = inputStream.read(readBuffer)) != -1) {
//　　　　　　　　　 直接获取到的数据,转为十六进制数据
                data = new String(readBuffer, 0, len).trim();
                dataHex = bytesToHexString(readBuffer);
                System.out.println("data:" + data);
                System.out.println("dataHex:" + dataHex);// 读取后置空流对象
                inputStream.close();
                inputStream = null;
                break;
            }
        } catch (IOException e) {
            throw new CustException("读取串口数据时发生IO异常");
        }
    }

    /**
     * @Description: 发送信息到串口
     * @Param: [data]
     * @return: void
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/17 5:31 PM
     */
    public void sendComm(String data) {
        byte[] writerBuffer = null;
        try {
            writerBuffer = hexToByteArray(data);
        } catch (NumberFormatException e) {
            throw new CustException("命令格式错误！");
        }
        try {
            outputStream = serialPort.getOutputStream();
            outputStream.write(writerBuffer);
            outputStream.flush();
        } catch (NullPointerException e) {
            throw new CustException("找不到串口。");
        } catch (IOException e) {
            throw new CustException("发送信息到串口时发生IO异常");
        }
    }

    /**
     * @Description: 关闭串口
     * @Param: []
     * @return: void
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/17 5:31 PM
     */
    public void closeSerialPort() {
        if (serialPort != null) {
            serialPort.notifyOnDataAvailable(false);
            serialPort.removeEventListener();
            if (inputStream != null) {
                try {
                    inputStream.close();
                    inputStream = null;
                } catch (IOException e) {
                    throw new CustException("关闭输入流时发生IO异常");
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                    outputStream = null;
                } catch (IOException e) {
                    throw new CustException("关闭输出流时发生IO异常");
                }
            }
            serialPort.close();
            serialPort = null;
        }
    }

    /**
     * 十六进制串口返回值获取
     */
    public String getDataHex() {
        String result = dataHex;
        // 置空执行结果
        dataHex = null;
        // 返回执行结果
        return result;
    }

    /**
     * 串口返回值获取
     */
    public String getData() {
        String result = data;
        // 置空执行结果
        data = null;
        // 返回执行结果
        return result;
    }

    /**
     * Hex字符串转byte
     *
     * @param inHex 待转换的Hex字符串
     * @return 转换后的byte
     */
    public static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

    /**
     * hex字符串转byte数组
     *
     * @param inHex 待转换的Hex字符串
     * @return 转换后的byte数组结果
     */
    public static byte[] hexToByteArray(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            // 奇数
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            // 偶数
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }

    /**
     * @Description: 数组转换成十六进制字符串
     * @Param: [bArray]
     * @return: java.lang.String
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/17 5:35 PM
     */
    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
}