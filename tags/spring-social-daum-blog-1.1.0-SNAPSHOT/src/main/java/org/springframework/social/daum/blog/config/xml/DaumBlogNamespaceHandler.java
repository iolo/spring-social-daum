/*
 * This file was created by Seongju-Jo on 2013. 7. 23. 오전 12:45:18
 * Copyright 2013 Seongju-Jo (seongjujo@gmail.com) All Rights Reserved. 
 */
package org.springframework.social.daum.blog.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.AbstractProviderConfigNamespaceHandler;

/**
 * @author Seongju
 *
 */
public class DaumBlogNamespaceHandler extends AbstractProviderConfigNamespaceHandler {

	@Override
	protected AbstractProviderConfigBeanDefinitionParser getProviderConfigBeanDefinitionParser() {
		
		return new DaumBlogConfigBeanDefinitionParser();
	}
}
