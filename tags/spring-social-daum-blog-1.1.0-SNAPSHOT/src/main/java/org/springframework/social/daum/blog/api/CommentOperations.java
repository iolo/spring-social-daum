/*
 * This file was created by Seongju-Jo on 2013. 4. 4. 오후 4:22:03
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

import java.util.List;

/**
 * @author Seongju-Jo
 *
 */
public interface CommentOperations {

	/**
	 * 댓글 목록 가져오기
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param postId 해당 게시글 ID
	 * @return 가져온 댓글 목록
	 */
	List<Comment> list(String blogName, int postId);
	
	/**
	 * 댓글 쓰기 (로그인 시)
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param postId 해당 게시글 ID
	 * @param content 댓글 내용
	 */
	void comment(String blogName, int postId, String content);
	
	/**
	 * 댓글 쓰기 (로그인 시)
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param postId 해당 게시글 ID
	 * @param content 댓글 내용
	 * @param isSecret 비밀글 여부
	 */
	void comment(String blogName, int postId, String content, boolean isSecret);
	
	/**
	 * 댓글 쓰기 (비 로그인 시)
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param postId 해당 게시글 ID
	 * @param content 댓글 내용
	 * @param name 작성자
	 * @param password 비밀번호
	 * @param email 작성자의 이메일
	 * @param homepage 작성자의 홈피주소
	 */
	void comment(String blogName, int postId, String content, String name, String password, String email, String homepage);
}
