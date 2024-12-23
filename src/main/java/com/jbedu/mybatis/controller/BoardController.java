package com.jbedu.mybatis.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbedu.mybatis.dao.BoardDao;
import com.jbedu.mybatis.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;//의존성 자동 주입 -> DI	
	
	@RequestMapping(value = "/write_form")
	public String write_form(HttpServletRequest request, Model model) {
		return "write_form";
	}
	@RequestMapping(value = "/delete_form")
	public String delete_form(HttpServletRequest request, Model model) {
		return "delete_form";
	}
	
	@RequestMapping(value = "/writeOk")
	public String boardWrite(HttpServletRequest request, Model model) {
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.boardWriteDao(bname, btitle, bcontent);
		
		return "redirect:boardList";
	}
	
	@RequestMapping(value = "/boardList")
	public String boardList(HttpServletRequest request, Model model) {
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		
		ArrayList<BoardDto> boardDtos = boardDao.boardListDao();
		
		model.addAttribute("bDtos", boardDtos);
		
		return "boardList";
	}
	
	@RequestMapping(value = "/deleteOk")
	public String boardDelete(HttpServletRequest request, Model model) {
		
		String bnum = request.getParameter("bnum"); // 삭제할 글 넘버
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int deleteFlag =boardDao.boardDeleteDao(bnum);
//		System.out.println(deleteFlag);
		if(deleteFlag == 0) {//존재하지 않는 글번호 삭제 시도->삭제 실패
			
			model.addAttribute("msg", "이미 삭제된 글번호 입니다.");
			model.addAttribute("url", "boardList");
			
			return "alert";
		} 
		
		
		return "redirect:boardList";
	}
	
	
	
	
	
	
	
}

//package com.jbedu.mybatis.controller;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.jbedu.mybatis.dao.BoardDao;
//import com.jbedu.mybatis.dto.BoardDto;
//
//@Controller
//public class BoardController {
//	
//	@Autowired  // SqlSession > 임포트 ibatis
//	private SqlSession sqlSessoin; //의존성 자동주입 > DI
//	
//	
//	@RequestMapping(value ="write_form")
//	public String write_form() {
//		return "write_form";
//	}
//	
//	@RequestMapping(value="/writeOK")
//	public String boardWrite(HttpServletRequest request, Model model) {	
//		String bname = request.getParameter("bname");
//		String btitle = request.getParameter("btitle");
//		String bcontent = request.getParameter("bcontent");
//		
//		// BoardDao 뽑아야 하는데 인터페이스라서 new 생성자 안됨 그래서 sqlSessoin에서 봅아온다.
//		BoardDao baordDao = sqlSessoin.getMapper(BoardDao.class);
//		baordDao.boardWriteDao(bname, btitle, bcontent);
//				
//				
//		return "redirect:boardList";//
//	}
//	
//	
//	@RequestMapping(value = "/boardList")
//	public String boardList(HttpServletRequest request, Model model) {
//		
//		BoardDao boardDao = sqlSessoin.getMapper(BoardDao.class);
//		
//		ArrayList<BoardDto> boardDtos = boardDao.boardListDao();
//		
//		model.addAttribute("bDtos", boardDtos);
//		
//		return "boardList";
//	}
//		
//}
