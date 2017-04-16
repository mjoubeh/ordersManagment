package com.souq.bean;

public class CustomerBean {

	private long id;
	private String name;

	@Override
	public String toString() {
		return "CustomerBean [id=" + id + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
