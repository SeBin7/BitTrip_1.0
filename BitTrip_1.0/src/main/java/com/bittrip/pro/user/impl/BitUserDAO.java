package com.bittrip.pro.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bittrip.pro.user.BitUserVO;

@Repository
public class BitUserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public BitUserVO getUser(BitUserVO vo) {
		System.out.println("BitUserDAO.getUser processing...");
		return mybatis.selectOne("BitUserDAO.loginUser", vo);			
	}
}
