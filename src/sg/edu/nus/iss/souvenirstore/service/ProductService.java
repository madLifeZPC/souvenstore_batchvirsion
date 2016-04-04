package sg.edu.nus.iss.souvenirstore.service;

import java.util.ArrayList;

import sg.edu.nus.iss.souvenirstore.dao.DaoConstant;
import sg.edu.nus.iss.souvenirstore.dao.DataReader;
import sg.edu.nus.iss.souvenirstore.dao.DataWriter;
import sg.edu.nus.iss.souvenirstore.domain.Product;
import sg.edu.nus.iss.souvenirstore.exception.service.WrongItemFormatException;

/**
 * ProductService provides data operation interfaces on Products.dat.
 * @author Zhao Pengcheng
 *
 */
public class ProductService {
	
	private static ProductService productService;
	
	private ProductService()
	{
		
	}
	
	public static ProductService getProductService()
	{
		if( productService == null )
		{
			productService = new ProductService();
		}
		return productService;
	}
	
	/**
	 * Get product list
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<Product> getProductList() throws WrongItemFormatException
	{
		ArrayList<Product> productList = new ArrayList<>();
		
		ArrayList<String> fileContent = DataReader.read(Product.class.getSimpleName()+DaoConstant.NAME_SUFFIX);
		
		for( String item : fileContent )
		{
			String[] itemValues = item.split(DaoConstant.ITEM_SPLITER);
			if( itemValues.length!=8 )
			{
				throw new WrongItemFormatException("The format of one Category item is wrong");
			}
			Product product = new Product(itemValues[0], itemValues[1],itemValues[2],Integer.parseInt(itemValues[3]),Double.parseDouble(itemValues[4]),
					itemValues[5],Integer.parseInt(itemValues[6]),Integer.parseInt(itemValues[7]));
			
			productList.add(product);
		}
		
		return productList;
	}
	
	/**
	 * Get products under threshold
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<Product> getProductsUnderThreshold() throws WrongItemFormatException
	{
		ArrayList<Product> queryResult = new ArrayList<>();
		
		ArrayList<Product> products = getProductList();
		for( Product product : products )
		{
			if( product.getQuantityAvailable() < product.getReorderQuantity() )
				queryResult.add(product);
		}
		
		return queryResult;
	}
	
	/**
	 * transform product object to String
	 * @param product
	 * @return
	 */
	public String productToString( Product product )
	{
		StringBuilder productBuilder = new StringBuilder();
		productBuilder.append(product.getProductId());
		productBuilder.append(DaoConstant.ITEM_SPLITER);
		productBuilder.append(product.getProductName());
		productBuilder.append(DaoConstant.ITEM_SPLITER);
		productBuilder.append(product.getProductDescription());
		productBuilder.append(DaoConstant.ITEM_SPLITER);
		productBuilder.append(String.valueOf(product.getQuantityAvailable()));
		productBuilder.append(DaoConstant.ITEM_SPLITER);
		productBuilder.append(String.valueOf(product.getProductPrice()));
		productBuilder.append(DaoConstant.ITEM_SPLITER);
		productBuilder.append(product.getBarCodeNumber());
		productBuilder.append(DaoConstant.ITEM_SPLITER);
		productBuilder.append(String.valueOf(product.getReorderQuantity()));
		productBuilder.append(DaoConstant.ITEM_SPLITER);
		productBuilder.append(String.valueOf(product.getOrderQuantity()));
		return productBuilder.toString();
	}
	
	/**
	 * Add a New product
	 * @param product
	 * @return
	 */
	public boolean addNewProduct( Product product )
	{
		return DataWriter.appendOne(Product.class.getSimpleName()+DaoConstant.NAME_SUFFIX, 
				productToString(product));
	}
	
	/**
	 * Update the information of product into file
	 * @param newProduct
	 * @return
	 * @throws WrongItemFormatException
	 */
	public boolean updateProduct( Product newProduct ) throws WrongItemFormatException
	{
		Product oldProduct = getProductById(newProduct.getProductId());
		if( oldProduct == null ) return false;
		return DataWriter.replaceLine(Product.class.getSimpleName()+DaoConstant.NAME_SUFFIX, 
				productToString(oldProduct), productToString(newProduct));
	}
	
	/**
	 * Get a specific product by its barcode
	 * @param barcode
	 * @return
	 * @throws WrongItemFormatException
	 */
	public Product getProductByBarcode( String barcode ) throws WrongItemFormatException
	{
		Product queryResult = null;
		
		ArrayList<Product> products = getProductList();
		for( Product product : products )
		{
			if( product.getBarCodeNumber().equals(barcode) )
				queryResult = product;
		}
		
		return queryResult;
	}
	
	/**
	 * Get a specific product by its id
	 * @param productId
	 * @return
	 * @throws WrongItemFormatException
	 */
	public Product getProductById( String productId ) throws WrongItemFormatException
	{
		Product queryResult = null;
	
		ArrayList<Product> products = getProductList();
		for( Product product : products )
		{
			if( product.getProductId().equals(productId) )
				queryResult = product;
		}
		
		return queryResult;
	}

}
