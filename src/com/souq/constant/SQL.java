package com.souq.constant;

public interface SQL {

	String LOAD_ORDERS = "select * from orders ";

	String ADD_ORDER = "insert into orders (order_name, grand_total) values (?,?)";

	String DELETE_ORDER = "delete from orders where order_id = ?";

	String UPDATE_ORDER = "update orders set order_name=?, grand_total=? where order_id=?";

	
	String LOAD_CUSTOMERS = "select * from customers";

	String ADD_CUSTOMER = "insert into customers (customer_name) values (?)";

	String DELETE_CUSTOMER = "delete from customers where customer_id = ?";

	String UPDATE_CUSTOMER = "update customers set customer_name=? where customer_id = ?";

	
	String LOAD_PRODUCTS = "select * from products";

	String ADD_PRODUCT = "insert into products (name, price) values (?, ?)";

	String DELETE_PRODUCT = "delete from products where id = ?";

	String UPDATE_PRODUCT = "update products set name=?, price=? where id = ?";

	
	String LOAD_ITEM = "select * from order_item";

	String ADD_ITEM = "insert into order_item (id, status, quantity, price) values (?, ?, ?, ?)";

	String DELETE_ITEM = "delete from order_item where id = ?";

	String UPDATE_ITEM = "update order_item set status=?, quantity=?, price=? where id = ?";

}
