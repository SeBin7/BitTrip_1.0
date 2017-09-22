package com.bittrip.view.post;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bittrip.pro.post.BitContentVO;
import com.bittrip.pro.post.BitLocationVO;
import com.bittrip.pro.post.BitPostService;
import com.bittrip.pro.post.BitPostVO;

@Controller
public class BitPostController {
	@Autowired
	private BitPostService postService;

	@RequestMapping(value = "/newsfeed")
	public String blog(BitPostVO vo, Model model) {
		List<BitPostVO> postVO = postService.getPostList(vo);
/*		String content = postService.getContentList(vo);
		String location = postService.getLocationList(vo);*/
		System.out.println(postVO.size());
		model.addAttribute("post", postVO);
		return "newsfeed.jsp";
	}

	@RequestMapping(value = "/write.do")
	public String write(BitPostVO vo, HttpSession session) throws IOException {		
		if (session.getAttribute("userName") == null || session.getAttribute("userName").equals("")) {
			return "login.do";
		} else {
			return "write.jsp";
		}
	}

	@RequestMapping(value = "/insert.do")
	public String insertPost(BitPostVO vo, HttpSession session) throws IOException {

		vo.setName((String) session.getAttribute("userName"));
		vo.setUser_id((String) session.getAttribute("userId"));	
		
		for(int i=0; i<vo.getContentList().size(); i++) {
			System.out.println(vo.getContentList().get(i));
		}
		
		for(int i=0; i<vo.getLocationList().size(); i++) {
			System.out.println(vo.getLocationList().get(i));
		}
		
		double rand = Math.random();
		int val = (int)(rand*1000) + 1;
		vo.setPost_id(val);
		
		System.out.println(vo.getPost_id());
		System.out.println(vo.getTitle());
		System.out.println(vo.getUser_id());
		System.out.println(vo.getName());
		
		ArrayList<BitContentVO> contentList = new ArrayList<BitContentVO>();
		ArrayList<BitLocationVO> locationList = new ArrayList<BitLocationVO>();
		
		for(int i=0; i<vo.getContentList().size(); i++) {
			BitContentVO vo1 = new BitContentVO();
			String post_id_day = vo.getPost_id()+"_" + (i+1) + "day";
			vo1.setPost_id(vo.getPost_id());
			vo1.setPost_id_day(post_id_day);
			vo1.setContent(vo.getContentList().get(i));						
			contentList.add(vo1);
			
			for(int j=0; j<1; j++) {
				BitLocationVO vo2 = new BitLocationVO();
				vo2.setPost_id_day(post_id_day);
				vo2.setLocation(vo.getLocationList().get(j));
				vo2.setSort(j+1);						
				locationList.add(vo2);
			}
		}
		
		postService.insertPost(vo);
		postService.insertContent(contentList);
		postService.insertLocation(locationList);
		
/*		double rand = Math.random();
		int val = (int)(rand*1000) + 1;
		vo.setPost_id(val);
		
		ArrayList<BitContentVO> contentList = new ArrayList<BitContentVO>();
		ArrayList<BitLocationVO> locationList = new ArrayList<BitLocationVO>();
		
		for(int i=0; i<vo.getContentList().size(); i++) {
			BitContentVO vo1 = new BitContentVO();
			String post_id_day = vo.getPost_id()+"_" + (i+1) + "day";
			vo1.setPost_id(vo.getPost_id());
			vo1.setPost_id_day(post_id_day);
			vo1.setContent(vo.getContentList().get(i));						
			contentList.add(vo1);
		}
		
		for(int i=0; i<vo.getLocationList().size(); i++) {
			BitLocationVO vo2 = new BitLocationVO();
			String post_id_day = vo.getPost_id()+"_" + (i+1) + "day";
			vo2.setPost_id_day(post_id_day);
			vo2.setLocation(vo.getLocationList().get(i));
			vo2.setSort(i);						
			locationList.add(vo2);
		}

		System.out.println(vo.getName());
		System.out.println(vo.getUser_id());
		System.out.println(vo.getContentList().get(0));
		System.out.println(vo.getLocation().get(0));
		System.out.println(vo.getPost_id());
		System.out.println(vo.getPost_id_day());
		
		postService.insertPost(vo);
		postService.insertContent(contentList);
		postService.insertLocation(locationList);*/
		
		return "newsfeed.jsp";

	}

	// 글 수정
	@RequestMapping("/updatePost.do")
	public String updatePost(@ModelAttribute("board") BitPostVO vo) {

		postService.updatePost(vo);

		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deletePost.do")
	public String deletePost(BitPostVO vo) {

		postService.deletePost(vo);

		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/main.do")
	public String getPost(BitPostVO vo, Model model) {
		System.out.println("와쪄염뿌잉");
		List<BitPostVO> postVO = postService.getPostList(vo);
		model.addAttribute("post", postVO);
		return "main.jsp";
	}

	@RequestMapping("/read.do")
	public String getPostInfo(BitPostVO vo, Model model) {
		System.out.println("post_id값: " + vo.getPost_id());
		model.addAttribute("postInfo", postService.getPostInfo2(vo));
		return "read.jsp";
	}
	
	@RequestMapping("/getPostInfo.do")
	public String getPostInfo2(BitPostVO vo, Model model) {
		System.out.println("post_id값: " + vo.getPost_id());
		model.addAttribute("postInfo", postService.getPostInfo2(vo));
		return "getPostInfo.jsp";
	}

}
