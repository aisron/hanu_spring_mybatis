package com.jbedu.mybatis.dao;

import java.util.ArrayList;

import com.jbedu.mybatis.dto.BoardDto;

public interface BoardDao {
	
	public void boardWriteDao(String bname, String btitle, String bcontent);//글쓰기
	public ArrayList<BoardDto> boardListDao();//모든 글 목록 가져오기
	public int boardDeleteDao(String bnum); //글삭제
	// 실패하면 0, 성공 1 > 삭제된 레코드의 갯수
	
	
}

//package com.jbedu.mybatis.dao;
//
//import java.util.ArrayList;
//
//import com.jbedu.mybatis.dto.BoardDto;
//
//public interface BoardDao {
//	
//	
//	public void boardWriteDao(String bname, String btitle, String bcontent);//글쓰기
//	public ArrayList<BoardDto> boardListDao();//모든 글 목록 가져오기
//	// 반환타입이 모든글 받아야 하니까 ArrayList
//
//}
