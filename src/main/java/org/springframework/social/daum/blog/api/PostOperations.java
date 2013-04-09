/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 10:58:14
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

import java.util.List;

/**
 * @author Seongju-Jo
 *
 */
public interface PostOperations {
	
	/**
	 * 글 목록 가져오기 (전체 카테고리로, 첫페이지, 한 페이지당 글 수 20개, 본문 생략)
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @return 게시글 리스트
	 */
	List<Post> list(String blogName);

	/**
	 * 글 목록 가져오기 (첫페이지, 한 페이지당 글 수 20개, 본문 생략)
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param categoryId 카테고리 ID (없을 경우 전체 카테고리로)
	 * @return 게시글 리스트
	 */
	List<Post> list(String blogName, int categoryId);

	/**
	 * 글 목록 가져오기 (한 페이지당 글 수 20개, 본문 생략)
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param categoryId 카테고리 ID (없을 경우 전체 카테고리로)
	 * @param pageNo 페이지 번호 (기본값 1)
	 * @return 게시글 리스트
	 */
	List<Post> list(String blogName, int categoryId, int pageNo);
	
	/**
	 * 글 목록 가져오기 (본문 생략)
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param categoryId 카테고리 ID (없을 경우 전체 카테고리로)
	 * @param pageNo 페이지 번호 (기본값 1)
	 * @param count 한 페이지당 글 수 (기본값 20)
	 * @return 게시글 리스트
	 */
	List<Post> list(String blogName, int categoryId, int pageNo, int count);
	
	/**
	 * 글 목록 가져오기
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param categoryId 카테고리 ID (없을 경우 전체 카테고리로)
	 * @param pageNo 페이지 번호 (기본값 1)
	 * @param count 한 페이지당 글 수 (기본값 20)
	 * @param viewContent "Y"(대문자)가 아닐 경우 본문 생략
	 * @return 게시글 리스트
	 */
	List<Post> list(String blogName, int categoryId, int pageNo, int count, boolean viewContent);
	
	/**
	 * 새 글 쓰기
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param post 올릴 새 글
	 * @return 새 글의 ID
	 */
	int post(String blogName, Post post);
	
	/**
	 * 새 글 쓰기 & 파일 첨부
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param post 올릴 새 글
	 * @param file 첨부할 파일
	 * @return 새 글의 ID
	 */
	int post(String blogName, Post post, String file);
	
	/**
	 * 글 수정하기
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param post 수정할 게시글
	 * @return
	 */
	int update(String blogName, Post post);
	
	/**
	 * 글 내용 가져오기
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param postId 게시글 ID
	 * @return 가져온 게시글
	 */
	Post view(String blogName, int postId);
	
	/**
	 * 파일 업로드
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @param file 첨부할 파일(10MB 이하)
	 * @return 첨부파일
	 */
	Attachment upload(String blogName, String file);
}
