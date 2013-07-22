/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 10:12:23
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

import java.util.List;

/**
 * @author Seongju-Jo
 *
 */
public interface CategoryOperations {

	/**
	 * 카테고리 목록 가져오기
	 * 
	 * @param blogName 블로그 이름 ("http://blog.daum.net/"주소 뒤에 붙는 이름)
	 * @return 카테고리 목록
	 */
	List<Category> list(String blogName);
}
