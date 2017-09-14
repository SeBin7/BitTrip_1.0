package com.bittrip.pro.post;

import java.util.List;

public interface BitPostService {
	void insertPost(BitPostVO vo);
	void updatePost(BitPostVO vo);
	void deletePost(BitPostVO vo);
	BitPostVO getPost(BitPostVO vo);
	List<BitPostVO> getPostList(BitPostVO vo);
	BitPostVO getPostInfo(BitPostVO vo);
}
