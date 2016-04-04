package sg.edu.nus.iss.souvenirstore.service;

import java.util.ArrayList;

import sg.edu.nus.iss.souvenirstore.dao.DaoConstant;
import sg.edu.nus.iss.souvenirstore.dao.DataReader;
import sg.edu.nus.iss.souvenirstore.domain.StoreKeeper;
import sg.edu.nus.iss.souvenirstore.exception.service.WrongItemFormatException;

/**
 * StoreKeeperService provides data operation on storekeeper.dat.
 * @author Zhao Pengcheng
 * 
 */
public class StoreKeeperService {

	private static StoreKeeperService storeKeeperService;
	
	private StoreKeeperService()
	{
		
	}

	public static StoreKeeperService getStorekeeperService()
	{
		if( storeKeeperService == null )
		{
			storeKeeperService = new StoreKeeperService();
		}
		return storeKeeperService;
	}
	
	/**
	 * Get storekeeper list
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<StoreKeeper> getStoreKeeperList() throws WrongItemFormatException
	{
		ArrayList<StoreKeeper> storeKeeperList = new ArrayList<>();
		
		ArrayList<String> fileContent = DataReader.read(StoreKeeper.class.getSimpleName()+DaoConstant.NAME_SUFFIX);
		
		for( String item : fileContent )
		{
			String[] itemValues = item.split(DaoConstant.ITEM_SPLITER);
			if( itemValues.length!=2 )
			{
				throw new WrongItemFormatException("The format of one StoreKeeper item is wrong");
			}
			StoreKeeper storeKeeper = new StoreKeeper(itemValues[0], itemValues[1]);
			storeKeeperList.add(storeKeeper);
		}
		
		return storeKeeperList;
	}
	
}
