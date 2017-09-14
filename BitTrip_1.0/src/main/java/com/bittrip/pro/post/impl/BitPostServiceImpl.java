package com.bittrip.pro.post.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
