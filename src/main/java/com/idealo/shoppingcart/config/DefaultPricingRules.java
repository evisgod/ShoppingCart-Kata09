package com.idealo.shoppingcart.config;

import java.util.HashMap;
import java.util.Map;

import com.idealo.shoppingcart.model.Item;
import com.idealo.shoppingcart.model.Offer;
import com.idealo.shoppingcart.model.Sku;
import com.idealo.shoppingcart.service.PricingService;

public class DefaultPricingRules {

	public static PricingService getPricingRules() {
		Map<String, Item> pricingRulesMap = new HashMap<String, Item>();
		pricingRulesMap.put("A", new Item(new Sku("A", 40), new Offer(3, 100)));
		pricingRulesMap.put("B", new Item(new Sku("B", 50), new Offer(2, 80)));
		pricingRulesMap.put("C", new Item(new Sku("C", 25)));
		pricingRulesMap.put("D", new Item(new Sku("D", 20)));
		return new PricingService(pricingRulesMap);
	}
}