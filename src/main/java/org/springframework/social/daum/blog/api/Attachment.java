/*
 * This file was created by Seongju-Jo on 2013. 4. 4. 오전 11:12:19
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

/**
 * @author Seongju-Jo
 *
 */
public class Attachment {
	
	public final static String FILE_TYPE_IMAGE = "im";
	public final static String FILE_TYPE_OTHER = "fi";

	/**
	 * 첨부 파일명
	 */
	private String fileName;
	
	/**
	 * 파일 URL
	 * Daum 파일팜 서버에 있는 URL만 됩니다. (이미 블로그에 올라가 있는 파일)
	 * 예) http://cfile209.uf.daum.net/C165x165/174A6C504D8FD5EC1AF8C7
	 */
	private String fileUrl;
	
	/**
	 * 파일사이즈
	 */
	private long fileSize;
	
	/**
	 * 파일 type. (이미지: im, 기타 파일: fi)
	 */
	private String fileType;

	public Attachment(String fileName, String fileType, long fileSize, String fileUrl) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.fileUrl = fileUrl;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "Attachment [fileName=" + fileName + ", fileUrl=" + fileUrl
				+ ", fileSize=" + fileSize + ", fileType=" + fileType + "]";
	}
}
