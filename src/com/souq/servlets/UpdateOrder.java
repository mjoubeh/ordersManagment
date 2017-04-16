package com.souq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souq.bean.OrderBean;
import com.souq.db.DB;

/**
 * Servlet implementation class UpdateOrder
 */
@WebServlet("/UpdateOrder")
public class UpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DB db = new DB();

		try {
			OrderBean order = new OrderBean();
			order.setOrderId(Long.parseLong(request.getParameter("id")));
			order.setOrderName(request.getParameter("name"));
			order.setGrandTotal(Double.parseDouble(request.getParameter("total")));

			db.updateOrder(order);
			out.write("1");
		} catch (Exception ex) {
			ex.printStackTrace();
			out.write("0");
		} finally {
			out.flush();
			out.close();
		}

	}

}
