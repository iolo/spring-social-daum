/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 10:08:08
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api;

/**
 * @author Seongju-Jo
 *
 */
public class Category {

	private int categoryId;	// categoryId	integer		카테고리 ID
	
	private String name;		// name			string		카테고리 이름
	
	private boolean open;		// open			string		카테고리 공개 상태

	public Category() {
		
	}
	
	public Category(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public Category(int categoryId, String name) {
		this(categoryId, name, true);
	}
	
	public Category(int categoryId, String name, boolean open) {
		this.categoryId = categoryId;
		this.name = name;
		this.open = open;
	}
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name
				+ ", open=" + open + "]";
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
}
