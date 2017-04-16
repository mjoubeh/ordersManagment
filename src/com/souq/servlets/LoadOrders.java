package com.souq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.souq.db.DB;

/**
 * Servlet implementation class LoadOrders
 */

public class LoadOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadOrders() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		DB db = new DB();

		Gson json = new Gson();

		try {

			out.write(json.toJson(db.getOrders()).toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}

	}

}
