package com.bittrip.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bittrip.pro.user.BitUserService;
import com.bittrip.pro.user.BitUserVO;
import com.bittrip.pro.user.impl.BitUserDAO;

@Controller
public class BitLoginController {
	@Autowired 
	private BitUserService userService; 
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") String user) {

		System.out.println("Login Page Loading...");

		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(BitUserVO vo, HttpSession session) {

		if(vo.getEmail() == null || vo.getEmail().equals("")) {
			throw new IllegalArgumentException("Login Error...");
		}

		BitUserVO user = userService.getUser(vo);		
		
		if(user != null) {

			session.setAttribute("userName", user.getName());

			return "index.jsp";

		} else {

			return "login.jsp";
		}
	}
}





