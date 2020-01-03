package com.idealo.shoppingcart.backend;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.idealo.shoppingcart.backend.CheckOut;
import com.idealo.shoppingcart.backend.PricingRulesImpl;
import com.idealo.shoppingcart.domain.Offers;
import com.idealo.shoppingcart.domain.PricingRule;
import com.idealo.shoppingcart.domain.Sku;

public class CheckOutTest {
	public int calculatePrice(String items) {
        CheckOut checkOut = new CheckOut(testPricingRules());
        for(int i=0; i<items.length(); i++) {
        	checkOut.scan(String.valueOf(items.charAt(i)));
        }
        return checkOut.total();
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
        CheckOut checkOut = new CheckOut(testPricingRules());
        assertEquals(0, checkOut.total());
        checkOut.scan("A"); assertEquals(40, checkOut.total());
        checkOut.scan("B"); assertEquals(90, checkOut.total());
        checkOut.scan("A"); assertEquals(130, checkOut.total());
        checkOut.scan("A"); assertEquals(150, checkOut.total());
        checkOut.scan("B"); assertEquals(180, checkOut.total());
    }

    private PricingRulesImpl testPricingRules() {
        Map<String, PricingRule> priceRules = new HashMap<>();
        priceRules.put("A", new PricingRule(new Sku("A", 40), new Offers(3,100)));
        priceRules.put("B", new PricingRule(new Sku("B", 50), new Offers(2,80)));
        priceRules.put("C", new PricingRule(new Sku("C", 25)));
		priceRules.put("D", new PricingRule(new Sku("D", 20)));
        return new PricingRulesImpl(priceRules);
    }
}
