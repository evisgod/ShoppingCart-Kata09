package com.idealo.shoppingcart.service;

import java.util.List;

@FunctionalInterface
public interface Pricing {
	
	/**
	 * Returns the total price corresponding to a list of SKU's.
	 */
	int totalPrice(List<String> skuList);
	
}