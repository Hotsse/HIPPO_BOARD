package com.hipporing.board.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hipporing.board.test.vo.TestVO;

@Repository
public class TestDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;

	public TestVO getTest(int key) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("key", key);
		
		TestVO test = this.sqlSession.selectOne("test.getTest", param);		
		return test;
	}
	
	public List<TestVO> getTests() {		
		List<TestVO> test = this.sqlSession.selectList("test.getTests");		
		return test;
	}
	
	public int insertTest(TestVO test) {
		return this.sqlSession.insert("test.insertTest", test);
	}
	
	public int deleteTest(int key) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("key", key);
		
		return this.sqlSession.delete("test.deleteTest", param);
	}
	
	public int updateTest(TestVO test) {
		return this.sqlSession.update("test.updateTest", test);
	}
}
