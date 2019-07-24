package com.lcyzh.nmerp;

import com.google.common.io.Files;
import com.lcyzh.nmerp.model.vo.OutStockVo;
import com.lcyzh.nmerp.service.TOutStockService;
import org.apache.commons.io.Charsets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class NmErpApplicationTests {

	@Autowired
	private TOutStockService outStockService;
	@Test
	public void contextLoads() {
//        OutStockVo outStockVo = new OutStockVo();
//        outStockVo.setBarCode("10001");
//        outStockVo.setOutCode("1000");


	}


	@Test
	public void reader() throws IOException {
		File file = new File("/Users/lijinku/Documents/smErp/src/test/java/barCodes.txt");
		List<String> lines = Files.readLines(file, Charsets.UTF_8);
		for (String line:
			 lines) {
			System.out.println(line);
		}
	}

}
