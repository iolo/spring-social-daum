/*
 * This file was created by Seongju-Jo on 2013. 7. 23. 오전 12:27:37
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * @author Seongju
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DaumBlogProviderConfigRegistrar.class)
public @interface EnableDaumBlog {

	/**
	 * The application's consumer key as issued by DaumBlog.
	 */
	String appId();
	
	/**
	 * The application's consumer secret as issued by DaumBlog.
	 */
	String appSecret();
}
