package sg.edu.nus.iss.souvenirstore.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * 
 * @author Vignesh
 *
 */
public class ValidationController {
	private static ValidationController validationInstance = new ValidationController();
	private ValidationController()
	{
		
	}
	public static ValidationController getValidationInstance()
	{
		return validationInstance;
	}
	
	public boolean isInt(String s)
	{
		 try { 
		     if(s.equals("") || s.equals(null))    
		    	 return false;
			 Integer.parseInt(s); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    } catch(NullPointerException e) {
		        return false;
		    }
		 catch(Exception e)
		 {
			 return false;
		 }
		    return true;
	}
	
	public boolean isDouble(String s)
	{
		try { 
	       Double.parseDouble(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	 catch(Exception e)
	 {
		 return false;
	 }
	    return true;
	}
	
	public boolean validateCatCode(String s)
	{
		if(s.length() == 3)
		{
			for(int i=0;i<s.length();i++)
			{
				if(!Character.isAlphabetic(s.charAt(i))) 
					{
					JOptionPane.showMessageDialog(null, "INVALID CATEGORY CODE!","ERROR!",JOptionPane.ERROR_MESSAGE);
					return false;
					}
			}
			
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "CATEGORY CODE CAN'T BE MORE OR LESS THAN 3 CHARACTERS", "ERROR!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	
	public boolean validateDiscountPercentage(String percentage)
	{
		try
		{
			int per = Integer.parseInt(percentage);
			if(per<100)
			{
				return true;
			}
		}
		catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
		catch(Exception e) {
		 return false;
		}
		return false;
	}
	
	public boolean validateDiscountDate(String date)
	{
		try
		{
			if(date!=null && date != "")
			{
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Date gdate = sf.parse(date);
				String tdate = sf.format(new Date());
				if(date.equals(tdate)) 
					return true;
				if(gdate.before(sf.parse(tdate)))
				{
					JOptionPane.showMessageDialog(null, "Date must not be in the past","Error!",JOptionPane.ERROR_MESSAGE);
					return false;
				}
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "INVALID DATE","ERROR!",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean validateDiscountDuration(String duration)
	{
		if(duration.equals("")) return false;
		else if(isInt(duration))
		{
			return true;
		}
		else if(duration.toUpperCase().equals("ALWAYS"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
