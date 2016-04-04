package sg.edu.nus.iss.souvenirstore.controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sg.edu.nus.iss.souvenirstore.domain.Category;
import sg.edu.nus.iss.souvenirstore.service.CategoryService;

/**
 * Use this controller to add categories or retrieve list of categories
 * @author Vignesh
 *
 */

public class CategoryController 
{
	/* Category code is compared to existing category codes and added. Returns false if code already exists */
	private static CategoryController categoryInstance = new CategoryController();
	
	private CategoryController()
	{
		
	}
	
	public static CategoryController getCategoryInstance()
	{
		return categoryInstance;
	}
	public boolean addCategory(String code, String name)
	{
		try
		{
			if(!code.equals("") && !code.equals(null) && !name.equals("") && !name.equals(null))
			{
				ArrayList<Category> clist  =  CategoryService.getCategoryService().getCategoryList();
				for(int i=0;i<clist.size();i++)
				{
					if(clist.get(i).getCategoryId().equals(code))
					{
						//the category code already exists
						return false;
					}
				}
				return CategoryService.getCategoryService().addNewCategory(new Category(code, name));
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	/* Returns an array list of categories present in the file. Be mindful about handling exceptions */
	
	public ArrayList<Category> getCategoryList()
	{
		try
		{
			return CategoryService.getCategoryService().getCategoryList();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	

}
