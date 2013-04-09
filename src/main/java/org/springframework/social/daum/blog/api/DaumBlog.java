/*
 * This file was created by Seongju-Jo on 2013. 4. 2. 오전 6:22:54
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

/**
 * @author Seongju-Jo
 *
 */
public interface DaumBlog {

	BlogOperations blogOperations();
	
	CategoryOperations categoryOperations();
	
	PostOperations postOperations();
	
	CommentOperations commentOperations();
}
