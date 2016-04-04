package sg.edu.nus.iss.souvenirstore.domain;

/**
 * 
 * @author Zhao Pengcheng
 *
 */
public class Vendor {
	
	private String vendorName;
	private String vendorDescription;
	
	public Vendor()
	{
		
	}

	public Vendor(String vendorName, String vendorDescription) {
		super();
		this.vendorName = vendorName;
		this.vendorDescription = vendorDescription;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorDescription() {
		return vendorDescription;
	}

	public void setVendorDescription(String vendorDescription) {
		this.vendorDescription = vendorDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vendorDescription == null) ? 0 : vendorDescription.hashCode());
		result = prime * result + ((vendorName == null) ? 0 : vendorName.hashCode());
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
		Vendor other = (Vendor) obj;
		if (vendorDescription == null) {
			if (other.vendorDescription != null)
				return false;
		} else if (!vendorDescription.equals(other.vendorDescription))
			return false;
		if (vendorName == null) {
			if (other.vendorName != null)
				return false;
		} else if (!vendorName.equals(other.vendorName))
			return false;
		return true;
	}
	
	

}
