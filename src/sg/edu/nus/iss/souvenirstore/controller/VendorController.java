package sg.edu.nus.iss.souvenirstore.controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sg.edu.nus.iss.souvenirstore.domain.Vendor;
import sg.edu.nus.iss.souvenirstore.service.VendorService;

/**
 * 
 * @author Vignesh
 *
 */
public class VendorController {
	private static VendorController vendorInstance= new VendorController();
	
	private VendorController()
	{
		
	}
	
	public static VendorController getVendorInstance()
	{
		return vendorInstance;
	}

	public boolean addVendor(String vendorName,String vendorDesc, ArrayList<String> catID)
	{
		try
		{
			if( vendorName.equals("") || vendorName.equals(null) || vendorDesc.equals("") || vendorDesc.equals(null))
				return false;
			Vendor v = new Vendor(vendorName,vendorDesc);
			for(int i=0;i<catID.size();i++)
			{
				VendorService.getVendorService().addVendor(catID.get(i), v);
			}
			return true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	public ArrayList<Vendor> getVendorsListByCategory(String catID)
	{
		try
		{
			return VendorService.getVendorService().getVendorList(catID);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
