/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 7:02:14
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api.impl;

import java.util.List;

import org.springframework.social.daum.blog.api.Activity;
import org.springframework.social.daum.blog.api.Blog;
import org.springframework.social.daum.blog.api.BlogOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Seongju-Jo
 *
 */
public class BlogTemplate extends AbstractDaumBlogOperations implements BlogOperations {

	public BlogTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	@Override
	public Blog view() {
	
		return view(null);
	}

	@Override
	public Blog view(String blogName) {
		
		MultiValueMap<String, String> parameters = null;
		if (StringUtils.hasText(blogName)) {
			parameters = new LinkedMultiValueMap<String, String> (1);
			parameters.add("blogName", blogName);
		}

		JsonNode response = restTemplate.getForObject(buildUri("/info/blog.do", parameters), JsonNode.class);

		return convertToBlog(response);
	}

	private Blog convertToBlog(JsonNode response) {
		
		JsonNode blogNode = extractNecessaryNode(response);
		
		Blog blog = new Blog();
		blog.setBlogId(blogNode.path(N_ID).textValue());
		blog.setNewGuestbookExists("Y".equals(blogNode.path(N_IS_NEW_GUESTBOOK_EXISTS).textValue()) ? true : false);
		blog.setNickname(blogNode.path(N_NICKNAME).textValue());
		blog.setProfileThumbnailimageUrl(blogNode.path(N_PROFILE_THUMBNAIL_IMAGE_URL).textValue());
		blog.setProfileImageUrl(blogNode.path(N_PROFILE_IMAGE_URL).textValue());
		blog.setRssUrl(blogNode.path(N_RSS_URL).textValue());
		blog.setUrl(blogNode.path(N_URL).textValue());
		blog.setVisitorCount(Integer.parseInt(blogNode.path(N_VISITOR_COUNT).textValue()));
		blog.setBlogTitle(blogNode.path(N_TITLE).textValue());
		blog.setDescription(blogNode.path(N_DESCRIPTION).textValue());
		blog.setBlogName(blogNode.path(N_NAME).textValue());
		blog.setMyconImageUrl(blogNode.path(N_MYCON_IMAGE_URL).textValue());

		return blog;
	}

	@Override
	public List<Activity> listActivity(String blogName) {
		MultiValueMap<String, String> parameters = null;
		if (StringUtils.hasText(blogName)) {
			parameters = new LinkedMultiValueMap<String, String> (1);
			parameters.add("blogName", blogName);
		}
		JsonNode response = restTemplate.getForObject(buildUri("", parameters), JsonNode.class);
		System.out.println(response);
		return null;
	}
}
