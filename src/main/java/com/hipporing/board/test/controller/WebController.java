package com.hipporing.board.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hipporing.board.core.base.BaseController;
import com.hipporing.board.test.service.LoginService;
import com.hipporing.board.test.service.TestService;
import com.hipporing.board.test.vo.LoginVO;
import com.hipporing.board.test.vo.TestVO;

@Controller
@RequestMapping(value = "")
public class WebController extends BaseController {
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/", method = {RequestMethod.GET})
	public String index(Model model) {
		
		List<TestVO> tests = this.testService.getTests();		
		model.addAttribute("tests", tests);
		
		return "web/index";
	}
	
	@RequestMapping(value = "/detail/{key}", method = {RequestMethod.GET})
	public String detail(@PathVariable(name = "key", required = true) int key
				, Model model
				, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("userId", id);
		
		TestVO test = this.testService.getTest(key);
		model.addAttribute("test", test);
		
		return "web/detail";
	}
	
	@RequestMapping(value = "/write", method = {RequestMethod.GET})
	public String write() {
		return "web/write";
	}
	
	@RequestMapping(value = "/write", method = {RequestMethod.POST})
	public String postWrite(TestVO test
			, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		test.setRegId(id);
		
		this.log.debug(test.toString());
		
		this.testService.insertTest(test);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public String delete(int key) {
		
		this.testService.deleteTest(key);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/modify/{key}", method = {RequestMethod.GET})
	public String modify(@PathVariable(name = "key", required = true) int key
			, Model model) {
		
		TestVO test = this.testService.getTest(key);
		model.addAttribute("test", test);
		
		return "web/modify";		
	}
	
	@RequestMapping(value = "/modify", method = {RequestMethod.POST})
	public String postModify(TestVO test) {
		
		this.testService.updateTest(test);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	public String login() {
		return "web/login";
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST})
	public String postLogin(LoginVO login
			, HttpServletRequest req) {
		
		if(this.loginService.checkLogin(login)) {
			HttpSession session = req.getSession();
			session.setAttribute("id", login.getId());
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.GET})
	public String logout(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/";		
	}

}
