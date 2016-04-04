package sg.edu.nus.iss.souvenirstore.controller;

import sg.edu.nus.iss.souvenirstore.domain.Product;
import sg.edu.nus.iss.souvenirstore.exception.domain.ProductInsufficientException;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sg.edu.nus.iss.souvenirstore.domain.CheckoutItem;
import sg.edu.nus.iss.souvenirstore.service.ProductService;
import sg.edu.nus.iss.souvenirstore.domain.Product;

/**
 * 
 * @author Vignesh
 *
 */
public class CheckoutController {
	private static CheckoutController checkoutInstance = new CheckoutController();
	private static ArrayList<CheckoutItem> checkoutItems = new ArrayList<>();
	private static String checkoutMemberID = "";
	private static  boolean applyLoyalty = false;
	private static int redeemablePoints = 0;
	private static double amtWithoutDiscountandLoyalty = 0;
	private static double amtafterDiscountAndLoyalty = 0.0;
	private static int lPointstobeAdded = 0;
	
	private CheckoutController()
	{
		
	}
	
	public void setamtafterDiscountAndLoyalty(double amt)
	{
		try
		{
			amtafterDiscountAndLoyalty = amt;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public double getamtafterDiscountAndLoyalty()
	{
		try
		{
			return amtafterDiscountAndLoyalty;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	public double getAmtWithoutDiscoutandLoyalty()
	{
		try
		{
			for(int i=0;i<checkoutItems.size();i++)
			{
				amtWithoutDiscountandLoyalty = amtWithoutDiscountandLoyalty + (checkoutItems.get(i).getProduct().getProductPrice()*checkoutItems.get(i).getQuantityPurchased());
			}
			return amtWithoutDiscountandLoyalty;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}
	public static CheckoutController getCheckoutInstance()
	{
		return checkoutInstance;
	}

	public void setApplyLoyalty(boolean value)
	{
		applyLoyalty = value;
	}
	public boolean getApplyLoyalty()
	{
		return applyLoyalty;
	}
	public void setCheckoutMemberID(String memID)
	{
		checkoutMemberID = memID;
	}
	
	public String getCheckoutMemberID()
	{
		return checkoutMemberID;
	}
	public boolean resetCheckout()
	{
		try
		{
			checkoutItems.clear();
			setCheckoutMemberID("");
			applyLoyalty = false;
			redeemablePoints = 0;
			amtafterDiscountAndLoyalty = 0;
			amtWithoutDiscountandLoyalty = 0;
			return true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return false;
			
		}
	}
	public boolean addCheckoutProduct(Product p)
	{
		//if it already exists return false
		for(int i=0;i<checkoutItems.size();i++)
		{
			if(p.getProductId().equals(checkoutItems.get(i).getProduct().getProductId()))
					{
				try
				{
					checkoutItems.get(i).setQuantityPurchased(checkoutItems.get(i).getQuantityPurchased()+1);
					return true;
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.toString(),"ERROR!",JOptionPane.ERROR_MESSAGE);
					return false;
				}
						
					}
		}
		CheckoutItem ci = new CheckoutItem(p, 1);
		checkoutItems.add(ci);
		return true;
	}
	public Product getProductByBarcode(String barCode)
	{
		try{
		return ProductService.getProductService().getProductByBarcode(barCode);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public ArrayList<CheckoutItem> changeQuantity(Product p, int newQty)
	{
		for(int i=0; i<checkoutItems.size(); i++)
		{
			if(p.getProductId().equals(checkoutItems.get(i).getProduct().getProductId()))
			{
				try
				{
					checkoutItems.get(i).setQuantityPurchased(newQty);
					return checkoutItems;
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
					return null;
				}
			}
		}
		return null;
	}
	
	public ArrayList<CheckoutItem> getCheckoutItemsList()
	{
		return checkoutItems;
	}
	
	public int getMaxRedeemablePoints (double subtotalAmt)
	{
		int pointsAvailable = MemberController.getMemberInstance().getMemberById(checkoutMemberID).getLoyaltyPoints();
		int maxPts = ((int)(subtotalAmt/5))*100;
		if(pointsAvailable>=maxPts)
		{
			redeemablePoints = maxPts;
		}
		else
		{
			redeemablePoints  = (int) (pointsAvailable/100) * 100;
		}
		return redeemablePoints;
	}
	
	public int getAmountforPoints(int points)
	{
		return (points/100)*5;
	}
	
	public int getPointsForAmount(double finalAmt)
	{
		try
		{
			return (int) finalAmt/10;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}
}
