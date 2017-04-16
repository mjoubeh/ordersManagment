package com.souq.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.softengine.db.DBController;
import com.souq.bean.CustomerBean;
import com.souq.bean.ItemBean;
import com.souq.bean.OrderBean;
import com.souq.bean.ProductBean;
import com.souq.constant.SQL;

public class DB {

	private DBController controller;

	public DB() {
		controller = new DBController();
	}

	private Connection getConn(String dbName) throws Exception {
		Connection conn = null;

		try {
			conn = controller.getDBConnection(dbName);
		} catch (Exception ex) {
			throw ex;
		}

		return conn;
	}

	public ArrayList<OrderBean> getOrders() throws Exception {

		ArrayList<OrderBean> ordersList = new ArrayList<OrderBean>();

		try (Connection conn = getConn("souq");
				PreparedStatement pstmt = conn.prepareStatement(SQL.LOAD_ORDERS);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				OrderBean order = new OrderBean();
				order.setOrderId(rs.getLong(1));
				order.setOrderName(rs.getString(2));
				order.setGrandTotal(rs.getDouble(3));
				ordersList.add(order);

			}

		} catch (Exception ex) {
			throw ex;
		}
		return ordersList;
	}

	public void addOrder(OrderBean order) throws Exception {

		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.ADD_ORDER)) {
			pstmt.setString(1, order.getOrderName());
			pstmt.setDouble(2, order.getGrandTotal());
			pstmt.execute();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void deleteOrders(String[] ids) throws Exception {
		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.DELETE_ORDER)) {
			for (String id : ids) {
				pstmt.setLong(1, Long.parseLong(id));
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void updateOrder(OrderBean order) throws Exception {
		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.UPDATE_ORDER)) {

			pstmt.setLong(3, order.getOrderId());
			pstmt.setString(1, order.getOrderName());
			pstmt.setDouble(2, order.getGrandTotal());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw ex;
		}

	}

	public ArrayList<CustomerBean> getCustomers() throws Exception {

		ArrayList<CustomerBean> customersList = new ArrayList<CustomerBean>();

		try (Connection conn = getConn("souq");
				PreparedStatement pstmt = conn.prepareStatement(SQL.LOAD_CUSTOMERS);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				CustomerBean customer = new CustomerBean();
				customer.setId(rs.getLong(1));
				customer.setName(rs.getString(2));

				customersList.add(customer);

			}

		} catch (Exception ex) {
			throw ex;
		}
		return customersList;
	}

	public void addCustomer(CustomerBean customer) throws Exception {
		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.ADD_CUSTOMER)) {
			pstmt.setString(1, customer.getName());

			pstmt.execute();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void deleteCustomer(String[] ids) throws Exception {
		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.DELETE_CUSTOMER)) {
			for (String id : ids) {
				pstmt.setLong(1, Long.parseLong(id));
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void updateCustomer(CustomerBean customer) throws Exception {
		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.UPDATE_CUSTOMER)) {

			pstmt.setLong(2, customer.getId());
			pstmt.setString(1, customer.getName());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw ex;
		}

	}

	public ArrayList<ProductBean> getProducts() throws Exception {

		ArrayList<ProductBean> productsList = new ArrayList<ProductBean>();

		try (Connection conn = getConn("souq");
				PreparedStatement pstmt = conn.prepareStatement(SQL.LOAD_PRODUCTS);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				ProductBean product = new ProductBean();
				product.setId(rs.getLong(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				productsList.add(product);

			}

		} catch (Exception ex) {
			throw ex;
		}
		return productsList;
	}

	public void addProduct(ProductBean product) throws Exception {

		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.ADD_PRODUCT)) {
			pstmt.setString(1, product.getName());
			pstmt.setDouble(2, product.getPrice());
			pstmt.execute();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void deleteProducts(String[] ids) throws Exception {
		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.DELETE_PRODUCT)) {
			for (String id : ids) {
				pstmt.setLong(1, Long.parseLong(id));
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void updateProduct(ProductBean product) throws Exception {
		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.UPDATE_PRODUCT)) {

			pstmt.setLong(3, product.getId());
			pstmt.setString(1, product.getName());
			pstmt.setDouble(2, product.getPrice());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw ex;
		}

	}

	public ArrayList<ItemBean> getOrderItems() throws Exception {

		ArrayList<ItemBean> itemsList = new ArrayList<ItemBean>();

		try (Connection conn = getConn("souq");
				PreparedStatement pstmt = conn.prepareStatement(SQL.LOAD_ITEM);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				ItemBean item = new ItemBean();
				item.setId(rs.getLong(1));

				if (1 == rs.getInt(2))
					item.setStatus("active");
				else
					item.setStatus("canceled");
				item.setQuantity(rs.getInt(3));
				item.setPrice(rs.getDouble(4));

				itemsList.add(item);

			}

		} catch (Exception ex) {
			throw ex;
		}
		return itemsList;
	}

	public void addOrderItems(ItemBean item) throws Exception {

		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.ADD_ITEM)) {
			pstmt.setLong(1, item.getId());
			if ("active".equals(item.getStatus()))
				pstmt.setInt(2, 1);
			else
				pstmt.setInt(2, 0);
			pstmt.setInt(3, item.getQuantity());
			pstmt.setDouble(4, item.getPrice());
			pstmt.execute();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void deleteOrderItems(String[] ids) throws Exception {
		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.DELETE_ITEM)) {
			for (String id : ids) {
				pstmt.setLong(1, Long.parseLong(id));
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void updateItem(ItemBean item) throws Exception {
		try (Connection conn = getConn("souq"); PreparedStatement pstmt = conn.prepareStatement(SQL.UPDATE_ITEM)) {

			pstmt.setLong(4, item.getId());
			if ("active".equals(item.getStatus()))
				pstmt.setInt(1, 1);
			else
				pstmt.setInt(1, 0);
			pstmt.setInt(2, item.getQuantity());
			pstmt.setDouble(3, item.getPrice());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw ex;
		}

	}

}
