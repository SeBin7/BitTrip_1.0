package com.bittrip.pro.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittrip.pro.user.BitUserService;
import com.bittrip.pro.user.BitUserVO;


@Service("userService")
public class BitUserServiceImpl implements BitUserService{

	@Autowired
	private BitUserDAO userDAO;	
	
	public void setUserDAO(BitUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public BitUserVO getUser(BitUserVO vo) {	
		System.out.println("ASDfasdfdsa");
		return userDAO.getUser(vo);
	}

}
