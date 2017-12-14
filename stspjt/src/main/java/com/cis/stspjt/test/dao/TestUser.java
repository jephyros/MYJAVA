package com.cis.stspjt.test.dao;

import java.util.HashMap;
import java.util.List;

import com.cis.stspjt.test.dto.T_cmt_user;
import com.cis.stspjt.test.dto.UserExt;



public interface TestUser {
	public List<T_cmt_user > UseList();
	public void addUser(T_cmt_user t_cmt_user);
	public List<UserExt> getAllUser(HashMap<String, Object> hashMap);
}
