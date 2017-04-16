package com.souq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souq.bean.CustomerBean;
import com.souq.bean.OrderBean;
import com.souq.db.DB;

/**
 * Servlet implementation class UpdateOrder
 */
@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustomer() {
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
			CustomerBean customer = new CustomerBean();
			customer.setId(Long.parseLong(request.getParameter("id")));
			customer.setName(request.getParameter("name"));

			db.updateCustomer(customer);
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
