package com.souq.db;

import javax.servlet.ServletContext;

public class ConnectionLoader {

	private static final String DB_DRIVER = "db_driver";
	private static final String DB_URL = "db_url";
	private static final String DB_USER = "db_user";
	private static final String DB_PASS = "db_pass";
	private static final String DB_NAME = "db_name";
	private static final String DB_USE_UNICODE = "db_useunicode";
	private static final String DB_ENCODING = "db_encoding";
	private static final String DB_CONN_NAME = "db_connName";
	private static final String DB_CONN_POOL = "db_connPool";

	public static void createConnctionPool(ServletContext context) {

		try {
			int poolSize = 1;
			poolSize = Integer.parseInt(context.getInitParameter(DB_CONN_POOL));

			int i = 1;
			while (context.getInitParameter(DB_URL + i) != null) {

				new com.softengine.db.DBConnectionDriver(context.getInitParameter(DB_DRIVER), context.getInitParameter(DB_URL + i), context.getInitParameter(DB_USER + i),
						context.getInitParameter(DB_PASS + i), context.getInitParameter(DB_NAME + i), context.getInitParameter(DB_USE_UNICODE), context.getInitParameter(DB_ENCODING),
						context.getInitParameter(DB_CONN_NAME + i), poolSize, false);

				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}