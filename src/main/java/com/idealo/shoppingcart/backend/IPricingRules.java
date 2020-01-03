package com.idealo.shoppingcart.backend;

import java.util.List;

/**
 * Interface provides the total price calculation based on the items price and special 
 * price corresponding to them.
 * @author Vishnu
 * 
 */
public interface IPricingRules {
	
	/**
	 * Returns the total price corresponding to  a list of SKU's.
	 * @param sku
	 * @return price
	 */
	int totalPrice(List<String> sku);
	
}
