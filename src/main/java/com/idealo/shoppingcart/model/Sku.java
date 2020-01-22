package com.idealo.shoppingcart.model;

/**
 * This model defines the SKU's id with unit price.
 * @author Vishnu
 */
public class Sku {
	private final String id;
	private final int unitPrice;

	public Sku(String id, int unitPrice) {
		this.id = id;
		this.unitPrice = unitPrice;
	}

	public String getId() {
		return id;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + unitPrice;
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
		Sku other = (Sku) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (unitPrice != other.unitPrice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sku [id=" + id + ", unitPrice=" + unitPrice + "]";
	}
}