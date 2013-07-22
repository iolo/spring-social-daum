/*
 * This file was created by Seongju-Jo on 2013. 7. 23. 오전 12:36:48
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.config.support;

import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.daum.blog.api.DaumBlog;

/**
 * @author Seongju
 *
 */
public class DaumBlogApiHelper implements ApiHelper<DaumBlog> {
	
	private final UsersConnectionRepository usersConnectionRepository;

	private final UserIdSource userIdSource;

	private DaumBlogApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
		this.usersConnectionRepository = usersConnectionRepository;
		this.userIdSource = userIdSource;		
	}

	public DaumBlog getApi() {

		Connection<DaumBlog> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(DaumBlog.class);

		return connection != null ? connection.getApi() : null;
	}

}
