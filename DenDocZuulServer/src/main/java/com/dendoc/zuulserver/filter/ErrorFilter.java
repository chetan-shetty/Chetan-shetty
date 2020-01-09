package com.dendoc.zuulserver.filter;

import java.util.logging.Logger;

import com.netflix.zuul.ZuulFilter;

public class ErrorFilter extends ZuulFilter {
	
	Logger logger = Logger.getLogger(ErrorFilter.class.getName());

	@Override
	public String filterType() {
		return "error";
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
		logger.info("Using Route Filter");

		return null;
	}

}