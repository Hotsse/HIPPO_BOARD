package com.hipporing.board.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hipporing.board.test.vo.LoginVO;

@Repository
public class LoginDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;

	public int checkLogin(LoginVO login) {
		return sqlSession.selectOne("login.checkLogin", login);
	}
}
