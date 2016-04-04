package sg.edu.nus.iss.souvenirstore.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sg.edu.nus.iss.souvenirstore.domain.CheckoutItem;
import sg.edu.nus.iss.souvenirstore.domain.Product;
import sg.edu.nus.iss.souvenirstore.domain.Transaction;
import sg.edu.nus.iss.souvenirstore.service.ProductService;
import sg.edu.nus.iss.souvenirstore.service.TransactionService;

/**
 * 
 * @author Vignesh
 *
 */
public class TransactionController 
{
	private static TransactionController transactionInstance = new TransactionController();
	private TransactionController()
	{
		
	}
	public ArrayList<Transaction> getTransactionsList()
	{
		try
		{
			return TransactionService.getTransactionService().getTransactionList();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
		return null;
		}
	}
	public static TransactionController getTransanctionInstance()
	{
		return transactionInstance;
	}

	public int getNextTransactionID()
	{
		try
		{
			return TransactionService.getTransactionService().generateTransactionId();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}
	public boolean commitMemberTransaction(ArrayList<CheckoutItem> items, String memID)
	{
		try
		{
			int remainingPoints, updatePoints;
			int transID = TransactionService.getTransactionService().generateTransactionId();
			SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(new Date());
			Product upProd = new Product();
			Transaction transaction = new Transaction(transID, items, memID, date);
			transaction.setDiscount( (double)(DiscountController.getDiscountInstance().getBestMemberDiscountPercentage(memID)));
			transaction.setLoyaltyPointsUsed(0);
			if(CheckoutController.getCheckoutInstance().getApplyLoyalty())
			{
				transaction.setLoyaltyPointsUsed(CheckoutController.getCheckoutInstance().getMaxRedeemablePoints(CheckoutController.getCheckoutInstance().getAmtWithoutDiscoutandLoyalty()));
			}
			
			for(int i=0;i<items.size();i++)
			{
				upProd = items.get(i).getProduct();
				int qtyPurchased = items.get(i).getQuantityPurchased();
				upProd.setQuantityAvailable(upProd.getQuantityAvailable()-qtyPurchased);
				ProductService.getProductService().updateProduct(upProd);
			}
			
			//update user
			if(CheckoutController.getCheckoutInstance().getApplyLoyalty())
			{
				remainingPoints = MemberController.getMemberInstance().getMemberById(CheckoutController.getCheckoutInstance().getCheckoutMemberID()).getLoyaltyPoints() - CheckoutController.getCheckoutInstance().getMaxRedeemablePoints(CheckoutController.getCheckoutInstance().getAmtWithoutDiscoutandLoyalty());
				updatePoints = remainingPoints + CheckoutController.getCheckoutInstance().getPointsForAmount(CheckoutController.getCheckoutInstance().getamtafterDiscountAndLoyalty());
				if(!MemberController.getMemberInstance().setLoyaltyPoints(CheckoutController.getCheckoutInstance().getCheckoutMemberID(), updatePoints))
				{
					JOptionPane.showMessageDialog(null, "ERROR IN UPDATING LOYALTY POINTS!","ERROR!",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				if(MemberController.getMemberInstance().getMemberById(CheckoutController.getCheckoutInstance().getCheckoutMemberID()).getLoyaltyPoints() < 0)
				{
					remainingPoints = 0;
				}
				else
				{
					remainingPoints = MemberController.getMemberInstance().getMemberById(CheckoutController.getCheckoutInstance().getCheckoutMemberID()).getLoyaltyPoints();
				}
				updatePoints = remainingPoints+CheckoutController.getCheckoutInstance().getPointsForAmount(CheckoutController.getCheckoutInstance().getamtafterDiscountAndLoyalty());
				if(!MemberController.getMemberInstance().setLoyaltyPoints(CheckoutController.getCheckoutInstance().getCheckoutMemberID(), updatePoints))
				{
					JOptionPane.showMessageDialog(null, "ERROR IN UPDATING LOYALTY POINTS!","ERROR!",JOptionPane.ERROR_MESSAGE);	
				}
			}
			
			
			return TransactionService.getTransactionService().addTransaction(transaction);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			
			return false;
			
		}
	}
	
	public boolean commitNonMemberTransaction(ArrayList<CheckoutItem> items)
	{
		try
		{
			int transID = TransactionService.getTransactionService().generateTransactionId();
//			Date date = new Date();
			SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(new Date());
			Transaction transaction = new Transaction(transID, items, "PUBLIC" , date );
			Product upProd = new Product();
			for(int i=0;i<items.size();i++)
			{
				upProd = items.get(i).getProduct();
				int qtyPurchased = items.get(i).getQuantityPurchased();
				upProd.setQuantityAvailable(upProd.getQuantityAvailable()-qtyPurchased);
				ProductService.getProductService().updateProduct(upProd);
			}
			return TransactionService.getTransactionService().addTransaction(transaction);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
	}
	public ArrayList<Transaction> getTransactionsbyDaterange(String startDate,String endDate) {
		// TODO Auto-generated method stub
		try
		{
			return TransactionService.getTransactionService().getTransactionsByDate(startDate, endDate);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),"ERROR!",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
