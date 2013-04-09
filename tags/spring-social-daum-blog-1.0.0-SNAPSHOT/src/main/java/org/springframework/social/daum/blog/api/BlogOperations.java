/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 6:59:42
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

import java.util.List;

/**
 * @author Seongju-Jo
 *
 */
public interface BlogOperations {

	/**
	 * 인증된 사용자의 블로그 정보를 가져오기
	 * @return 블로그 정보
	 */
	Blog view();
	
	/**
	 * 지정한 블로그의 정보를 가져오기
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @return 블로그 정보
	 */
	Blog view(String blogName);
	
	List<Activity> listActivity(String blogName);
}
