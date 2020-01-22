package com.idealo.shoppingcart.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.idealo.shoppingcart.model.Item;
import com.idealo.shoppingcart.model.Offer;
import com.idealo.shoppingcart.model.Sku;
import com.idealo.shoppingcart.service.Checkout;
import com.idealo.shoppingcart.service.PricingService;

public class CheckOutTest {
	public int calculatePrice(String items) {
		Checkout checkout = new Checkout(testPricingRules());
		for (int i = 0; i < items.length(); i++) {
			checkout.scan(String.valueOf(items.charAt(i)));
		}
		return checkout.total();
	}

	@Test
	public void totals() {
		assertEquals(0, calculatePrice(""));
		assertEquals(40, calculatePrice("A"));
		assertEquals(90, calculatePrice("AB"));
		assertEquals(135, calculatePrice("CDBA"));
		assertEquals(80, calculatePrice("AA"));
		assertEquals(100, calculatePrice("AAA"));
		assertEquals(140, calculatePrice("AAAA"));
		assertEquals(180, calculatePrice("AAAAA"));
		assertEquals(200, calculatePrice("AAAAAA"));
		assertEquals(150, calculatePrice("AAAB"));
		assertEquals(180, calculatePrice("AAABB"));
		assertEquals(200, calculatePrice("AAABBD"));
		assertEquals(200, calculatePrice("DABABA"));
	}

	@Test
	public void incremental() {
		Checkout checkOut = new Checkout(testPricingRules());
		assertEquals(0, checkOut.total());
		checkOut.scan("A");
		assertEquals(40, checkOut.total());
		checkOut.scan("B");
		assertEquals(90, checkOut.total());
		checkOut.scan("A");
		assertEquals(130, checkOut.total());
		checkOut.scan("A");
		assertEquals(150, checkOut.total());
		checkOut.scan("B");
		assertEquals(180, checkOut.total());
	}

	private PricingService testPricingRules() {
		Map<String, Item> priceRules = new HashMap<>();
		priceRules.put("A", new Item(new Sku("A", 40), new Offer(3, 100)));
		priceRules.put("B", new Item(new Sku("B", 50), new Offer(2, 80)));
		priceRules.put("C", new Item(new Sku("C", 25)));
		priceRules.put("D", new Item(new Sku("D", 20)));
		return new PricingService(priceRules);
	}
}