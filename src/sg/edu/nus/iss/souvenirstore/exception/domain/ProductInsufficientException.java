package sg.edu.nus.iss.souvenirstore.exception.domain;

/**
 * This exception happens when the product amount in storage is not enough
 * @author Zhao Pengcheng
 *
 */
public class ProductInsufficientException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ProductInsufficientException(String message) 
	{
		super(message);
	}
}
