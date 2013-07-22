/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 11:21:01
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.social.daum.blog.api.Attachment;
import org.springframework.social.daum.blog.api.Post;
import org.springframework.social.daum.blog.api.PostOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Seongju-Jo
 * 
 */
public class PostTemplate extends AbstractDaumBlogOperations implements PostOperations {
	
	private final static int POST_CONVERT_TYPE_LIST = 1;
	private final static int POST_CONVERT_TYPE_VIEW = 2;
	private final static int POST_CONVERT_TYPE_SIDE = 3;

	public PostTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	@Override
	public List<Post> list(String blogName) {
		
		return list(blogName, 0);
	}

	@Override
	public List<Post> list(String blogName, int categoryId) {

		return list(blogName, categoryId, 0);
	}

	@Override
	public List<Post> list(String blogName, int categoryId, int pageNo) {

		return list(blogName, categoryId, pageNo, 0);
	}

	@Override
	public List<Post> list(String blogName, int categoryId, int pageNo, int count) {

		return list(blogName, categoryId, pageNo, count, false);
	}

	@Override
	public List<Post> list(String blogName, int categoryId, int pageNo, int count, boolean viewContent) {
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String> ();
		
		parameters.add("blogName", blogName);
		
		if (categoryId > 0) {
			parameters.add("categoryId", String.valueOf(categoryId));
		}
		
		if (pageNo > 0) {
			parameters.add("pageNo", String.valueOf(pageNo));
		} else {
			parameters.add("pageNo", String.valueOf(1));
		}
		
		if (count > 0) {
			parameters.add("result", String.valueOf(count));
		} else {
			parameters.add("result", String.valueOf(20));
		}
		
		if (viewContent) {
			parameters.add("viewContent", "Y");
		}
		
		JsonNode response = restTemplate.getForObject(buildUri("/post/list.do", parameters), JsonNode.class);

		return convertToPosts(response);
	}

	@Override
	public int post(String blogName, Post post) {

		return post(blogName, post, null);
	}

	@Override
	public int post(String blogName, Post post, String file) {
		
		requireAuthorization();
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String> ();

		parameters.add("blogName", blogName);
		parameters.add("title", post.getTitle());
		parameters.add("content", post.getContent());
		parameters.add("tag", post.getTag());
		parameters.add("open", post.getOpenType());
		
		if (post.getViewCategoryId() > 0) {
			parameters.add("viewCategoryId", String.valueOf(post.getViewCategoryId()));
		}
		if (post.getCategoryId() > 0) {
			parameters.add("categoryId", String.valueOf(post.getCategoryId()));
		}
		
		if (StringUtils.hasText(file)) {

			Attachment attachment = upload(blogName, file);
			parameters.add("fileName", attachment.getFileName());
			parameters.add("fileType", attachment.getFileType());
			parameters.add("fileSize", String.valueOf(attachment.getFileSize()));
			parameters.add("fileUrl", attachment.getFileUrl());
		}

		JsonNode response = restTemplate.postForObject(buildUriWithoutParameters("/post/write.do"), mergeParameters(parameters), JsonNode.class);

		return extractPostId(response);
	}

	@Override
	public int update(String blogName, Post post) {
		
		requireAuthorization();
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String> ();
		parameters.add("blogName", blogName);
		parameters.add("postId", String.valueOf(post.getPostId()));
		parameters.add("title", post.getTitle());
		parameters.add("content", post.getContent());
		parameters.add("tag", post.getTag());
		parameters.add("open", post.getOpenType());
		
		if (post.getViewCategoryId() > 0) {
			parameters.add("viewCategoryId", String.valueOf(post.getViewCategoryId()));
		}
		if (post.getCategoryId() > 0) {
			parameters.add("categoryId", String.valueOf(post.getCategoryId()));
		}
		
		JsonNode response = restTemplate.postForObject(buildUriWithoutParameters("/post/modify.do"), mergeParameters(parameters), JsonNode.class);
		
		return extractPostId(response);
	}

	@Override
	public Post view(String blogName, int postId) {
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String> ();
		parameters.add("blogName", blogName);
		parameters.add("postId", String.valueOf(postId));
		
		JsonNode response = restTemplate.getForObject(buildUri("/post/read.do", parameters), JsonNode.class);

		return convertToPost(response, POST_CONVERT_TYPE_VIEW);
	}

	@Override
	public Attachment upload(String blogName, String file) {
		
		requireAuthorization();
		
		if (!StringUtils.hasText(file)) {
			return null;
		}

		FileSystemResource resource = new FileSystemResource(file);
		
		if (!resource.exists()) {
			return null;
		}
		
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object> ();
		parameters.add("blogName", blogName);
		parameters.add("output", OUTPUT_FORMAT);
		parameters.add("file", resource);

		JsonNode response = restTemplate.postForObject(buildUriWithoutParameters("/post/uploadFile.do"), parameters, JsonNode.class);

		String fileName = resource.getFilename();
		String fileType = exchangeDaumFileType(extractExtension(fileName));
		long fileSize = 0;
		try {
			fileSize = resource.contentLength();
		} catch (IOException e) {
		}
		
		return convertToAttachment(response, fileName, fileType, fileSize);
	}
	
