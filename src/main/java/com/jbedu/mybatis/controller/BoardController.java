package com.jbedu.mybatis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@Autowired  // SqlSession > 임포트 ibatis
	private SqlSession sqlSessoin; //의존성 자동주입 > DI
	
	
	@RequestMapping(value ="write_form")
	public String write_form() {
		return "write_form";
	}
	
	@RequestMapping(value="/writeOK")
	public String boardWrite(HttpServletRequest request, Model model) {	
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		return "redirect:boardList";//
	}
	
}
