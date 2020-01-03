/**
 * 
 */
package com.idealo.shoppingcart.backend;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is the backbone for entire shoppincart application and process the
 * items with given pricing_rules.
 * 
 * @author Vishnu
 *
 */
public class CheckOut {
	private List<String> sku = new LinkedList<String>();
	private final IPricingRules rules;

	/**
	 * @param pricing_rules
	 */
	public CheckOut(IPricingRules pricing_rules) {
		this.rules = pricing_rules;
	}

	/**
	 * This method adds the items to cart.
	 * 
	 * @param sku
	 */
	public void scan(String s) {
		sku.add(s);
	}

	/**
	 * This method calculate the total price corresponding the scanned items in the
	 * cart.
	 * 
	 * @return total price of the cart after checkout.
	 */
	public int total() {
		return rules.totalPrice(sku);
	}
}
