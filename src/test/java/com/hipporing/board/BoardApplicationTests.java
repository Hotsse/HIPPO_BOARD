package com.hipporing.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hipporing.board.test.service.TestService;
import com.hipporing.board.test.vo.TestVO;

@SpringBootTest
class BoardApplicationTests {
	
	@Autowired
	private TestService testService;

	@Test
	void contextLoads() {		
		int key = 1;
		
		TestVO test1 = new TestVO();
		test1.setParam1("252352352");
		test1.setParam2("erhreherh");
		test1.setParam3("rt98yrt89r90");
		System.out.println(this.testService.insertTest(test1));
		
		TestVO test = this.testService.getTest(key);
		
		System.out.println(test.toString());
	}

}
