package com.hipporing.board.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hipporing.board.test.dao.LoginDao;
import com.hipporing.board.test.vo.LoginVO;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public boolean checkLogin(LoginVO login) {
		
		return (this.loginDao.checkLogin(login) > 0);
	}
}
