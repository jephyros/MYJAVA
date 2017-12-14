package com.cis.stspjt.test.junittest;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cis.stspjt.test.dao.TimeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "file:src/main/webapp/WEB-INF/spring"
		+ "/**/*-context.xml" })

public class TimeDaoTest {
	@Inject
	private TimeDao dao;
	
	@Test
	public void timeTest() throws Exception{
		System.out.println(dao.getTime());
	}

}
