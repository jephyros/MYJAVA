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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cis.stspjt.board.dao.BoardDao;
import com.cis.stspjt.board.dto.Board;
import com.cis.stspjt.board.dto.BoardExt;
import com.cis.stspjt.test.dto.T_cmt_user;

@Controller
@RequestMapping("/board")
//@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private SqlSession sqlsession;
	
	//보드리스트 -> DBO를 안쓰고 request mapper 를 써보자
	@RequestMapping(value = "/boardlist.do", method = RequestMethod.GET)
	public ModelAndView BoardList(HttpServletRequest request , HttpServletResponse response) throws Exception{
		
		
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
	//보드리스트 -> DBO를 안쓰고 request mapper 를 써보자
	//보드조회 최초 화면열릴때
	@RequestMapping("/boardlistExt.do")
	public ModelAndView BoardListExt(@ModelAttribute BoardExt boardExt) throws Exception{
		
		boardExt.setNum(-1);
		System.out.println(boardExt.getNum());
		BoardDao boardDao=sqlsession.getMapper(BoardDao.class);
		
		ModelAndView mav = new ModelAndView("/board/boardlistExt");
		mav.addObject("boardlistExt",boardDao.boardListExt(boardExt));
		
		logger.info("Logger2(호출): " + mav.getViewName());
				
		return mav;
	}
	//보드조회 검색버튼눌렸을때
	@RequestMapping("/boardlistSearch.do")
	public ModelAndView BoardListSearch(@ModelAttribute BoardExt boardExt) throws Exception{
		
		
		BoardDao boardDao=sqlsession.getMapper(BoardDao.class);
		
		ModelAndView mav = new ModelAndView("/board/boardlistExt");
		mav.addObject("boardlistExt",boardDao.boardListExt(boardExt));
		
		logger.info("Logger2(호출): " + mav.getViewName());
				
		return mav;
	}
		
		
}
