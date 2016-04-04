package sg.edu.nus.iss.souvenirstore.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * DataWriter is a Component which is in charge of writing data to the Storage.
 * @author Zhao Pengcheng
 * 
 */
public class DataWriter {

	/**
	 * Append new data to a specific file
	 * @param fileName
	 * @param data
	 */
	public static boolean append(String fileName, ArrayList<String> data)
	{
		Path filePath = Paths.get(DaoConstant.ROOT_DIRECTORY, fileName+DaoConstant.FILE_SUFFIX);
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		
		try 
		{
			fileWriter = new FileWriter(filePath.toString(),true);
			printWriter = new PrintWriter(fileWriter);
			Iterator<String> iterator = data.iterator();
			while( iterator.hasNext() )
			{
				printWriter.println(iterator.next().toString());
			}
			return true;
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
		finally
		{
			try 
			{
				fileWriter.close();
				printWriter.close();
			} 
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * Append one item to the file
	 * @param fileName
	 * @param data
	 */
	public static boolean appendOne(String fileName, String data)
	{
		Path filePath = Paths.get(DaoConstant.ROOT_DIRECTORY, fileName+DaoConstant.FILE_SUFFIX);
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		
		try 
		{
			fileWriter = new FileWriter(filePath.toString(),true);
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(data.toString());
			return true;
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
		finally
		{
			try 
			{
				fileWriter.close();
				printWriter.close();
			} 
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		return false;
	}
	
	
	/**
	 * Replace one line with another String
	 * @param fileName
	 * @param oldStr
	 * @param newStr
	 * @return
	 */
	public static boolean replaceLine( String fileName, String oldStr, String newStr )
	{
		Path filePath = Paths.get(DaoConstant.ROOT_DIRECTORY, fileName+DaoConstant.FILE_SUFFIX);
		
		StringBuffer buf = new StringBuffer();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		
		try
		{
			fileReader = new FileReader(filePath.toString());
			bufferedReader = new BufferedReader(fileReader);
			String temp = "";
			
			// Store content before oldStr
            while( (temp = bufferedReader.readLine()) != null
                    && !temp.equals(oldStr) )
            {
            	 buf = buf.append(temp);
                 buf = buf.append(System.getProperty("line.separator"));
            }
            
            if( temp!=null && temp.equals(oldStr) ) 
            {
            	// Insert newStr
                buf = buf.append(newStr);
                buf = buf.append(System.getProperty("line.separator"));
                
                // Store content after oldStr
                while ((temp = bufferedReader.readLine()) != null) {
                    buf = buf.append(temp);
                    buf = buf.append(System.getProperty("line.separator"));
                }

                bufferedReader.close();
				fileReader.close();
				
                FileEraser.eraseFileContent(fileName);
                
                fileWriter = new FileWriter(filePath.toString(),true);
    			printWriter = new PrintWriter(fileWriter);
    			printWriter.write(buf.toString().toCharArray());
    			printWriter.flush();
    			return true;
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
				if( bufferedReader!=null ) bufferedReader.close();
				if( fileReader!=null ) fileReader.close();
				if( printWriter!=null ) printWriter.close();
				if( fileWriter!=null ) fileWriter.close();
			} 
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		return false;
	}
}
