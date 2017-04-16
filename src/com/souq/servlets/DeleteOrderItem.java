package com.souq.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souq.db.DB;

/**
 * Servlet implementation class DeleteOrder
 */
@WebServlet("/DeleteOrderItem")
public class DeleteOrderItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteOrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DB db = new DB();
		try {
			String[] ids = request.getParameter("idList").split("-");

			db.deleteOrderItems(ids);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