	private int extractPostId(JsonNode response) {
		return Integer.parseInt(extractNecessaryNode(response).path(N_POST_ID).textValue());
	}
	
	private List<Post> convertToPosts(JsonNode response) {

		List<Post> posts = null;
		
		JsonNode items = extractNecessaryNode(response).path(N_ITEM);
		
		Iterator<JsonNode> iterator = items.elements();
		
		while (iterator.hasNext()) {
			if (posts == null) {
				posts = new ArrayList<Post> ();
			}
			posts.add(convertToPost(iterator.next(), POST_CONVERT_TYPE_LIST));
		}
		
		return posts;
	}
	
	private Post convertToPost(JsonNode jsonNode, int convertType) {
		
		Post post = new Post();
		
		JsonNode nodeToUse = null;
		
		if (convertType == POST_CONVERT_TYPE_VIEW) {
			nodeToUse = extractNecessaryNode(jsonNode);
			post.setScrapPrmtKind(nodeToUse.path(N_SCRAP_PRMT_KIND).textValue());
			Post pre = convertToPost(nodeToUse.path(N_PREVIOUS_POST), POST_CONVERT_TYPE_SIDE);
			Post next = convertToPost(nodeToUse.path(N_NEXT_POST), POST_CONVERT_TYPE_SIDE);
			if (pre != null) {
				post.setPreviousPost(pre);
			}
			if (next != null) {	
				post.setNextPost(next);
			}
		} else {
			nodeToUse = jsonNode;
		}
		
		if (convertType == POST_CONVERT_TYPE_SIDE) {
			post.setPostId(Integer.parseInt(nodeToUse.path(N_ID).textValue()));
		} else {			
			post.setPostId(Integer.parseInt(nodeToUse.path(N_POST_ID).textValue()));
		}
		post.setTitle(nodeToUse.path(N_TITLE).textValue());
		post.setContent(nodeToUse.path(N_CONTENT).textValue());
		post.setUrl(nodeToUse.path(N_URL).textValue());
		post.setNickname(nodeToUse.path(N_NICKNAME).textValue());
		post.setScrap("Y".equals(nodeToUse.path(N_IS_SCRAP).textValue()) ? true : false);
		post.setOpenType(nodeToUse.path(N_OPEN).textValue());
		if (StringUtils.hasText(nodeToUse.path(N_COMMENTS).textValue())) {			
			post.setCommentCount(Integer.parseInt(nodeToUse.path(N_COMMENTS).textValue()));
		}
		if (StringUtils.hasText(nodeToUse.path(N_TRACKBACKS).textValue())) {			
			post.setTrackbackCount(Integer.parseInt(nodeToUse.path(N_TRACKBACKS).textValue()));
		}
		if (nodeToUse.path(N_VIEW_CATEGORY_ID).textValue() != null) {
			post.setViewCategoryId(Integer.parseInt(nodeToUse.path(N_VIEW_CATEGORY_ID).textValue()));
		}
		if (nodeToUse.path(N_VIEW_ID).textValue() != null) {			
			post.setViewId(Integer.parseInt(nodeToUse.path(N_VIEW_ID).textValue()));
		}
		try {
			if (StringUtils.hasText(nodeToUse.path(N_DATE).textValue())) {
				String format = null;
				if (convertType == POST_CONVERT_TYPE_VIEW) {
					format = "yyyy.MM.dd";
				} else {					
					format = "yyyy-MM-dd HH:mm:ss";
				}
				post.setPostTime(new SimpleDateFormat(format).parse(nodeToUse.path(N_DATE).textValue()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (StringUtils.hasText(nodeToUse.path(N_CATEGORY_ID).textValue())) {			
			post.setCategoryId(Integer.parseInt(nodeToUse.path(N_CATEGORY_ID).textValue()));
		}
		if (StringUtils.hasText(nodeToUse.path(N_CATEGORY_NAME).textValue())) {			
			post.setCategoryName(nodeToUse.path(N_CATEGORY_NAME).textValue());
		}
		
		return post;
	}

	private Attachment convertToAttachment(JsonNode response, String fileName, String fileType, long fileSize) {
		
		String fileUrl = extractNecessaryNode(response).path(N_URL).textValue();
		Attachment attachment = new Attachment(fileName, fileType, fileSize, fileUrl);

		return attachment;
	}
	
	/**
	 * 파일명의 확장자를 통해 Daum이 지정한 파일 타입으로 바꿈
	 * 
	 * @param fileType 파일명의 확장자
	 * @return Daum이 지정한 파일 타입
	 */
	private String exchangeDaumFileType(String fileType) {

		String lowerCase = fileType.toLowerCase();
		if ("jpg".equals(lowerCase) || "gif".equals(lowerCase) || "png".equals(lowerCase)) {
			return Attachment.FILE_TYPE_IMAGE;
		}
		
		return Attachment.FILE_TYPE_OTHER;
	}
	
	/**
	 * 파일명의 확장자를 가져옴
	 * @param fileName 파일명
	 * @return 확장자
	 */
	private String extractExtension(String fileName) {
		
		String[] splitedFileName = fileName.split("\\.");
		
		return splitedFileName[splitedFileName.length - 1];
	}
}
