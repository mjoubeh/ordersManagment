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
 * Servlet implementation class AddOrder
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerBean customer = new CustomerBean();
		DB db = new DB();
		PrintWriter out = response.getWriter();

		try {
			customer.setName(request.getParameter("name"));

			db.addCustomer(customer);
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
