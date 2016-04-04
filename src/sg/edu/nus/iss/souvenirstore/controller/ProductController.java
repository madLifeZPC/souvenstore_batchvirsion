package sg.edu.nus.iss.souvenirstore.controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sg.edu.nus.iss.souvenirstore.domain.Category;
import sg.edu.nus.iss.souvenirstore.domain.Product;
import sg.edu.nus.iss.souvenirstore.service.CategoryService;
import sg.edu.nus.iss.souvenirstore.service.ProductService;

/**
 * 
 * @author Vignesh
 *
 */
public class ProductController 
{
	private static ProductController productInstance = new ProductController();
	
	private ProductController()
	{
		
	}
	public static ProductController getProductInstance()
	{
		return productInstance;
	}
	
	
	public boolean addProduct(String catCode, String prodName, String prodDesc, 
			int qty, double price, String barCode, int reOrderQty, int orderQty)
	{
		try
		{
			if(price<=0 || qty<=0 || reOrderQty <=0 || orderQty <=0 || catCode.equals("")
					|| catCode.equals(null) || prodName.equals("") || prodName.equals(null)
					|| prodDesc.equals("") || prodDesc.equals(null) || barCode.equals("") || barCode.equals(null))
			{
				JOptionPane.showMessageDialog(null, "INVALID DATA!","ERROR",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else
			{
				Category c = new Category();
				ArrayList<Product> plist = ProductService.getProductService().getProductList();
				ArrayList<Category> clist  =  CategoryService.getCategoryService().getCategoryList();
				for(int i=0;i<clist.size();i++)
				{
					if(clist.get(i).getCategoryId().equals(catCode))
					{
						c = clist.get(i);
					}
				}
				for(int j=0;j<plist.size();j++)
				{
					if(plist.get(j).getBarCodeNumber().equals(barCode))
					{
						JOptionPane.showMessageDialog(null, "THE BARCODE NUMBER ALREADY EXISTS!","ERROR!",JOptionPane.ERROR_MESSAGE);
					
					}
				}
				String prodID = CategoryService.getCategoryService().generateNewProductId(c);
				Product p = new Product(prodID,prodName,prodDesc,qty,price,barCode,reOrderQty,orderQty);
				return ProductService.getProductService().addNewProduct(p);
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
	}
	
	public ArrayList<Product> getProductsList()
	{
		try
		{
		return ProductService.getProductService().getProductList();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public Product getProductbyBarcode(String barCode)
	{
		try
		{
			return ProductService.getProductService().getProductByBarcode(barCode);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}

	public Product getProductbyId(String prodID)
	{
		try
		{
			return ProductService.getProductService().getProductById(prodID);
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	

}
