/*
 * This file was created by Seongju-Jo on 2013. 4. 2. 오전 6:25:07
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api.impl;

import org.springframework.social.daum.blog.api.BlogOperations;
import org.springframework.social.daum.blog.api.CategoryOperations;
import org.springframework.social.daum.blog.api.CommentOperations;
import org.springframework.social.daum.blog.api.DaumBlog;
import org.springframework.social.daum.blog.api.PostOperations;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;

/**
 * @author Seongju-Jo
 *
 */
public class DaumBlogTemplate extends AbstractOAuth1ApiBinding implements DaumBlog {

	private BlogOperations blogOperations;
	
	private CategoryOperations categoryOperations;
	
	private PostOperations postOperations;
	
	private CommentOperations commentOperations;
	
	public DaumBlogTemplate() {
		initSubApis();
	}
	
	public DaumBlogTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		initSubApis();
	}
	
    private void initSubApis() {
		blogOperations = new BlogTemplate(getRestTemplate(), isAuthorized());
		categoryOperations = new CategoryTemplate(getRestTemplate(), isAuthorized());
		postOperations = new PostTemplate(getRestTemplate(), isAuthorized());
		commentOperations = new CommentTemplate(getRestTemplate(), isAuthorized());
    }
    
	@Override
	public BlogOperations blogOperations() {
		return blogOperations;
	}

	@Override
	public CategoryOperations categoryOperations() {
		return categoryOperations;
	}

	@Override
	public PostOperations postOperations() {
		return postOperations;
	}

	@Override
	public CommentOperations commentOperations() {
		return commentOperations;
	}
}
