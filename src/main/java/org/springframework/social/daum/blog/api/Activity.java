/*
 * This file was created by Seongju-Jo on 2013. 4. 4. 오후 5:39:38
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

import java.util.Date;

/**
 * @author Seongju-Jo
 *
 */
public class Activity {

	private String type;
	
	private int postId;

	private String title;

	private String description;
	
	private String author;
	
	private Date pubTime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
}
