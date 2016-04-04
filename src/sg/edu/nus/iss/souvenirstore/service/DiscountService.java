package sg.edu.nus.iss.souvenirstore.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import sg.edu.nus.iss.souvenirstore.dao.DaoConstant;
import sg.edu.nus.iss.souvenirstore.dao.DataReader;
import sg.edu.nus.iss.souvenirstore.dao.DataWriter;
import sg.edu.nus.iss.souvenirstore.domain.Discount;
import sg.edu.nus.iss.souvenirstore.domain.FirstPurchaseDiscount;
import sg.edu.nus.iss.souvenirstore.domain.PublicDiscount;
import sg.edu.nus.iss.souvenirstore.domain.SubsequentDiscount;
import sg.edu.nus.iss.souvenirstore.exception.service.WrongItemFormatException;

/**
 * DiscountService provides data operation interfaces on Discounts.dat.
 * @author Zhao Pengcheng
 *
 */
public class DiscountService {

	private static DiscountService discountService;
	
	private DiscountService()
	{
		
	}
	
	public static DiscountService getDiscountService()
	{
		if( discountService == null )
		{
			discountService = new DiscountService();
		}
		return discountService;
	}
	

	/**
	 * Get discount list
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<Discount> getDiscountList() throws WrongItemFormatException
	{
		ArrayList<Discount> discountList = new ArrayList<>();
		ArrayList<Discount> publicDiscounts = new ArrayList<>();
		
		ArrayList<String> fileContent = DataReader.read(Discount.class.getSimpleName()+DaoConstant.NAME_SUFFIX);
		for( String item : fileContent )
		{
			String[] itemValues = item.split(DaoConstant.ITEM_SPLITER);
			if( itemValues.length!=6 )
			{
				throw new WrongItemFormatException("The format of one Discount item is wrong");
			}
			Discount discount = stringToDiscount(itemValues);
			if( discount.getApplicableTo().equals(Discount.APPLICABLE_TO_MEMBER) )
			{
				discountList.add(discount);
			}
			else
			{
				publicDiscounts.add(discount);
			}
		}
		discountList.addAll(publicDiscounts);
		return discountList;
	}
	
	/**
	 * Get discount by code
	 * @param discountCode
	 * @return
	 * @throws WrongItemFormatException
	 */
	public Discount getDiscountByCode( String discountCode ) throws WrongItemFormatException
	{
		Discount result = null;
		ArrayList<Discount> discounts = getDiscountList();
		
		for( Discount discount : discounts )
		{
			if( discount.getDiscountCode().equals(discountCode) )
			{
				result = discount;
				break;
			}
		}
		return result;
	}
	
	/**
	 * transform discount object to String
	 * @param discount
	 * @return
	 */
	public String discountToString( Discount discount )
	{
		StringBuilder discountBuilder = new StringBuilder();
		discountBuilder.append(discount.getDiscountCode());
		discountBuilder.append(DaoConstant.ITEM_SPLITER);
		discountBuilder.append(discount.getDiscountDescription());
		discountBuilder.append(DaoConstant.ITEM_SPLITER);
		discountBuilder.append(discount.getStartDate());
		discountBuilder.append(DaoConstant.ITEM_SPLITER);
		discountBuilder.append(discount.getDuration());
		discountBuilder.append(DaoConstant.ITEM_SPLITER);
		discountBuilder.append(String.valueOf(discount.getPercentage()));
		discountBuilder.append(DaoConstant.ITEM_SPLITER);
		discountBuilder.append(discount.getApplicableTo());
		return discountBuilder.toString();
	}
	
	/***
	 * transform String into Discount object
	 * @param itemValues
	 * @return
	 */
	public Discount stringToDiscount( String[] itemValues )
	{
		Discount discount = null;
		
		if( itemValues[0].equals(Discount.FIRST_PURCHASE_CODE) )
		{
			discount = new FirstPurchaseDiscount(itemValues[0], itemValues[1], Integer.parseInt(itemValues[4]));
		}
		else if( itemValues[0].equals(Discount.SUBSEQUENT_PURCHASE_CODE) )
		{
			discount = new SubsequentDiscount(itemValues[0], itemValues[1], Integer.parseInt(itemValues[4]));
		}
		else 
		{
			discount = new PublicDiscount(itemValues[0], itemValues[1], itemValues[2], itemValues[3],Integer.parseInt(itemValues[4]));
		}
		
		return discount;
	}
	
