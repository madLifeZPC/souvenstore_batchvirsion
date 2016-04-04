package sg.edu.nus.iss.souvenirstore.domain;

import sg.edu.nus.iss.souvenirstore.exception.domain.ProductInsufficientException;

/**
 * 
 * @author Zhao Pengcheng
 *
 */
public class CheckoutItem {
	
	private Product product;
	private int quantityPurchased;
	
	public CheckoutItem(Product product, int quantityPurchased) {
		super();
		this.product = product;
		this.quantityPurchased = quantityPurchased;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(int quantityPurchased) throws ProductInsufficientException{
		if( quantityPurchased > product.getQuantityAvailable() )
			throw new ProductInsufficientException("The buying quantity has exceeded the amount in storage");
		this.quantityPurchased = quantityPurchased;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantityPurchased;
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
		CheckoutItem other = (CheckoutItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantityPurchased != other.quantityPurchased)
			return false;
		return true;
	}
	
	
}
