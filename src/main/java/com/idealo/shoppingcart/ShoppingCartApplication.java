package com.idealo.shoppingcart;

import java.util.HashMap;
import java.util.Map;

import com.idealo.shoppingcart.backend.CheckOut;
import com.idealo.shoppingcart.backend.PricingRulesImpl;
import com.idealo.shoppingcart.domain.Offers;
import com.idealo.shoppingcart.domain.PricingRule;
import com.idealo.shoppingcart.domain.Sku;

/**
 * Applications class with main method.
 * 
 * @author Vishnu
 * 
 */
public class ShoppingCartApplication {
	public static void main(String[] args) {
		Map<String, PricingRule> pricing_rules = new HashMap<String, PricingRule>();
		pricing_rules.put("A", new PricingRule(new Sku("A", 40), new Offers(3, 100)));
		pricing_rules.put("B", new PricingRule(new Sku("B", 50), new Offers(2, 80)));
		pricing_rules.put("C", new PricingRule(new Sku("C", 25)));
		pricing_rules.put("D", new PricingRule(new Sku("D", 20)));

		PricingRulesImpl rules = new PricingRulesImpl(pricing_rules);

		CheckOut checkout = new CheckOut(rules);
		String item1 = "A";
		String item2 = "B";
		String item3 = "A";
		String item4 = "B";
		String item5 = "D";
		String item6 = "A";

		checkout.scan(item1);
		checkout.scan(item2);
		checkout.scan(item3);
		checkout.scan(item4);
		checkout.scan(item5);
		checkout.scan(item6);

		int totalPrice = checkout.total();

		System.out.println("Total Price:" + totalPrice);
	}
}
