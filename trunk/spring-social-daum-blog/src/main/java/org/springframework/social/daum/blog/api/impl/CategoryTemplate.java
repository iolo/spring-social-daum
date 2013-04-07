/*
 * This file was created by Seongju-Jo on 2013. 4. 3. 오전 10:13:57
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.api.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.springframework.social.daum.blog.api.Category;
import org.springframework.social.daum.blog.api.CategoryOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Seongju-Jo
 *
 */
public class CategoryTemplate extends AbstractDaumBlogOperations implements CategoryOperations {

	public CategoryTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	@Override
	public List<Category> list(String blogName) {
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String> (1);
		parameters.add("blogName", blogName);
		
		JsonNode response = restTemplate.getForObject(buildUri("/category/list.do", parameters), JsonNode.class);

		return convertToCategories(response);
	}

	private List<Category> convertToCategories(JsonNode response) {
		
		List<Category> categories = null;
		
		JsonNode items = extractNecessaryNode(response).path(N_ITEMS);
		
		Iterator<JsonNode> iterator = items.getElements();
		
		while (iterator.hasNext()) {
			
			if (categories == null) {
				categories = new ArrayList<Category> ();
			}

			categories.add(convertToCategory(iterator.next()));
		}

		return categories;
	}
	
	private Category convertToCategory(JsonNode jsonNode) {
		
		Category category = new Category();
		category.setOpen("OPEN".equals(jsonNode.path(N_OPEN).getTextValue()) ? true : false);
		System.out.println(jsonNode.path(N_CATEGORY_ID).getTextValue());
		category.setCategoryId(Integer.parseInt(jsonNode.path(N_CATEGORY_ID).getTextValue()));
		category.setName(jsonNode.path(N_NAME).getTextValue());
		
		return category;
	}
}
