package sg.edu.nus.iss.souvenirstore.domain;

/**
 * 
 * @author Zhao Pengcheng
 *
 */
public class PublicDiscount extends Discount {
	
	private String startDate;
	private String duration;
	private String applicableTo;
	
	public PublicDiscount(String discountCode, String discountDescription, 
								String startDate, String duration, int percentage) {
		super(discountCode, discountDescription, percentage);
		this.startDate = startDate;
		this.duration = duration;
		this.applicableTo = Discount.APPLICABLE_TO_ALL;
	}

	@Override
	public String getStartDate() {
		return startDate;
	}

	@Override
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String getDuration() {
		return duration;
	}

	@Override
	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String getApplicableTo() {
		return applicableTo;
	}

	@Override
	public void setApplicableTo(String applicableTo) {
		this.applicableTo = applicableTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((applicableTo == null) ? 0 : applicableTo.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PublicDiscount other = (PublicDiscount) obj;
		if (applicableTo == null) {
			if (other.applicableTo != null)
				return false;
		} else if (!applicableTo.equals(other.applicableTo))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	
}
