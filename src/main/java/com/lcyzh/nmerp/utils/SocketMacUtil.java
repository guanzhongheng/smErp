package com.lcyzh.nmerp.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLOutput;

/**
 * 项目名称：nm-erp
 * 类 名 称：SocketMacUtil
 * 类 描 述：TODO
 * 创建时间：2019/9/8 4:47 PM
 * 创 建 人：guan
 */
public class SocketMacUtil {

    public static String transBytesToStr(byte[] bytes){
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < bytes.length; i++){
            if(i != 0)
                buffer.append("-");
            //bytes[i]&0xff将有符号byte数值转换为32位有符号整数，其中高24位为0，低8位为byte[i]
            int intMac = bytes[i]&0xff;
            //toHexString函数将整数类型转换为无符号16进制数字
            String str = Integer.toHexString(intMac);
            if(str.length() == 0){
                buffer.append("0");
            }
            buffer.append(str);
        }
        return buffer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        try {
            InetAddress adress = InetAddress.getLocalHost();
            System.out.println("address:" + adress);
            NetworkInterface net = NetworkInterface.getByInetAddress(adress);
            byte[] macBytes = net.getHardwareAddress();
            System.out.println(transBytesToStr(macBytes));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
