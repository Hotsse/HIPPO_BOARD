package com.hipporing.board.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hipporing.board.core.base.BaseController;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = "/ajax")
public class AjaxController extends BaseController {
	
	@RequestMapping(value = "", method = {RequestMethod.GET})
	public String index() {	
		
		return "ajax/index";
	}
	

}
