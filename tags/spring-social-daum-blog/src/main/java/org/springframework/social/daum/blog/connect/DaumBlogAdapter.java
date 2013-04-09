/*
 * This file was created by Seongju-Jo on 2013. 4. 2. 오전 6:42:21
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.daum.blog.api.Blog;
import org.springframework.social.daum.blog.api.DaumBlog;
import org.springframework.social.daum.blog.api.Post;

/**
 * @author Seongju-Jo
 *
 */
public class DaumBlogAdapter implements ApiAdapter<DaumBlog> {

	@Override
	public boolean test(DaumBlog api) {
		
		Blog blog = api.blogOperations().view();
		
		return blog != null ? true : false;
	}

	@Override
	public void setConnectionValues(DaumBlog api, ConnectionValues values) {
		
		Blog blog = api.blogOperations().view();
		
		values.setDisplayName(blog.getNickname());
		String imageUrl = blog.getProfileThumbnailimageUrl();
		imageUrl = "http:" + imageUrl.substring(imageUrl.lastIndexOf("//"));
		values.setImageUrl(imageUrl);
		values.setProfileUrl(blog.getUrl());
		values.setProviderUserId(blog.getBlogName());
	}

	@Override
	public UserProfile fetchUserProfile(DaumBlog api) {
		Blog blog = api.blogOperations().view();
		return new UserProfileBuilder().setName(blog.getNickname()).setUsername(blog.getNickname()).build();
	}

	@Override
	public void updateStatus(DaumBlog api, String message) {
		Post post = new Post();
		post.setTitle(message);
		post.setContent(message);
		api.postOperations().post(api.blogOperations().view().getBlogName(), post);
	}
}
