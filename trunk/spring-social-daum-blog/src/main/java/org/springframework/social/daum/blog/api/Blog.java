/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 6:44:38
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

/**
 * @author Seongju-Jo
 *
 */
public class Blog {

	private String blogId;							// id							string	블로그 ID
	
	private String blogName;						// name							string	블로그 이름 (http://blog.daum/주소 뒤에 붙는 이름
	
	private String blogTitle;						// title						string	블로그 타이틀
	
	private String nickname;						// nickname						string	닉네임
	
	private String description;					// description					string	설명
	
	private String url;							// url							string	글 주소
	
	private String rssUrl;							// rssUrl						string	RSS주소
	
	private String myconImageUrl;					// myconImageUrl				string	마이콘 이미지 URL
	
	private String profileThumbnailimageUrl;		// profileThumbnailimageUrl		string	프로필 썸네일 이미지 URL
	
	private String profileImageUrl;				// profileImageUrl				string	프로필 원본 이미지 URL
	
	private boolean newGuestbookExists;			// isNewGuestbookExists			string	방명록 새글 여부
	
	private int visitorCount;						// visitorCount					string	오늘 방문자 카운트

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogName=" + blogName
				+ ", blogTitle=" + blogTitle + ", nickname=" + nickname
				+ ", description=" + description + ", url=" + url + ", rssUrl="
				+ rssUrl + ", myconImageUrl=" + myconImageUrl
				+ ", profileThumbnailimageUrl=" + profileThumbnailimageUrl
				+ ", profileImageUrl=" + profileImageUrl
				+ ", newGuestbookExists=" + newGuestbookExists
				+ ", visitorCount=" + visitorCount + "]";
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRssUrl() {
		return rssUrl;
	}

	public void setRssUrl(String rssUrl) {
		this.rssUrl = rssUrl;
	}

	public String getMyconImageUrl() {
		return myconImageUrl;
	}

	public void setMyconImageUrl(String myconImageUrl) {
		this.myconImageUrl = myconImageUrl;
	}

	public String getProfileThumbnailimageUrl() {
		return profileThumbnailimageUrl;
	}

	public void setProfileThumbnailimageUrl(String profileThumbnailimageUrl) {
		this.profileThumbnailimageUrl = profileThumbnailimageUrl;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public boolean isNewGuestbookExists() {
		return newGuestbookExists;
	}

	public void setNewGuestbookExists(boolean newGuestbookExists) {
		this.newGuestbookExists = newGuestbookExists;
	}

	public int getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}
}
