package com.souq.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souq.bean.ItemBean;
import com.souq.bean.OrderBean;
import com.souq.db.DB;

/**
 * Servlet implementation class AddOrder
 */
@WebServlet("/AddOrderItem")
public class AddOrderItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ItemBean item = new ItemBean();
		DB db = new DB();
		PrintWriter out = response.getWriter();

		try {
			item.setStatus(request.getParameter("status"));
			item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			item.setPrice(Double.parseDouble(request.getParameter("price")));
			item.setId(Long.parseLong(request.getParameter("id")));
			db.addOrderItems(item);
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
