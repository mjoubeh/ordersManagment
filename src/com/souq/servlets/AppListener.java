package com.souq.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.souq.db.ConnectionLoader;

public class AppListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {

		ServletContext context = sce.getServletContext();

		context.removeAttribute("partnersDataMap");
		context.removeAttribute("partnersDataMap2");
	}

	public void contextInitialized(ServletContextEvent sce) {

		try {

			ConnectionLoader.createConnctionPool(sce.getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}