package com.idealo.shoppingcart.model;

import com.idealo.shoppingcart.model.Offer;
import com.idealo.shoppingcart.model.Sku;

/**
 * This model defines the pricing rules corresponding to different SKU's.
 * 
 * @author Vishnu
 *
 */
public class Item {
	private final Sku sku;
	private final Offer offer;

	/**
	 * @param sku
	 * @param offer
	 */
	public Item(Sku sku, Offer offer) {
		this.sku = sku;
		this.offer = offer;
	}

	/**
	 * @param sku
	 */
	public Item(Sku sku) {
		this.sku = sku;
		this.offer = new Offer(1, sku.getUnitPrice());
	}

	public Sku getSku() {
		return sku;
	}

	public Offer getOffer() {
		return offer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offer == null) ? 0 : offer.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (offer == null) {
			if (other.offer != null)
				return false;
		} else if (!offer.equals(other.offer))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Items [sku=" + sku + ", offer=" + offer + "]";
	}
}