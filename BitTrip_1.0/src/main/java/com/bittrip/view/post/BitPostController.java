package com.bittrip.view.post;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bittrip.pro.post.BitPostService;
import com.bittrip.pro.post.BitPostVO;

@Controller
public class BitPostController {
	@Autowired
	private BitPostService postService;

	/*
	 * // 검색 조건 목록 설정
	 * 
	 * @ModelAttribute("conditionMap") public Map<String, String>
	 * searchConditionMap() {
	 * 
	 * Map<String, String> conditionMap = new HashMap<String, String>();
	 * 
	 * conditionMap.put("제목", "TITLE"); conditionMap.put("내용", "CONTENT");
	 * 
	 * return conditionMap; }
	 */

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(Model model) {
		String myData = "I want access to this";
		model.addAttribute("myData", myData);
		System.out.println(myData);
		System.out.println(myData);
		return "index.jsp";
	}
	

/*	@RequestMapping(value = "/index.do")
	public String ss13331() {
		System.out.println("Sadfasfdfasdfsd");

		return "index.jsp";
	}
*/
	// 글 등록
	@RequestMapping(value = "/insertPost.do")
	public String insertPost(BitPostVO vo) throws IOException {

		/*
		 * // 파일 업로드 처리 MultipartFile uploadFile = vo.getUploadFile();
		 * if(!uploadFile.isEmpty()) { String fileName =
		 * uploadFile.getOriginalFilename(); uploadFile.transferTo(new
		 * File("/home/changwoo/" + fileName)); }
		 */
		postService.insertPost(vo);

		return "getBoardList.do";
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
	@RequestMapping("/getPost.do")
	public String getPost(BitPostVO vo, Model model) {
		System.out.println("와쪄염뿌잉");
		List<BitPostVO> test = postService.getPostList(vo);
		model.addAttribute("post", test);
		System.out.println(test.size());
		return "index.jsp";
	}
	
	@RequestMapping("/getPostInfo.do")
	public String getPostInfo(BitPostVO vo, Model model) {
		System.out.println("post_id값: " + vo.getPost_id());
		model.addAttribute("postInfo", postService.getPostInfo(vo));
		return "getPostInfo.jsp";
	}
	
	//

	/*
	 * // 글 목록 검색
	 * 
	 * @RequestMapping("/getPostList.do") public String getPostList(
	 * //@RequestParam(value="searchCondition", defaultValue="TITLE",
	 * required=false) String condition, //@RequestParam(value="searchKeyword",
	 * defaultValue="", required=false) String keyword, BitPostVO vo, Model
	 * model) {
	 * 
	 * if(vo.getSearchCondition() == null) { vo.setSearchCondition("TITLE"); }
	 * 
	 * if(vo.getSearchKeyword() == null) { vo.setSearchKeyword(""); }
	 * 
	 * model.addAttribute("boardList", postService.getBoardList(vo));
	 * 
	 * return "getBoardList.jsp"; }
	 */

	/*
	 * @RequestMapping("/dataTransform.do")
	 * 
	 * @ResponseBody public BoardListVO dataTransform(BitPostVO vo) {
	 * vo.setSearchCondition("TITLE"); vo.setSearchKeyword(""); List<BoardVO>
	 * boardList = boardService.getBoardList(vo); BoardListVO boardListVO = new
	 * BoardListVO(); boardListVO.setBoardList(boardList); return boardListVO; }
	 */
}
