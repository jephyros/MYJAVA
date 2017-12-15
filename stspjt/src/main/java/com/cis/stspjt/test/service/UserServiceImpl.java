package com.cis.stspjt.test.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cis.stspjt.test.dao.TestUser;
import com.cis.stspjt.test.dto.T_cmt_user;
import com.cis.stspjt.test.dto.UserExt;


@Service("userService")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class UserServiceImpl implements UserService {
	
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private TestUser testUser;

	@Override
	public List<T_cmt_user> userList() throws DataAccessException {
		List<T_cmt_user>  UserList = null;
		try {
			UserList = testUser.UseList();
		}catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		return UserList;
	}

	@Override
	public void addUser(T_cmt_user t_cmt_user) throws DataAccessException {
		try {
			 testUser.addUser(t_cmt_user);
		}catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public List<UserExt> getAllUser(HashMap<String, Object> hashMap) {
		List<UserExt>  userExt = null;
		try {
			userExt = testUser.getAllUser(hashMap);
		}catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		return userExt;
	}

	@Override
	public boolean loginCheck(T_cmt_user vo, HttpSession session) {
		boolean result = testUser.loginCheck(vo);
        if (result) { // true일 경우 세션에 등록
            T_cmt_user vo2 = testUser.viewMember(vo);
            // 세션 변수 등록
            session.setAttribute("userId", vo2.getUser_id());
            session.setAttribute("userName", vo2.getUser_name());
        } 
        return result;
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
		
	}

}
