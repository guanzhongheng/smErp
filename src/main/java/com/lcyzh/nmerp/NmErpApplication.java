package com.lcyzh.nmerp;

import org.apache.log4j.BasicConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@MapperScan("com.lcyzh.nmerp.dao")
public class NmErpApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(NmErpApplication.class, args);
	}

}
