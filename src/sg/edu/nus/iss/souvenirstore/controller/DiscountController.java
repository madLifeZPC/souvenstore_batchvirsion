package sg.edu.nus.iss.souvenirstore.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sg.edu.nus.iss.souvenirstore.domain.Discount;
import sg.edu.nus.iss.souvenirstore.domain.FirstPurchaseDiscount;
import sg.edu.nus.iss.souvenirstore.domain.Member;
import sg.edu.nus.iss.souvenirstore.domain.PublicDiscount;
import sg.edu.nus.iss.souvenirstore.domain.SubsequentDiscount;
import sg.edu.nus.iss.souvenirstore.service.DiscountService;
import sg.edu.nus.iss.souvenirstore.service.MemberService;

/**
 * 
 * @author Vignesh
 *
 */
public class DiscountController
{
	private static DiscountController discountInstance = new DiscountController();
	private DiscountController()
	{
		
	}
	public static DiscountController getDiscountInstance()
	{
		return discountInstance;
	}
	
	public ArrayList<Discount> getAllDiscounts()
	{
		try
		{
			ArrayList<Discount> discounts = DiscountService.getDiscountService().getDiscountList();
			boolean hasFirstPurchaseDiscount = false, hasSubsequentDiscount = false;
			for( Discount discount : discounts )
			{
				if( discount.getDiscountCode().equals(Discount.FIRST_PURCHASE_CODE))
				{
					hasFirstPurchaseDiscount = true;
				}
				if( discount.getDiscountCode().equals(Discount.SUBSEQUENT_PURCHASE_CODE))
				{
					hasSubsequentDiscount = true;
				}
			}
			if( !hasFirstPurchaseDiscount )
			{
				FirstPurchaseDiscount firstPurchaseDiscount = new FirstPurchaseDiscount(Discount.FIRST_PURCHASE_CODE, "First purchase by member", 20);
				DiscountService.getDiscountService().addDiscount( firstPurchaseDiscount );
			}
			if( !hasSubsequentDiscount )
			{
				SubsequentDiscount subsequentDiscount = new SubsequentDiscount(Discount.SUBSEQUENT_PURCHASE_CODE, "Subsequent purchase by member", 10);
				DiscountService.getDiscountService().addDiscount( subsequentDiscount );
			}
			discounts = DiscountService.getDiscountService().getDiscountList();
			return discounts;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			
			return null;
		}
	}
	/*
	public boolean addNewMemberDiscount(String discCode, String discDesc, String startDate, String duration, int percentage)
	{
		try
		{
			ArrayList<Discount> disList = DiscountService.getDiscountService().getDiscountList();
			for(int i=0;i<disList.size();i++)
			{
				if(disList.get(i).getDiscountCode().equals(discCode))
				{
					//code already exists
					JOptionPane.showMessageDialog(null, "DISCOUNT CODE ALREADY EXISTS","ERROR!",JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			SubsequentDiscount d = new SubsequentDiscount(discCode, discDesc, percentage);
			d.setStartDate(startDate);
			d.setDuration(duration);
			d.setApplicableTo("M");
			//left here
			DiscountService.getDiscountService().addDiscount(d);
			return true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),"ERROR!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	*/
	
	public boolean addNewNonMemberDiscount(String discCode, String discDesc, String startDate, String duration, int percentage)
	{
		try
		{
			ArrayList<Discount> disList = DiscountService.getDiscountService().getDiscountList();
			for(int i=0;i<disList.size();i++)
			{
				if(disList.get(i).getDiscountCode().equals(discCode))
				{
					//code already exists
					JOptionPane.showMessageDialog(null, "DISCOUNT CODE ALREADY EXISTS","ERROR!",JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			if( discCode.equals("") || discCode.equals(null) || startDate.equals("") || startDate.equals(null)
					|| duration.equals("") || duration.equals(null) )
			return false;
			PublicDiscount d = new PublicDiscount(discCode, discDesc, startDate, duration, percentage);
			d.setApplicableTo("A");
			//left here
			DiscountService.getDiscountService().addDiscount(d);
			return true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),"ERROR!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	
	public int getBestMemberDiscountPercentage(String memberID)
	{
		
		int percentage = 0;
		try
		{
			Member m = MemberService.getMemberService().getMemberById(memberID);
			if(m.getLoyaltyPoints() == -1)
			{
				 percentage = DiscountService.getDiscountService().getFirstPurchaseDiscount();
			}
			else
			{
				percentage = DiscountService.getDiscountService().getBestDiscount("M");
			}
			return percentage;
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(null, e.toString(),"ERROR!",JOptionPane.ERROR_MESSAGE);
		
			return 0;	
		}
	}
	
	public int getBestNonMemberDiscountPercentage()
	{
		try
	{
		return DiscountService.getDiscountService().getBestDiscount("ALL");
	}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),"ERROR!",JOptionPane.ERROR_MESSAGE);
			
			return 0;
		
		}
		
	}

	public boolean updateDiscount(String discountCode, int percentage)
	{
		try {
			Discount discount = DiscountService.getDiscountService().getDiscountByCode(discountCode);
			discount.setPercentage(percentage);
			return DiscountService.getDiscountService().updateDiscount(discount);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),"ERROR!",JOptionPane.ERROR_MESSAGE);
			
		}
		return false;
	}
}
