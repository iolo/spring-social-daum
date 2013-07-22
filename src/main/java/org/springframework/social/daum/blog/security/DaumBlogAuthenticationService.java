/*
 * This file was created by Seongju-Jo on 2013. 7. 23. 오전 12:17:51
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.security;

import org.springframework.social.daum.blog.api.DaumBlog;
import org.springframework.social.daum.blog.connect.DaumBlogConnectionFactory;
import org.springframework.social.security.provider.OAuth1AuthenticationService;

/**
 * @author Seongju
 *
 */
public class DaumBlogAuthenticationService extends OAuth1AuthenticationService<DaumBlog> {

	public DaumBlogAuthenticationService(String apiKey, String appSecret) {
		super(new DaumBlogConnectionFactory(apiKey, appSecret));
	}

}
