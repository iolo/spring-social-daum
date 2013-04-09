/*
 * This file was created by Seongju-Jo on 2013. 4. 2. 오전 6:41:30
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.daum.blog.api.DaumBlog;
import org.springframework.social.oauth1.OAuth1ServiceProvider;

/**
 * @author Seongju-Jo
 *
 */
public class DaumBlogConnectionFactory extends OAuth1ConnectionFactory<DaumBlog> {

	/**
	 * @param providerId
	 * @param serviceProvider
	 * @param apiAdapter
	 */
	public DaumBlogConnectionFactory(String consumerKey, String consumerSecret) {
		super("daum-blog", new DaumBlogServiceProvider(consumerKey, consumerSecret), new DaumBlogAdapter());
	}
	
	public DaumBlogConnectionFactory(OAuth1ServiceProvider<DaumBlog> serviceProvider, ApiAdapter<DaumBlog> apiAdapter) {
		super("daum-blog", serviceProvider, apiAdapter);
	}
}
