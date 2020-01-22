package com.idealo.shoppingcart.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.idealo.shoppingcart.model.Item;
import com.idealo.shoppingcart.model.Offer;
import com.idealo.shoppingcart.model.Sku;
import com.idealo.shoppingcart.service.PricingService;

public class PricingRulesServiceTest {

	@Test
	public void testUnitPrice() {
		Map<String, Item> priceRules = new HashMap<>();
		priceRules.put("A", new Item(new Sku("A", 40)));

		PricingService service = new PricingService(priceRules);
		assertEquals(40, service.totalPrice(Arrays.asList("A")));
		assertEquals(80, service.totalPrice(Arrays.asList("A", "A")));
		assertEquals(160, service.totalPrice(Arrays.asList("A", "A", "A", "A")));
	}

	@Test
	public void testSpecialPrice() {
		Map<String, Item> priceRules = new HashMap<>();
		priceRules.put("A", new Item(new Sku("A", 40), new Offer(3, 100)));

		PricingService service = new PricingService(priceRules);
		assertEquals(40, service.totalPrice(Arrays.asList("A")));
		assertEquals(80, service.totalPrice(Arrays.asList("A", "A")));
		assertEquals(100, service.totalPrice(Arrays.asList("A", "A", "A")));
		assertEquals(140, service.totalPrice(Arrays.asList("A", "A", "A", "A")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIfRuleNotFound() {
		PricingService service = new PricingService(new HashMap<>());
		assertEquals(40, service.totalPrice(Arrays.asList("A")));
	}

	@Test
	public void testNegativePrice() {
		Map<String, Item> priceRules = new HashMap<>();
		priceRules.put("A", new Item(new Sku("A", 0)));

		PricingService service = new PricingService(priceRules);
		assertEquals(0, service.totalPrice(Arrays.asList("A")));
		assertEquals(0, service.totalPrice(Arrays.asList("A", "A")));
		assertEquals(0, service.totalPrice(Arrays.asList("A", "A", "A")));
	}
}