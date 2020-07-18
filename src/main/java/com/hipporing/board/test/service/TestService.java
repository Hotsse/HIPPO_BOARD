package com.hipporing.board.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hipporing.board.test.dao.TestDao;
import com.hipporing.board.test.vo.TestVO;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	public TestVO getTest(int key) {
		return this.testDao.getTest(key);
	}
	
	public List<TestVO> getTests() {
		return this.testDao.getTests();
	}
}
