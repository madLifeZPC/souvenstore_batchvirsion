package sg.edu.nus.iss.souvenirstore.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

import sg.edu.nus.iss.souvenirstore.dao.DaoConstant;
import sg.edu.nus.iss.souvenirstore.dao.DataReader;
import sg.edu.nus.iss.souvenirstore.dao.DataWriter;
import sg.edu.nus.iss.souvenirstore.domain.CheckoutItem;
import sg.edu.nus.iss.souvenirstore.domain.Transaction;
import sg.edu.nus.iss.souvenirstore.exception.service.WrongItemFormatException;

/**
 * TransactionService provides data operation interfaces on Transactions.dat.
 * @author Zhao Pengcheng
 *
 */
public class TransactionService {
	
	private static TransactionService transactionService;

	private TransactionService()
	{
		
	}
	
	public static TransactionService getTransactionService()
	{
		if( transactionService == null )
		{
			transactionService = new TransactionService();
		}
		return transactionService;
	}
	
	/**
	 * Get transaction list
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<Transaction> getTransactionList() throws WrongItemFormatException
	{
		ArrayList<Transaction> trasactionList = new ArrayList<>();
		
		ArrayList<String> fileContent = DataReader.read(Transaction.class.getSimpleName()+DaoConstant.NAME_SUFFIX);
		
		int previousId = 0;
		Transaction transaction = null;
		for( String item : fileContent )
		{
			String[] itemValues = item.split(DaoConstant.ITEM_SPLITER);
			if( itemValues.length!=5 )
			{
				throw new WrongItemFormatException("The format of one Transaction item is wrong");
			}
			
			CheckoutItem checkoutItem = new CheckoutItem(ProductService.getProductService().getProductById(itemValues[1]), Integer.parseInt(itemValues[3]));
			if( Integer.parseInt(itemValues[0]) != previousId )
			{
				ArrayList<CheckoutItem> checkoutItems = new ArrayList<>();
				checkoutItems.add(checkoutItem);
				transaction = new Transaction(Integer.parseInt(itemValues[0]),checkoutItems,itemValues[2],itemValues[4]);
				previousId = transaction.getTransactionId();
				trasactionList.add(transaction);
			}
			else 
			{
				trasactionList.get(previousId-1).getCheckoutItems().add(checkoutItem);
			}
		}
		return trasactionList;
	}
	
	/**
	 * transform transaction object to String
	 * @param transaction
	 * @return
	 */
	public ArrayList<String> transactionToString( Transaction transaction )
	{
		ArrayList<String> transactionInfo = new ArrayList<>();
		
		for( CheckoutItem checkoutItem : transaction.getCheckoutItems() )
		{
			StringBuilder transactionBuilder = new StringBuilder();
			transactionBuilder.append(String.valueOf(transaction.getTransactionId()));
			transactionBuilder.append(DaoConstant.ITEM_SPLITER);
			transactionBuilder.append(checkoutItem.getProduct().getProductId());
			transactionBuilder.append(DaoConstant.ITEM_SPLITER);
			transactionBuilder.append(transaction.getCustomerId());
			transactionBuilder.append(DaoConstant.ITEM_SPLITER);
			transactionBuilder.append(String.valueOf(checkoutItem.getQuantityPurchased()));
			transactionBuilder.append(DaoConstant.ITEM_SPLITER);
			transactionBuilder.append(transaction.getDate());
			transactionInfo.add(transactionBuilder.toString());
		}
		
		return transactionInfo;
	}
	
	/**
	 * Add a new transaction
	 * @param transaction
	 * @return
	 */
	public boolean addTransaction(Transaction transaction)
	{
		return DataWriter.append(Transaction.class.getSimpleName()+DaoConstant.NAME_SUFFIX, 
								transactionToString(transaction));
	}
	
	
	/**
	 * Get transactions within a fixed Date period sorted by product id
	 * @param start
	 * @param end
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<Transaction> getTransactionsByDate( String start, String end ) throws WrongItemFormatException
	{
		ArrayList<Transaction> transactions = getTransactionList();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try 
		{
			Date startDate = simpleDateFormat.parse(start);
			Date endDate = simpleDateFormat.parse(end);
			Iterator<Transaction> iterator = transactions.iterator();
			while( iterator.hasNext() )
			{
				Date transactionDate = simpleDateFormat.parse(iterator.next().getDate());
				if( transactionDate.after(endDate) || transactionDate.before(startDate) )
					iterator.remove();
			}
			/*
			Comparator<Transaction> comparator = new Comparator<Transaction>() {
				public int compare( Transaction t1, Transaction t2 )
				{
					return t1.().compareTo(t2.getProductId());
				}
			};
			Collections.sort(transactions,comparator);*/
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return transactions;
	}

	/**
	 * Get a monotonically increasing id for a new transaction
	 * @return
	 */
	public int generateTransactionId()
	{
		int result = 0;
		
		String lastTransaction = DataReader.readLastLine(Transaction.class.getSimpleName()+DaoConstant.NAME_SUFFIX);
		int lastId = Integer.parseInt(lastTransaction.split(",")[0]);
		result = lastId+1;
		
		return result;
	}
}
