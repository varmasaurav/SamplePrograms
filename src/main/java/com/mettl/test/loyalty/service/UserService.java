package com.mettl.test.loyalty.service;

import com.mettl.test.loyalty.DailyTxn;
import com.mettl.test.loyalty.model.UserFullDetails;

public class UserService {

	public static void updateFinalDetails() {
		// TODO Auto-generated method stub
		
	}

	public static UserFullDetails getUserFullDetails(DailyTxn dailyTxn, int loyalty_no) {
		//Checks if user is registered
		//Returns details of user if found
		//If new User, set bonus loyalty points and details and return 
		
		// Return existing customer
		if(isRegisteredCustomer(loyalty_no))
			return getDatafromDB(loyalty_no); 
		
		//Create a New Customer and return it
		UserFullDetails temp_user_full = new UserFullDetails(loyalty_no);
		temp_user_full.setCus_name(dailyTxn.getCus_name());
		temp_user_full.setTotal_loyalty_points(100); //New Customer Bonus
		temp_user_full.setCus_email(dailyTxn.getCus_email());
		temp_user_full.setLoyalty_card_no(dailyTxn.getLoyalty_card_no());
		temp_user_full.updateCustomerClass(dailyTxn.getPurchase_amt(), temp_user_full);
		
		return temp_user_full;
	}

	private static UserFullDetails getDatafromDB(int loyalty_no) {
		// Call DAO to get Data and map it to UserFullDetails to return an instance
		return null;
	}

	private static boolean isRegisteredCustomer(int loyalty_no) {
		// TODO Auto-generated method stub
		return false;
	}

}
