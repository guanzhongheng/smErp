/**
 * Copyright &copy; 2017-2019  All rights reserved.
 */
package com.lcyzh.nmerp.utils;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author ThinkGem
 * @version 2013-01-15
 */
@Service
@Lazy(false)
public class IdGen implements  SessionIdGenerator {

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * 使用SecureRandom随机生成int
	 */
	public static int randomInt() {
		return Math.abs(random.nextInt());
	}

	/**
	 * 基于Base62编码的SecureRandom随机生成bytes.
	 */
	public static String randomBase62(int length) {
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		return Encodes.encodeBase62(randomBytes);
	}
	/**
	 * 条形码生成
	 */
	public static String getNetBarCode() {
		return randomBase62(3).toUpperCase() + randomInt();
	}
	
	/**
	 * Activiti ID 生成
	 */
	public String getNextId() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}

	@Override
	public Serializable generateId(Session session) {
		return IdGen.uuid();
	}
	
	public static void main(String[] args) {
		//System.out.println(IdGen.uuid());
		//System.out.println(IdGen.uuid().length());
		//System.out.println(new IdGen().getNextId());
		//for (int i=0; i<2; i++){
		//	System.out.println(Math.abs(random.nextInt()) + "  " + IdGen.randomBase62(3));
		//}
		//LocalDate ld = LocalDate.now().minusMonths(1);
		//System.out.println(ld.toString());
	}

}
