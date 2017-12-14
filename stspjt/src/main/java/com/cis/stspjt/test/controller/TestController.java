package com.cis.stspjt.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.cis.stspjt.test.dto.T_cmt_user;
import com.cis.stspjt.test.dto.UserExt;
import com.cis.stspjt.test.service.UserService;







@Controller
@RequestMapping("/test")
public class TestController extends MultiActionController{
	protected final Log logger = LogFactory.getLog(getClass());
	private static final Logger logger2 = LoggerFactory.getLogger(TestController.class);
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/dbUserList.do", method = RequestMethod.GET)
	public ModelAndView dbuserList(HttpServletRequest request , HttpServletResponse response) throws Exception{
		
		List<T_cmt_user> userList = userService.userList();
		
		
		ModelAndView mav = new ModelAndView("/test/dbUserList");
		mav.addObject("userList",userList);
		
		logger2.info("Logger2(호출) - "+mav.getViewName());
		logger.info("Logger2(호출): " + mav.getViewName());
				
		return mav;
	}
	@RequestMapping(value = "/adduserForm.do", method = RequestMethod.GET)
	public ModelAndView adduserForm () throws Exception{
		
		
		ModelAndView mav = new ModelAndView("/test/adduserForm");
		
		logger2.info("Logger2(호출) - "+mav.getViewName());
		logger.info("Logger2(호출): " + mav.getViewName());
				
		return mav;
	}
	
	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	public ModelAndView addUserDo(HttpServletRequest request , HttpServletResponse response) throws Exception{
		
		
		ModelAndView mav = new ModelAndView("redirect:/test/dbUserList.do");
		
		 
		
		T_cmt_user t_cmt_user = new T_cmt_user();
		bind(request, t_cmt_user);	
		userService.addUser(t_cmt_user);
		
		logger2.info("Logger2(호출) - "+mav.getViewName());
		logger.info("Logger2(호출): " + mav.getViewName());
				
		return mav;
	}

	
	@RequestMapping(value = "/userList.do", method = RequestMethod.GET)
	public ModelAndView userList () throws Exception{
		
		
		ModelAndView mav = new ModelAndView("/test/userList");
		
		logger2.info("Logger2(호출) - "+mav.getViewName());
		logger.info("Logger2(호출): " + mav.getViewName());
				
		return mav;
	}
	
	@RequestMapping(value = "/userList",method = RequestMethod.POST)
	  public @ResponseBody String getUserList(HttpServletRequest request,
	                                                                       HttpServletResponse response,
	                                                @RequestParam boolean _search,
	                                                @RequestParam long     nd,
	                                                @RequestParam int       rows,
	                                                @RequestParam int       page,
	                                                @RequestParam String   sidx,
	                                                @RequestParam String   sord
	                                                 ) throws JsonGenerationException,   
	                                                                                   JsonMappingException,
	                                                                                   IOException {

        
	   logger.debug("search = " + _search + " : nd = " + nd + " : rows = " + rows +
	                                     " : pages = " + page + " : sidx = " + sidx  + " : sord =" + sord);

	   HashMap<String,Object> params = new HashMap<String,Object>();
	   int start =  ((page - 1) * rows ) + 1;
	   int limit = (start + rows) -1;
	   
	   System.err.println("start = " + start + " : limit =" + limit);
	   params.put("start", start );
	   params.put("limit", limit);
	   
	   List<UserExt> userExtList = userService.getAllUser(params);
	   
	   ObjectMapper mapper = new ObjectMapper();
	   
	   Map<String, Object> modelMap = new HashMap<String, Object>();
	   // total = Total Page
	   // record = Total Records
	   // rows = list data
	   // page = current page
	   
	   double total = (double) userExtList.get(0).getTotcnt() / rows;
	   modelMap.put("total",(int) Math.ceil(total));
	   modelMap.put("records", userExtList.get(0).getTotcnt());
	   modelMap.put("rows", userExtList);
	   modelMap.put("page", page);
	  
	   String value = mapper.writeValueAsString(modelMap);
	   logger.debug(value);
	   return value;
	  }
}
