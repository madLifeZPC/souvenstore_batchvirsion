package sg.edu.nus.iss.souvenirstore.domain;

/**
 * 
 * @author Zhao Pengcheng
 *
 */
public class Member extends Customer {

	private String memberName;
	private int loyaltyPoints = -1;
	
	public Member()
	{
		super();
	}

	public Member(String memberName, String memberId) {
		super(memberId);
		this.memberName = memberName;
		this.loyaltyPoints = -1;
	}
	
	public Member(String memberName, String memberId, int loyaltyPoints) {
		super(memberId);
		this.memberName = memberName;
		this.loyaltyPoints = loyaltyPoints;
	}

	public boolean isFirstPurchase()
	{
		return (this.getLoyaltyPoints() == -1);
	}
	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + loyaltyPoints;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
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
		Member other = (Member) obj;
		if (loyaltyPoints != other.loyaltyPoints)
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		return true;
	}

	
}
