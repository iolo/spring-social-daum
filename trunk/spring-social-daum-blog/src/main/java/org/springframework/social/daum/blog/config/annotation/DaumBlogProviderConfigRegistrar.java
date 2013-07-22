/*
 * This file was created by Seongju-Jo on 2013. 7. 23. 오전 12:32:37
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.config.annotation;

import org.springframework.social.config.annotation.AbstractProviderConfigRegistrarSupport;
import org.springframework.social.daum.blog.config.support.DaumBlogApiHelper;
import org.springframework.social.daum.blog.connect.DaumBlogConnectionFactory;
import org.springframework.social.daum.blog.security.DaumBlogAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

/**
 * @author Seongju
 *
 */
public class DaumBlogProviderConfigRegistrar extends AbstractProviderConfigRegistrarSupport {
	
	public DaumBlogProviderConfigRegistrar() {
		super(EnableDaumBlog.class, DaumBlogConnectionFactory.class, DaumBlogApiHelper.class);
	}

	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return DaumBlogAuthenticationService.class;
	}
}