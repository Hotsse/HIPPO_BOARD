package com.hipporing.board.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hipporing.board.test.service.TestService;
import com.hipporing.board.test.vo.TestVO;

@RestController
@RequestMapping(value = "/test")
public class TestController {
	
	@Autowired
	private TestService testService;

	@RequestMapping(value = "/home", method = {RequestMethod.GET})
	public String home() {
		return "Hello World! i'm a new programmer from korea.";
	}
	
	@RequestMapping(value = "/testvo/{key}", method = {RequestMethod.GET})
	public TestVO getTest(@PathVariable(name = "key", required = true) int key) {		
		return this.testService.getTest(key);
	}
	
	@RequestMapping(value = "/testvos", method = {RequestMethod.GET})
	public List<TestVO> getTests() {
		return this.testService.getTests();
	}
	
	@RequestMapping(value = "/testvo", method = {RequestMethod.POST})
	public int insertTest(@RequestBody TestVO test) {		
		return this.testService.insertTest(test);
	}
	
	@RequestMapping(value = "/testvo/{key}", method = {RequestMethod.DELETE})
	public int deleteTest(@PathVariable(name = "key", required = true) int key) {
		return this.testService.deleteTest(key);
	}
	
	@RequestMapping(value = "/testvo", method = {RequestMethod.PUT})
	public int updateTest(@RequestBody TestVO test) {
		return this.testService.updateTest(test);
	}
	
}
