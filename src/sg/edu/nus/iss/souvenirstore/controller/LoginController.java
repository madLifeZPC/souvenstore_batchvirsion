package sg.edu.nus.iss.souvenirstore.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sg.edu.nus.iss.souvenirstore.domain.StoreKeeper;
import sg.edu.nus.iss.souvenirstore.service.StoreKeeperService;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

/**
 * 
 * @author Vignesh
 *
 */
// somebody has added vrinda s name but i am not the author
public class LoginController {
	
	private static LoginController loginInstance = new LoginController();
	 private static String loggedinUser = "";
	 private ArrayList<StoreKeeper> storeKeepers;
	 private String userName = "";
	 private String passWord;
	 
	private LoginController()
	{
		
	}
	public static LoginController getLoginInstance()
	{
		return loginInstance;
	}
	
	public boolean authenticateUser(String uname, String passwd)
	{
		try
		{
			storeKeepers = StoreKeeperService.getStorekeeperService().getStoreKeeperList();
			for( StoreKeeper storeKeeper : storeKeepers )
			{
				if( storeKeeper.getStoreKeeperName().equals(uname) && 
				    storeKeeper.getStoreKeeperPassword().equals(passwd))
				return true;
			}
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
		
			return false;
		}
		return false;
	}
	
	public void setUserLoggedIn(String s)
	{
		loggedinUser = s;
	}
	
	public String getUserLoggedIn ()
	{
		return loggedinUser;
	}
	
	
}
