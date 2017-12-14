package com.cis.stspjt.test.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cis.stspjt.test.dto.T_cmt_user;
import com.cis.stspjt.test.dto.UserExt;


@Repository("testUserImpl")
public class TestUserImpl implements TestUser {

	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<T_cmt_user> UseList() {
		
		
		List <T_cmt_user> userList =null;		
		userList = sqlSession.selectList("mapper.test.selectCmtuser");
		return userList;
		
	}
	@Override
	public void addUser(T_cmt_user t_cmt_user) {
		sqlSession.insert("mapper.test.userInsert2",t_cmt_user);
		sqlSession.insert("mapper.test.userInsert",t_cmt_user);
		
		
	}
	@Override
	public List<UserExt> getAllUser(HashMap<String, Object> hashMap) {

		List <UserExt> userExt =null;		
		userExt = sqlSession.selectList("mapper.test.getAllUser", hashMap);
		return userExt;
	}
		

}
