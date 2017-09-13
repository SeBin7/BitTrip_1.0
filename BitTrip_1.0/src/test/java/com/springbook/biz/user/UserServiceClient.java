package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bittrip.pro.user.BitUserService;
import com.bittrip.pro.user.BitUserVO;

public class UserServiceClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		BitUserService userService = (BitUserService)container.getBean("userService");
		
		BitUserVO vo = new BitUserVO();
		vo.setEmail("tt@gmail.com");
		vo.setPassword("123");
		
		BitUserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "성공");
		} else {
			System.out.println("실패");
		}
		
		container.close();
	}
}
