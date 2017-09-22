package com.bittrip.pro.post.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittrip.pro.post.BitContentVO;
import com.bittrip.pro.post.BitLocationVO;
import com.bittrip.pro.post.BitPostService;
import com.bittrip.pro.post.BitPostVO;

@Service("postService")
public class BitPostServiceImpl implements BitPostService{

	@Autowired
	private BitPostDAO postDAO;

	@Override
	public void insertPost(BitPostVO vo) {
		postDAO.insertPost(vo);
	}
	
	@Override
	public void insertContent(ArrayList<BitContentVO> contentList) {
		postDAO.insertContent(contentList);		
	}
	
	@Override
	public void insertLocation(ArrayList<BitLocationVO> locationList) {
		postDAO.insertLocation(locationList);				
	}
	
	@Override
	public void updatePost(BitPostVO vo) {
		postDAO.updatePost(vo);				
	}

	@Override
	public void deletePost(BitPostVO vo) {	
		postDAO.deletePost(vo);				
	}

	@Override
	public BitPostVO getPost(BitPostVO vo) {
		return postDAO.getPost(vo);
	}

	@Override
	public List<BitPostVO> getPostList(BitPostVO vo) {
		return postDAO.getPostList(vo);
	}

	@Override
	public BitPostVO getPostInfo(BitPostVO vo) {
		return (BitPostVO) postDAO.getPostInfo(vo);
	}

	@Override
	public BitPostVO getPostInfo2(BitPostVO vo) {
		return (BitPostVO) postDAO.getPostInfo2(vo);
	}

	@Override
	public String getContentList(BitPostVO vo) {
		return postDAO.getContentList(vo);
	}

	@Override
	public String getLocationList(BitPostVO vo) {
		// TODO Auto-generated method stub
		return postDAO.getContentList(vo);
	}




}
