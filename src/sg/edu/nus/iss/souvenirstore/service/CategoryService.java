package sg.edu.nus.iss.souvenirstore.service;

import java.util.ArrayList;

import sg.edu.nus.iss.souvenirstore.dao.DaoConstant;
import sg.edu.nus.iss.souvenirstore.dao.DataReader;
import sg.edu.nus.iss.souvenirstore.dao.DataWriter;
import sg.edu.nus.iss.souvenirstore.dao.FileCreator;
import sg.edu.nus.iss.souvenirstore.domain.Category;
import sg.edu.nus.iss.souvenirstore.domain.Product;
import sg.edu.nus.iss.souvenirstore.domain.Vendor;
import sg.edu.nus.iss.souvenirstore.exception.dao.FileAlreadyExistException;
import sg.edu.nus.iss.souvenirstore.exception.domain.CategoryCodeExistException;
import sg.edu.nus.iss.souvenirstore.exception.service.WrongItemFormatException;

/**
 * CategoryService provides data operation interfaces on Category.dat.
 * @author Zhao Pengcheng
 *
 */
public class CategoryService {
	
	private static CategoryService categoryService;
	
	private CategoryService()
	{
		
	}
	
	public static CategoryService getCategoryService()
	{
		if( categoryService == null )
		{
			categoryService = new CategoryService();
		}
		return categoryService;
	}

	/**
	 * Get category list
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<Category> getCategoryList() throws WrongItemFormatException
	{
		ArrayList<Category> categoryList = new ArrayList<>();
		
		ArrayList<String> fileContent = DataReader.read(Category.class.getSimpleName());
		
		for( String item : fileContent )
		{
			String[] itemValues = item.split(DaoConstant.ITEM_SPLITER);
			if( itemValues.length!=2 )
			{
				throw new WrongItemFormatException("The format of one Category item is wrong");
			}
			Category category = new Category(itemValues[0], itemValues[1]);
			categoryList.add(category);
		}
		
		return categoryList;
	}
	
	/**
	 * transform category object to String
	 * @param category
	 * @return
	 */
	public String categoryToString( Category category )
	{
		StringBuilder categoryBuilder = new StringBuilder();
		categoryBuilder.append(category.getCategoryId());
		categoryBuilder.append(DaoConstant.ITEM_SPLITER);
		categoryBuilder.append(category.getCategoryName());
		return categoryBuilder.toString();
	}
	
	/**
	 * AddNewCategory function with logic error checking, category code can not be same
	 * @param category
	 * @return
	 * @throws CategoryCodeExistException
	 */
	public boolean addNewCategory(Category category) throws WrongItemFormatException
	{
		boolean result = false;
		try 
		{
			result = FileCreator.createDataFile(Vendor.class.getSimpleName()+DaoConstant.NAME_SUFFIX+category.getCategoryId());
			result = result && DataWriter.appendOne(Category.class.getSimpleName(), categoryToString(category));
		}
		catch(FileAlreadyExistException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Generate product Id according to the category it belongs to
	 * @param category
	 * @return
	 */
	public String generateNewProductId(Category category)
	{
		String newId = "";
		ArrayList<Product> products = category.getProducts();
		newId = category.getCategoryId()+"/"+String.valueOf(products.size()+1);
		return newId;
	}
}
