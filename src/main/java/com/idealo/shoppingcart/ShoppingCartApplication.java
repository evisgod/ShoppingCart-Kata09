package com.idealo.shoppingcart;

import com.idealo.shoppingcart.config.Config;
import com.idealo.shoppingcart.config.DefaultPricingRules;
import com.idealo.shoppingcart.service.Checkout;

/**
 * Applications class with main method.
 * 
 * @author Vishnu
 * 
 */
public class ShoppingCartApplication {
	public static void main(String[] args) {
		final String cartItems = Config.get("items");
		Checkout checkout = new Checkout(DefaultPricingRules.getPricingRules());

		for (int i = 0; i < cartItems.length(); i++) {
			checkout.scan(String.valueOf(cartItems.charAt(i)));
		}
		int totalPrice = checkout.total();
		System.out.println("Total Price:" + totalPrice);
	}
}