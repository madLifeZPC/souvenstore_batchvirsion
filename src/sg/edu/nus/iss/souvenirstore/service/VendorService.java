package sg.edu.nus.iss.souvenirstore.service;

import java.util.ArrayList;

import sg.edu.nus.iss.souvenirstore.dao.DaoConstant;
import sg.edu.nus.iss.souvenirstore.dao.DataReader;
import sg.edu.nus.iss.souvenirstore.dao.DataWriter;
import sg.edu.nus.iss.souvenirstore.domain.Category;
import sg.edu.nus.iss.souvenirstore.domain.Vendor;
import sg.edu.nus.iss.souvenirstore.exception.service.WrongItemFormatException;

/**
 * VendorService provides data operation interfaces on VendorsXXX.dat.
 * @author Zhao Pengcheng
 *
 */
public class VendorService {
	
	private static VendorService vendorService;
	
	private VendorService()
	{
		
	}
	
	public static VendorService getVendorService()
	{
		if( vendorService == null )
		{
			vendorService = new VendorService();
		}
		return vendorService;
	}
	

	/**
	 * Get all the vendors of one specific category
	 * @param category
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<Vendor> getVendorList( String categoryId ) throws WrongItemFormatException
	{
		ArrayList<Vendor> vendorList = new ArrayList<>();
		
		ArrayList<String> fileContent = DataReader.read(Vendor.class.getSimpleName()+DaoConstant.NAME_SUFFIX+categoryId);
		
		for( String item : fileContent )
		{
			String[] itemValues = item.split(DaoConstant.ITEM_SPLITER);
			if( itemValues.length!=2 )
			{
				throw new WrongItemFormatException("The format of one Vendor item of "+Category.class.getSimpleName()+" is wrong");
			}
			Vendor vendor = new Vendor(itemValues[0], itemValues[1]);
			vendorList.add(vendor);
		}
		
		return vendorList;
	}
	
	/**
	 * transform vendor object to String
	 * @param vendor
	 * @return
	 */
	public String vendorToString( Vendor vendor )
	{
		StringBuilder vendorBuilder = new StringBuilder();
		vendorBuilder.append(vendor.getVendorName());
		vendorBuilder.append(DaoConstant.ITEM_SPLITER);
		vendorBuilder.append(vendor.getVendorDescription());
		return vendorBuilder.toString();
	}
	
	/**
	 * Add one Vendor for a specific category
	 * @param category
	 * @param vendor
	 * @return
	 */
	public boolean addVendor(String categoryId,Vendor vendor) 
	{
		return DataWriter.appendOne(Vendor.class.getSimpleName()+DaoConstant.NAME_SUFFIX+categoryId, 
								vendorToString(vendor));
	}

}
