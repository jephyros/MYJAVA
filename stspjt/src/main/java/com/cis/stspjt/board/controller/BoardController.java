package com.cis.stspjt.board.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cis.stspjt.board.dao.BoardDao;
import com.cis.stspjt.board.dto.Board;

@Controller
@RequestMapping("/board")
//@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private SqlSession sqlsession;
	
	//보드리스트 -> DBO를 안쓰고 request mapper 를 써보자
	@RequestMapping(value = "/boardlist.do", method = RequestMethod.GET)
	public ModelAndView List(HttpServletRequest request , HttpServletResponse response) throws Exception{
		
		
		BoardDao boardDao=sqlsession.getMapper(BoardDao.class);
		
		ModelAndView mav = new ModelAndView("/board/boardlist");
		mav.addObject("boardlist",boardDao.boardList());
		
		/*ArrayList<Board> bdlist= boardDao.boardList();
		System.out.println("체크시작");
		System.out.println(bdlist.get(0).getTitle());
		*/
		logger.info("Logger2(호출): " + mav.getViewName());
				
		return mav;
	}
}
