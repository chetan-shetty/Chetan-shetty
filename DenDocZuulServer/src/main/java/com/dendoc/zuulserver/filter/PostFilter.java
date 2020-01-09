package com.dendoc.zuulserver.filter;

import java.util.logging.Logger;

import com.netflix.zuul.ZuulFilter;

public class PostFilter extends ZuulFilter {
	
	Logger logger = Logger.getLogger(PostFilter.class.getName());

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		logger.info("Using Post Filter");

		return null;
	}

}