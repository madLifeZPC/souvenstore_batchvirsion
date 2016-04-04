package sg.edu.nus.iss.souvenirstore.exception.service;

/**
 * This Exception happens when the format of the Data is wrong.
 * @author Zhao Pengcheng
 * 
 */

public class WrongItemFormatException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public WrongItemFormatException(String message)
	{
		super(message);
	}
}
