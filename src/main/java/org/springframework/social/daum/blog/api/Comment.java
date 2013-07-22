/*
 * This file was created by Seongju-Jo on 2013. 4. 4. 오후 4:19:58
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

import java.util.Date;

/**
 * @author Seongju-Jo
 *
 */
public class Comment {

	private int commentId;
	
	private String content;
	
	private String name;
	
	private Date commentTime;
	
	private String url;
	
	private int parentId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", content=" + content
				+ ", name=" + name + ", commentTime=" + commentTime + ", url="
				+ url + ", parentId=" + parentId + "]";
	}
}
