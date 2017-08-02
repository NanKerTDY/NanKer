package com.ztb.nanke.base;

import java.io.Serializable;
import java.util.List;

public class Store implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String storeName;
	private List<Product> products;
	
	public Store(String storeName) {
		super();
		this.storeName = storeName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Store [storeName=" + storeName + ", products=" + products + "]";
	}
	
}
