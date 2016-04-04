package sg.edu.nus.iss.souvenirstore.domain;

import java.util.ArrayList;

/**
 * 
 * @author Zhao Pengcheng
 *
 */
public class Transaction {

	private int transactionId;
	private ArrayList<CheckoutItem> checkoutItems;
	private String customerId;
	private String date;
	private double discount;
	private int loyaltyPointsUsed;
	private double moneyReceived;
	
	
	public Transaction()
	{
		
	}

	public Transaction(int transactionId, ArrayList<CheckoutItem> checkoutItems, String customerId, String date) {
		super();
		this.transactionId = transactionId;
		this.checkoutItems = checkoutItems;
		this.customerId = customerId;
		this.date = date;
		this.discount = 0;
		this.loyaltyPointsUsed = 0;
		this.moneyReceived = 0;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public ArrayList<CheckoutItem> getCheckoutItems() {
		return checkoutItems;
	}

	public void setCheckoutItems(ArrayList<CheckoutItem> checkoutItems) {
		this.checkoutItems = checkoutItems;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getLoyaltyPointsUsed() {
		return loyaltyPointsUsed;
	}

	public void setLoyaltyPointsUsed(int loyaltyPointsUsed) {
		this.loyaltyPointsUsed = loyaltyPointsUsed;
	}

	public double getMoneyReceived() {
		return moneyReceived;
	}

	public void setMoneyReceived(double moneyReceived) {
		this.moneyReceived = moneyReceived;
	}
	
	/**
	 * Get final bill after discount and loyaltyPoints redeemed
	 * @return
	 */
	public double getFinalBill()
	{
		double finalBill = 0;
		for( CheckoutItem checkoutItem : checkoutItems )
		{
			finalBill += checkoutItem.getProduct().getProductPrice() * checkoutItem.getQuantityPurchased();
		}
		finalBill = finalBill - finalBill * discount / 100;
		finalBill = finalBill - loyaltyPointsUsed / 20;
		return finalBill;
	}
	
	/**
	 * Get changes that should be return to customer
	 * @return
	 */
	public double getChangeReturn() {
		return moneyReceived - getFinalBill();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkoutItems == null) ? 0 : checkoutItems.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + loyaltyPointsUsed;
		temp = Double.doubleToLongBits(moneyReceived);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + transactionId;
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
		Transaction other = (Transaction) obj;
		if (checkoutItems == null) {
			if (other.checkoutItems != null)
				return false;
		} else if (!checkoutItems.equals(other.checkoutItems))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (loyaltyPointsUsed != other.loyaltyPointsUsed)
			return false;
		if (Double.doubleToLongBits(moneyReceived) != Double.doubleToLongBits(other.moneyReceived))
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}
	
	
}
