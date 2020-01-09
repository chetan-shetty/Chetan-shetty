package com.dendoc.zuulserver.filter;

import java.util.logging.Logger;

import com.netflix.zuul.ZuulFilter;

public class RouteFilter extends ZuulFilter {
	
	Logger logger = Logger.getLogger(RouteFilter.class.getName());

	@Override
	public String filterType() {
		return "route";
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