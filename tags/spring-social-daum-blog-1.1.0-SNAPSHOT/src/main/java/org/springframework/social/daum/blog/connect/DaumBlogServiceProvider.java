/*
 * This file was created by Seongju-Jo on 2013. 4. 2. 오전 6:26:26
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.connect;

import org.springframework.social.daum.blog.api.DaumBlog;
import org.springframework.social.daum.blog.api.impl.DaumBlogTemplate;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.social.oauth1.OAuth1Version;

/**
 * @author Seongju-Jo
 *
 */
public class DaumBlogServiceProvider extends AbstractOAuth1ServiceProvider<DaumBlog> {

	public DaumBlogServiceProvider(String consumerKey, String consumerSecret) {
		super(consumerKey, consumerSecret,
				new OAuth1Template(consumerKey, consumerSecret,
						"https://apis.daum.net/oauth/requestToken",
						"https://apis.daum.net/oauth/authorize",
						"https://apis.daum.net/oauth/accessToken",
						OAuth1Version.CORE_10_REVISION_A));
	}

	@Override
	public DaumBlog getApi(String accessToken, String accessTokenSecret) {

		return new DaumBlogTemplate(getConsumerKey(), getConsumerSecret(), accessToken, accessTokenSecret);
	}
}
