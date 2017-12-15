package com.cis.stspjt.test.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;

import com.cis.stspjt.test.dto.T_cmt_user;
import com.cis.stspjt.test.dto.UserExt;

public interface UserService {
	public List<T_cmt_user> userList() throws DataAccessException;
	public void addUser(T_cmt_user t_cmt_user) throws DataAccessException;
	public List<UserExt> getAllUser(HashMap<String, Object> hashMap);
	//01 회원로드인
	public boolean loginCheck(T_cmt_user vo, HttpSession session);
	 // 02. 회원 로그아웃
    public void logout(HttpSession session);
}
