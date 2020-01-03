package com.idealo.shoppingcart.backend;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.idealo.shoppingcart.domain.PricingRule;

/**
 * This class is the implementation of IPricingRules Interface and process the
 * given data.
 * 
 * @author Vishnu
 * 
 */
public class PricingRulesImpl implements IPricingRules {

	private Map<String, PricingRule> pricing_rules;

	public PricingRulesImpl(Map<String, PricingRule> pricing) {
		this.pricing_rules = pricing;
	}

	@Override
	public int totalPrice(List<String> sku) {
		return sku.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream()
				.map(i -> calculatePrice(i.getKey(), i.getValue())).mapToInt(Integer::intValue).sum();

	}

	/**
	 * @param sku
	 * @param quantity
	 * @return Price corresponding to given sku.
	 */
	private int calculatePrice(String sku, Long quantity) {
		if (!pricing_rules.containsKey(sku))
			throw new IllegalArgumentException("No price found for this:" + sku);

		PricingRule items = pricing_rules.get(sku);

		int totalQuantity = items.getOffer().getOfferedQuantity();
		int specialPrice = items.getOffer().getSpecialPrice();
		int unitPrice = items.getSku().getUnitPrice();

		int discountedQuantity = (int) (quantity / totalQuantity);
		int remainingQuantity = (int) (quantity % totalQuantity);
		return discountedQuantity * specialPrice + remainingQuantity * unitPrice;

	}
}