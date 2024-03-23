package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GuestbookController {
	
	//리스트
	@RequestMapping(value="/api/guests", method = RequestMethod.GET)
	public String list() {
		System.out.println("GuestbookController.list()");
		return "";
	}

}
