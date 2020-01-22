/**
 * 
 */
package com.idealo.shoppingcart.service;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is the backbone for entire application and process the items with
 * given pricing rules.
 * @author Vishnu
 *
 */
public class Checkout {
	private List<String> skuList = new LinkedList<String>();
	private final Pricing pricingRule;

	/**
	 * @param pricingRules
	 */
	public Checkout(Pricing pricingRules) {
		pricingRule = pricingRules;
	}

	/**
	 * This method adds the items to cart.
	 * 
	 * @param skuId
	 */
	public void scan(String skuId) {
		skuList.add(skuId);
	}

	/**
	 * This method calculates the total price corresponding the scanned items in the
	 * cart.
	 * 
	 * @return total price of the cart after checkout.
	 */
	public int total() {
		return pricingRule.totalPrice(skuList);
	}
}