package com.lcyzh.nmerp;

import com.lcyzh.nmerp.model.vo.OutStockVo;
import com.lcyzh.nmerp.service.TOutStockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NmErpApplicationTests {

	@Autowired
	private TOutStockService outStockService;
	@Test
	public void contextLoads() {
        OutStockVo outStockVo = new OutStockVo();
        outStockVo.setBarCode("10001");
        outStockVo.setOutCode("1000");


	}

}
