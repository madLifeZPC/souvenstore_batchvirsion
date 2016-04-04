package sg.edu.nus.iss.souvenirstore.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.w3c.dom.css.ElementCSSInlineStyle;

/**
 * DataReader is a Component which is in charge of reading data from the Storage.
 * @author Zhao Pengcheng
 * 
 */
public class DataReader {
	
	/**
	 * Get whole content of a specific file
	 * @param fileName
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> read(String fileName)
	{
		ArrayList<String> fileContent = new ArrayList<>();
		Path filePath = Paths.get(DaoConstant.ROOT_DIRECTORY, fileName+DaoConstant.FILE_SUFFIX);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try
		{
			fileReader = new FileReader(filePath.toString());
			bufferedReader = new BufferedReader(fileReader);
			String buffer;
			while((buffer=bufferedReader.readLine())!=null)
			{
				if( !buffer.equals(""))
					fileContent.add(buffer);
			}
		}
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
		finally 
		{
			try 
			{
				bufferedReader.close();
				fileReader.close();
			} 
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		
		return fileContent;
	}
	
	/**
	 * Get the last line of the file
	 * @param fileName
	 * @return
	 */
	public static String readLastLine( String fileName )
	{
		String lastLine = null;
		Path filePath = Paths.get(DaoConstant.ROOT_DIRECTORY, fileName+DaoConstant.FILE_SUFFIX);
		
		RandomAccessFile randomAccessFile = null;
		
		try 
		{
			randomAccessFile = new RandomAccessFile(filePath.toString(), "r");
			long length = randomAccessFile.length();
			if( length == 0L )
				lastLine = "";
			else
			{
				long position = length-1;
				boolean hasCharacter = false;
				int useLessChar = 0;
				byte tmp;
				while( position>0 )
				{
					randomAccessFile.seek(position);
					tmp = randomAccessFile.readByte();
					if( tmp == '\n' || tmp =='\r' ) 
					{
						if ( hasCharacter )
							break;
						useLessChar++;
					}
					else 
					{
						hasCharacter = true;
					}
					position--;
				}
				if( position == 0 ) 
					randomAccessFile.seek(position);
				byte[] bytes = new byte[(int)(length-position-useLessChar-1)];
				randomAccessFile.read(bytes);
				lastLine = new String(bytes);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				randomAccessFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return lastLine;
	}
}
