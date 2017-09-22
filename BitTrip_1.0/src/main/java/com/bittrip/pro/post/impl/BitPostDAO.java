package com.bittrip.pro.post.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bittrip.pro.post.BitContentVO;
import com.bittrip.pro.post.BitLocationVO;
import com.bittrip.pro.post.BitPostVO;

@Repository
public class BitPostDAO {	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertPost(BitPostVO vo) {
		System.out.println("===> Mybatis로 insertPost() 기능 처리");		
		mybatis.insert("BitPostDAO.insertPost", vo);
	}
	
	public void insertContent(ArrayList<BitContentVO> list) {
		System.out.println("===> Mybatis로 insertContent() 기능 처리");		
		mybatis.insert("BitPostDAO.insertContent", list);
	}
	
	public void insertLocation(ArrayList<BitLocationVO> list) {
		System.out.println("===> Mybatis로 insertLocation() 기능 처리");		
		mybatis.insert("BitPostDAO.insertLocation", list);
	}
	
	public void updatePost(BitPostVO vo) {
		System.out.println("===> Mybatis로 updatePost() 기능 처리");
		mybatis.update("BitPostDAO.updatePost", vo);
	}

	public void deletePost(BitPostVO vo) {
		System.out.println("===> Mybatis로 deletePost() 기능 처리");
		mybatis.delete("BitPostDAO.deletePost", vo);
	}

	public BitPostVO getPost(BitPostVO vo) {
		System.out.println("===> Mybatis로 getPost() 기능 처리");
		return (BitPostVO) mybatis.selectOne("BitPostDAO.getPost", vo);
	}

	public List<BitPostVO> getPostList(BitPostVO vo) {
		System.out.println("===> Mybatis로 getPostList() 기능 처리");
		return mybatis.selectList("BitPostDAO.getPostList", vo);
	}
	
	public BitPostVO getPostInfo(BitPostVO vo) {
		System.out.println("===> Mybatis로 getPostInfo() 기능 처리");
		return mybatis.selectOne("BitPostDAO.getPostInfo", vo);
	}
	
	public BitPostVO getPostInfo2(BitPostVO vo) {
		System.out.println("===> Mybatis로 getPostInfo2() 기능 처리");
		return mybatis.selectOne("BitPostDAO.getPostInfo2", vo);
	}
	
	public String getContentList(BitPostVO vo) {
		System.out.println("===> Mybatis로 getContentList() 기능 처리");
		return mybatis.selectOne("BitPostDAO.getContentList", vo);
	}
	
	public String getLocationList(BitPostVO vo) {
		System.out.println("===> Mybatis로 getLocationList() 기능 처리");
		return mybatis.selectOne("BitPostDAO.getLocationList", vo);
	}
	
}
