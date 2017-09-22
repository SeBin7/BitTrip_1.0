package com.bittrip.pro.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BitPostService {
	void insertPost(BitPostVO vo);
	void insertContent(ArrayList<BitContentVO> contentList);
	void insertLocation(ArrayList<BitLocationVO> locationList);
	void updatePost(BitPostVO vo);
	void deletePost(BitPostVO vo);
	BitPostVO getPost(BitPostVO vo);
	List<BitPostVO> getPostList(BitPostVO vo);
	BitPostVO getPostInfo(BitPostVO vo);
	BitPostVO getPostInfo2(BitPostVO vo);
	String getContentList(BitPostVO vo);
	String getLocationList(BitPostVO vo);
}
