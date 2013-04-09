/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 5:36:03
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api.impl;

import java.net.URI;

import org.codehaus.jackson.JsonNode;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Seongju-Jo
 *
 */
class AbstractDaumBlogOperations {
	
	protected final static String N_CHANNEL = "channel";
	protected final static String N_IS_NEW_GUESTBOOK_EXISTS = "isNewGuestbookExists";
	protected final static String N_NICKNAME = "nickname";
	protected final static String N_PROFILE_THUMBNAIL_IMAGE_URL = "profileThumbnailImageUrl";
	protected final static String N_PROFILE_IMAGE_URL = "profileImageUrl";
	protected final static String N_RSS_URL = "rssUrl";
	protected final static String N_URL = "url";
	protected final static String N_ID = "id";
	protected final static String N_VISITOR_COUNT = "visitorCount";
	protected final static String N_TITLE = "title";
	protected final static String N_DESCRIPTION = "description";
	protected final static String N_NAME = "name";
	protected final static String N_MYCON_IMAGE_URL = "myconImageUrl";
	protected final static String N_OPEN = "open";
	protected final static String N_CATEGORY_ID = "categoryId";
	protected final static String N_ITEMS = "items";
	protected final static String N_ITEM = "item";
	protected final static String N_POST_ID = "postId";
	protected final static String N_CONTENT = "content";
	protected final static String N_CATEGORY_NAME = "categoryName";
	protected final static String N_TRACKBACKS = "trackbacks";
	protected final static String N_IS_SCRAP = "isScrap";
	protected final static String N_DATE = "date";
	protected final static String N_COMMENTS = "comments";
	protected final static String N_VIEW_CATEGORY_ID = "viewCategoryId";
	protected final static String N_VIEW_ID = "viewId";
	protected final static String N_PREVIOUS_POST = "previousPost";
	protected final static String N_NEXT_POST = "nextPost";
	protected final static String N_SCRAP_PRMT_KIND = "scrapPrmtKind";
	protected final static String N_COMMENT_ID = "commentId";
	protected final static String N_PARENT_ID = "parentId";
	
	private final static String BASE_URI = "https://apis.daum.net/blog";

	protected final static String OUTPUT_FORMAT = "json";
	
	private static final MultiValueMap<String, String> BASE_PARAMETERS = new LinkedMultiValueMap<String, String>();

	static {
		BASE_PARAMETERS.add("output", OUTPUT_FORMAT);
	}
	
	protected final RestTemplate restTemplate;

	private final boolean isAuthorized;
	
	public AbstractDaumBlogOperations(RestTemplate restTemplate, boolean isAuthorized) {
		this.restTemplate = restTemplate;
		this.isAuthorized = isAuthorized;
	}
	
	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException();
		}
	}
	
	protected JsonNode extractNecessaryNode(JsonNode response) {

		JsonNode extractedJsonNode = response.path(N_CHANNEL);

		return extractedJsonNode;
	}
	
	protected URI buildUriWithoutParameters(String path) {
		return URIBuilder.fromUri(BASE_URI + path).build();
	}
	
	protected URI buildUri(String path) {
		return buildUri(path, null);
	}
	
	protected URI buildUri(String path, MultiValueMap<String, String> parameters) {

		URI uri = URIBuilder.fromUri(BASE_URI + path).queryParams(mergeParameters(parameters)).build();
		
		System.out.println(uri.toString());
		
		return uri;
	}

	protected MultiValueMap<String, String> mergeParameters(MultiValueMap<String, String> parameters) {
		
		if (parameters == null) {
			parameters = BASE_PARAMETERS;
		} else {
			parameters.putAll(BASE_PARAMETERS);
		}
		
		return parameters;
	}
}
