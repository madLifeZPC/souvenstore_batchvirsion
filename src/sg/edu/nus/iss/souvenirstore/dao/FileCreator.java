package sg.edu.nus.iss.souvenirstore.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import sg.edu.nus.iss.souvenirstore.exception.dao.FileAlreadyExistException;

/**
 * FileCreator is a Component which is in charge of creating new file.
 * @author Zhao Pengcheng
 *
 */
public class FileCreator {
	
	public static boolean createDataFile( String fileName ) throws FileAlreadyExistException
	{
		Path filePath = Paths.get(DaoConstant.ROOT_DIRECTORY,fileName+DaoConstant.FILE_SUFFIX);
		boolean result = false;
		
		File file = new File(filePath.toString());
		if( file.exists() )
		{
			throw new FileAlreadyExistException(filePath+" already exists");
		}
		try
		{
			result = file.createNewFile();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}

}
