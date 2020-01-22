package com.idealo.shoppingcart.model;

/**
 * This Model defines the offered quantity and special Price for an item.
 * 
 * @author Vishnu
 *
 */
public class Offer {
	private final int offeredQuantity;
	private final int specialPrice;

	/**
	 * @param offeredQuantity
	 * @param specialPrice
	 */
	public Offer(int offeredQuantity, int specialPrice) {
		this.offeredQuantity = offeredQuantity;
		this.specialPrice = specialPrice;
	}

	public int getOfferedQuantity() {
		return offeredQuantity;
	}

	public int getSpecialPrice() {
		return specialPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + offeredQuantity;
		result = prime * result + specialPrice;
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
		Offer other = (Offer) obj;
		if (offeredQuantity != other.offeredQuantity)
			return false;
		if (specialPrice != other.specialPrice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offers [offeredQuantity=" + offeredQuantity + ", specialPrice=" + specialPrice + "]";
	}
}