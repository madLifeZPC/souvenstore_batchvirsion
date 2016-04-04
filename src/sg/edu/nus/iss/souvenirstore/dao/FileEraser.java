package sg.edu.nus.iss.souvenirstore.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * FileEraser is used to clear file content
 * @author Zhao Pengcheng
 *
 */
public class FileEraser {

	public static boolean eraseFileContent( String fileName )
	{
		Path filePath = Paths.get(DaoConstant.ROOT_DIRECTORY,fileName+DaoConstant.FILE_SUFFIX);
		boolean result = false;
		
		File file = new File(filePath.toString());
		if( !file.exists() )
		{
			try
			{
				result = file.createNewFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		else 
		{
			try
			{
				result = file.delete() && file.createNewFile();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
