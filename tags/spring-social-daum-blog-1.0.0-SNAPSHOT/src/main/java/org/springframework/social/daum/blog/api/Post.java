/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 10:57:08
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

import java.util.Date;

/**
 * @author Seongju-Jo
 *
 */
public class Post {

	public static final String OPEN_PUBLIC = "Y";
	public static final String OPEN_PRIVATE = "N";
	public static final String OPEN_FRIEND = "F";
	
	private int postId;
	
	private String url;
	
	private String title;
	
	private String content;
	
	private String tag;
	
	private int categoryId;
	
	private String categoryName;
	
	private String nickname;
	
	private Date postTime;
	
	private String openType = OPEN_PUBLIC;
	
	private boolean scrap;
	
	private String scrapPrmtKind;
	
	private int commentCount;
	
	private int trackbackCount;
	
	private int viewCategoryId;
	
	private int viewId;
	
	private Post nextPost;
	
	private Post previousPost;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public boolean isScrap() {
		return scrap;
	}

	public void setScrap(boolean scrap) {
		this.scrap = scrap;
	}

	public String getScrapPrmtKind() {
		return scrapPrmtKind;
	}

	public void setScrapPrmtKind(String scrapPrmtKind) {
		this.scrapPrmtKind = scrapPrmtKind;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getTrackbackCount() {
		return trackbackCount;
	}

	public void setTrackbackCount(int trackbackCount) {
		this.trackbackCount = trackbackCount;
	}

	public int getViewCategoryId() {
		return viewCategoryId;
	}

	public void setViewCategoryId(int viewCategoryId) {
		this.viewCategoryId = viewCategoryId;
	}

	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}

	public Post getNextPost() {
		return nextPost;
	}

	public void setNextPost(Post nextPost) {
		this.nextPost = nextPost;
	}

	public Post getPreviousPost() {
		return previousPost;
	}

	public void setPreviousPost(Post previousPost) {
		this.previousPost = previousPost;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", url=" + url + ", title=" + title
				+ ", content=" + content + ", tag=" + tag + ", categoryId="
				+ categoryId + ", categoryName=" + categoryName + ", nickname="
				+ nickname + ", postTime=" + postTime + ", openType="
				+ openType + ", scrap=" + scrap + ", scrapPrmtKind="
				+ scrapPrmtKind + ", commentCount=" + commentCount
				+ ", trackbackCount=" + trackbackCount + ", viewCategoryId="
				+ viewCategoryId + ", viewId=" + viewId + ", nextPost="
				+ nextPost + ", previousPost=" + previousPost + "]";
	}
}