	/**
	 * Add New discount
	 * @param discount
	 * @return
	 */
	public boolean addDiscount( Discount discount )
	{
		return DataWriter.appendOne(Discount.class.getSimpleName()+DaoConstant.NAME_SUFFIX, 
				discountToString(discount));
	}
	
	/**
	 * Update the information of discount into file
	 * @param newDiscount
	 * @return
	 * @throws WrongItemFormatException
	 */
	public boolean updateDiscount( Discount newDiscount ) throws WrongItemFormatException
	{
		Discount oldDiscount = getDiscountByCode(newDiscount.getDiscountCode());
		if( oldDiscount == null ) return false;
		return DataWriter.replaceLine(Discount.class.getSimpleName()+DaoConstant.NAME_SUFFIX, 
					discountToString(oldDiscount), discountToString(newDiscount));
	}

	/**
	 * Get all the available discounts
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<Discount> getDiscountsAvailable() throws WrongItemFormatException
	{
		ArrayList<Discount> discounts = getDiscountList();
		
		Iterator<Discount> iterator = discounts.iterator();
		while( iterator.hasNext() )
		{
			if( isBeyondDuration(iterator.next()) )
				iterator.remove();
		}
		
		return discounts;
	}
	
	/**
	 * Get first purchase discount for member
	 * @return
	 * @throws WrongItemFormatException
	 */
	public int getFirstPurchaseDiscount() throws WrongItemFormatException
	{
		Discount firstPurchaseDiscount = null;
	
		ArrayList<Discount> availableDiscounts = getDiscountsAvailable();
		
		for( Discount discount: availableDiscounts )
		{
			
			if( discount.getDiscountCode().equals(Discount.FIRST_PURCHASE_CODE) )
			{
				firstPurchaseDiscount = discount;
				break;
			}
		}
		return firstPurchaseDiscount.getPercentage();
	}
	
	/**
	 * Get discount with maximum percentage
	 * @param applicable
	 * @return
	 * @throws WrongItemFormatException
	 */
	public int getBestDiscount( String applicable ) throws WrongItemFormatException
	{
		Discount bestDiscount = null;	
		ArrayList<Discount> availableDiscounts = getDiscountsAvailable();
		
		double max = 0;
		Discount subsequentDiscount = null;
		for( Discount discount: availableDiscounts )
		{
			if( discount.getDiscountCode().equals(Discount.SUBSEQUENT_PURCHASE_CODE))
				subsequentDiscount = discount;
			if( !discount.getDiscountCode().equals(Discount.FIRST_PURCHASE_CODE) &&
						discount.getPercentage() > max )
			{
				max = discount.getPercentage();
				bestDiscount = discount;
			}
		}
		
		if( applicable.equals(Discount.APPLICABLE_TO_MEMBER) )
		{
			if( bestDiscount.getPercentage() < subsequentDiscount.getPercentage() )
				bestDiscount = subsequentDiscount;
		}
		
		return bestDiscount.getPercentage();
	}
	
	/**
	 * check if the discount has beyond its duration
	 * @return
	 */
	public boolean isBeyondDuration( Discount discount )
	{
		boolean isBeyondDuration = true;
		
		if( discount.getStartDate().equals("ALWAYS") || discount.getDuration().equals("ALWAYS"))
			isBeyondDuration = false;
		else
		{
			try 
			{
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date startdate = simpleDateFormat.parse(discount.getStartDate());
				int duration = Integer.parseInt(discount.getDuration());
					
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(startdate);
				calendar.add(Calendar.DATE, duration);
				String newDate  = simpleDateFormat.format(calendar.getTime());
				Date endDate = simpleDateFormat.parse(newDate);
					
				Date today = new Date();
					
				if( today.after(startdate) && today.before(endDate) )
					isBeyondDuration = false;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return isBeyondDuration;
	}
}
