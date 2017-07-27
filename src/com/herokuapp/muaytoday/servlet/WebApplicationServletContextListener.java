package com.herokuapp.muaytoday.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApplicationServletContextListener implements ServletContextListener {
	private static Logger logger = LoggerFactory.getLogger(WebApplicationServletContextListener.class);

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		logger.info("##### Muaytoday ContextInitialized #####");
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		logger.info("##### Muaytoday ContextDestroyed #####");
	}
}