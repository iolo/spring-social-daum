/*
 * This file was created by Seongju-Jo on 2013. 4. 4. 오후 4:26:38
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.springframework.social.daum.blog.api.Comment;
import org.springframework.social.daum.blog.api.CommentOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author Seongju-Jo
 *
 */
public class CommentTemplate extends AbstractDaumBlogOperations implements CommentOperations {

	public CommentTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	@Override
	public List<Comment> list(String blogName, int postId) {
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String> ();
		parameters.add("blogName", blogName);
		parameters.add("postId", String.valueOf(postId));
		
		JsonNode response = restTemplate.getForObject(buildUri("/comment/list.do", parameters), JsonNode.class);
		
		return converToComments(response);
	}

	@Override
	public void comment(String blogName, int postId, String content) {
		comment(blogName, postId, content, false);
	}

	@Override
	public void comment(String blogName, int postId, String content, boolean isSecret) {
		
		requireAuthorization();
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String> ();
		parameters.add("blogName", blogName);
		parameters.add("postId", String.valueOf(postId));
		parameters.add("content", content);
		if (isSecret) {
			parameters.add("secret", "Y");
		}

		JsonNode response = restTemplate.postForObject(buildUriWithoutParameters("/comment/write.do"), mergeParameters(parameters), JsonNode.class);
		
		extractNecessaryNode(response);
	}

	@Override
	public void comment(String blogName, int postId, String content, String name, String password, String email, String homepage) {
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String> ();
		parameters.add("blogName", blogName);
		parameters.add("postId", String.valueOf(postId));
		parameters.add("content", content);
		parameters.add("name", name);
		parameters.add("password", password);
		parameters.add("email", email);
		parameters.add("homepage", homepage);

		JsonNode response = restTemplate.postForObject(buildUriWithoutParameters("/comment/write.do"), mergeParameters(parameters), JsonNode.class);
		
		extractNecessaryNode(response);
	}

	private List<Comment> converToComments(JsonNode response) {
		
		List<Comment> comments = null;
		
		Iterator<JsonNode> item = extractNecessaryNode(response).path(N_ITEM).getElements();
		while (item.hasNext()) {
			if (comments == null) {
				comments = new ArrayList<Comment> ();
			}
			
			comments.add(converToComment(item.next()));
		}
		
		return comments;
	}

	private Comment converToComment(JsonNode jsonNode) {
		
		if (jsonNode == null) {
			return null;
		}
		
		Comment comment = new Comment();
		comment.setCommentId(Integer.parseInt(jsonNode.path(N_COMMENT_ID).getTextValue()));
		comment.setContent(jsonNode.path(N_CONTENT).getTextValue());
		comment.setName(jsonNode.path(N_NAME).getTextValue());
		comment.setUrl(jsonNode.path(N_URL).getTextValue());
		if (StringUtils.hasText(jsonNode.path(N_PARENT_ID).getTextValue())) {
			comment.setParentId(Integer.parseInt(jsonNode.path(N_PARENT_ID).getTextValue()));
		}
		try {
			comment.setCommentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jsonNode.path(N_DATE).getTextValue()));
		} catch (ParseException e) {
		}
		
		return comment;
	}
}
