package sg.edu.nus.iss.souvenirstore.exception.dao;

/**
 * This exception happens while creating a file which already exists.
 * @author Zhao Pengcheng
 *
 */
public class FileAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public FileAlreadyExistException(String message)
	{
		super(message);
	}
}
