package com.idealo.shoppingcart.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.idealo.shoppingcart.model.Item;

/**
 * This class is the implementation of Pricing Interface and process the
 * given SKU's w.r.t pricing rules.
 * 
 * @author Vishnu
 * 
 */
public class PricingService implements Pricing {

	private Map<String, Item> pricingRules;

	public PricingService(Map<String, Item> pricingRules) {
		this.pricingRules = pricingRules;
	}
	
	@Override
	public int totalPrice(List<String> skuList) {
		return skuList.stream()
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()))
				.entrySet().stream()
				.map(i -> calculatePrice(i.getKey(), i.getValue()))
				.mapToInt(Integer::intValue)
				.sum();
	}

	/**
	 * @param sku
	 * @param quantity
	 * @return Price corresponding to given sku.
	 */
	private int calculatePrice(String skuId, long quantity) {
		if (!pricingRules.containsKey(skuId))
			throw new IllegalArgumentException("No price found for the item:" + skuId);

		Item items = pricingRules.get(skuId);

		int offeredQuantity = items.getOffer().getOfferedQuantity();
		int specialPrice = items.getOffer().getSpecialPrice();
		int unitPrice = items.getSku().getUnitPrice();

		int discountedQuantity = (int) (quantity / offeredQuantity);
		int remainingQuantity = (int) (quantity % offeredQuantity);
		return discountedQuantity * specialPrice + remainingQuantity * unitPrice;
	}
}