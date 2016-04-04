package sg.edu.nus.iss.souvenirstore.domain;

/**
 * 
 * @author Zhao Pengcheng
 *
 */
public abstract class Discount {
	
	public static final String STATIC_START_DATE = "ALWAYS";
	public static final String STATIC_VALID_DAYS = "ALWAYS";
	public static final String APPLICABLE_TO_MEMBER = "M";
	public static final String APPLICABLE_TO_ALL = "A";
	public static final String FIRST_PURCHASE_CODE = "MEMBER_FIRST";
	public static final String SUBSEQUENT_PURCHASE_CODE = "MEMBER_SUBSEQ";
	
	private String discountCode;
	private String discountDescription;
	private int percentage;
	
	protected Discount(String discountCode, String discountDescription, int percentage) {
		super();
		this.discountCode = discountCode;
		this.discountDescription = discountDescription;
		this.percentage = percentage;
	}
	
	public String getDiscountCode() {
		return discountCode;
	}
	
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	
	public String getDiscountDescription() {
		return discountDescription;
	}
	
	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}
	
	public int getPercentage() {
		return percentage;
	}
	
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	abstract public String getStartDate();
	abstract public void setStartDate(String startDate);
	
	abstract public String getDuration();
	abstract public void setDuration(String duration);
	
	abstract public String getApplicableTo();
	abstract public void setApplicableTo(String applicableTo);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountCode == null) ? 0 : discountCode.hashCode());
		result = prime * result + ((discountDescription == null) ? 0 : discountDescription.hashCode());
		long temp;
		temp = Double.doubleToLongBits(percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Discount other = (Discount) obj;
		if (discountCode == null) {
			if (other.discountCode != null)
				return false;
		} else if (!discountCode.equals(other.discountCode))
			return false;
		if (discountDescription == null) {
			if (other.discountDescription != null)
				return false;
		} else if (!discountDescription.equals(other.discountDescription))
			return false;
		if (Double.doubleToLongBits(percentage) != Double.doubleToLongBits(other.percentage))
			return false;
		return true;
	}
	
	
}
