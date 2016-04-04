package sg.edu.nus.iss.souvenirstore.domain;

/**
 * 
 * @author Zhao Pengcheng
 * 
 */
public class StoreKeeper {
	
	private String storeKeeperName;
	private String storeKeeperPassword;
	
	public StoreKeeper()
	{
		
	}
	
	public StoreKeeper(String storeKeeperName, String storeKeeperPassword) {
		super();
		this.storeKeeperName = storeKeeperName;
		this.storeKeeperPassword = storeKeeperPassword;
	}

	public String getStoreKeeperName() {
		return storeKeeperName;
	}

	public void setStoreKeeperName(String storeKeeperName) {
		this.storeKeeperName = storeKeeperName;
	}

	public String getStoreKeeperPassword() {
		return storeKeeperPassword;
	}

	public void setStoreKeeperPassword(String storeKeeperPassword) {
		this.storeKeeperPassword = storeKeeperPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((storeKeeperName == null) ? 0 : storeKeeperName.hashCode());
		result = prime * result + ((storeKeeperPassword == null) ? 0 : storeKeeperPassword.hashCode());
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
		StoreKeeper other = (StoreKeeper) obj;
		if (storeKeeperName == null) {
			if (other.storeKeeperName != null)
				return false;
		} else if (!storeKeeperName.equals(other.storeKeeperName))
			return false;
		if (storeKeeperPassword == null) {
			if (other.storeKeeperPassword != null)
				return false;
		} else if (!storeKeeperPassword.equals(other.storeKeeperPassword))
			return false;
		return true;
	}

}
