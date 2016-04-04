package sg.edu.nus.iss.souvenirstore.exception.domain;

/**
 * This exception happens while adding a new category whose category code already exists.
 * @author Zhao Pengcheng
 *
 */
public class CategoryCodeExistException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CategoryCodeExistException(String message)
	{
		super(message);
	}

}
