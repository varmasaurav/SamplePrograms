package com.mettl.test.loyalty.service;

import java.util.Map;

import com.mettl.test.loyalty.DailyTxn;
import com.mettl.test.loyalty.model.User;
import com.mettl.test.loyalty.model.UserFullDetails;
import com.mettl.test.loyalty.utility.UtilityEnums.CustomerClass;

public class UserService {

	public static void updateFinalDetails(Map<Integer, User> displayUser) {
		// Update User Details DB
		//Update Transaction DB
		
	}

	public static UserFullDetails getUserFullDetails(DailyTxn dailyTxn, int loyalty_no) {
		//Checks if user is registered
		//Returns details of user if found
		//If new User, set bonus loyalty points and details and return 
		
		// Return existing customer
		if(isRegisteredCustomer(loyalty_no))
			return getDatafromDB(loyalty_no); 
		
		//Create a New Customer and return it
		UserFullDetails temp_user_full = new UserFullDetails();
		temp_user_full.setCus_name(dailyTxn.getCus_name());
		temp_user_full.setTotal_loyalty_points(100); //New Customer Bonus
		temp_user_full.setCus_email(dailyTxn.getCus_email());
		temp_user_full.setLoyalty_card_no(dailyTxn.getLoyalty_card_no()); 
		temp_user_full.updateCustomerClass(dailyTxn.getPurchase_amt(), temp_user_full);
		
		return temp_user_full;
	}

	private static UserFullDetails getDatafromDB(int loyalty_no) {
		// Call DAO to get Data and map it to UserFullDetails to return an instance
		UserFullDetails user = new UserFullDetails();
		if(loyalty_no==1234){
			user.setCus_class(CustomerClass.GOLD);
			user.setCus_email("savarma@gmail.com");
			user.setCus_name("Saurav Varma");
			user.setTotal_loyalty_points(6000);
			user.setLastOneYr_pur_amt(67890);
			user.setTotal_purchase_amt(234567);
			
		}
		if(loyalty_no==98765){
			user.setCus_class(CustomerClass.SILVER);
			user.setCus_email("silver@gmail.com");
			user.setCus_name("Silver Customer Varma");
			user.setTotal_loyalty_points(1000);
			user.setLastOneYr_pur_amt(21000);
			user.setTotal_purchase_amt(234567);
		}
		return user;
	}

	private static boolean isRegisteredCustomer(int loyalty_no) {
		if(loyalty_no==1234)
			return true;
		if(loyalty_no==98765)
			return true;
		return false;
	}

	public static void getTxnData() {
		//Gets Data from DB and also cast if properly to bind it with an instance of DailyTxn
		//For loyalty card it returns 0 if found null.
		
	}

}
