package com.mettl.test.loyalty;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mettl.test.loyalty.model.Transaction;
import com.mettl.test.loyalty.model.User;
import com.mettl.test.loyalty.service.UserService;

public class Loyalty {
	static User user = new User();
	static Transaction curr_txn;
	static Map<Integer, User> displayUser = new HashMap<Integer, User>();
	public static void main(String args[]){
		
		DailyTxn todaysTxn = new DailyTxn(); // Extend it to get weekly, monthly, yearly txn making Txn interfaces
		List<DailyTxn> list_of_txn = todaysTxn.getData();
		
		for(Iterator<DailyTxn> txn = list_of_txn.iterator(); txn.hasNext();){
			 DailyTxn user_txn_details = (DailyTxn) txn.next();
			 
			//loyalty card no to identify the registered customers.
			//Returns 0 if loyalty card is not found, logic goes in UserService
			 int loyalty_card_no = user_txn_details.getLoyalty_card_no(); 
			 
			 if(loyalty_card_no==0) {
				 System.out.println("CUSTOMER NOT REGISTERED FOR LOYALTY POINTS");
				 break;
			 }
			 
			 user = user_txn_details.computeLoyaltyAndUpdateUserDetails(); //Returns a user with details.
			 curr_txn = user_txn_details.constructTxn();
			 			 
			 //User has done multiple transactions in a day
			 if(displayUser.containsKey(loyalty_card_no)){
				 user.setTotal_loyalty_points(displayUser.get(loyalty_card_no).getTotal_loyalty_points() + user.getTotal_loyalty_points());
			     displayUser.get(loyalty_card_no).getTxn().add(curr_txn);
			 } 
			 
			 //Decorate user instance to get per txn earned points and txn id
			 
			 //Add the User Txn Detail for display and update purpose
			 displayUser.put(loyalty_card_no, user);
			
			 
			 //Actually it can be put in model and then added to view
			 // So that the iteration is done in front end to display details
			for(Iterator<Entry<Integer, User>> i = displayUser.entrySet().iterator(); i.hasNext();) {
				 
				 Map.Entry<Integer, User> printUser = (Map.Entry<Integer, User> ) i.next();
				 User test = printUser.getValue();
				 
				 System.out.println("Customer Name: "+ test.getCus_name());
				 System.out.println("Customer Email: "+test.getCus_email());
				 System.out.println("Loyalty Points: "+test.getTotal_loyalty_points());
				 System.out.println("Customer Class: "+test.getCus_class());
				 
				 //Very poor code, for inside for 
				 for(int index=0; index<test.getTxn().size();index++){
					 System.out.println("Transactions: "+ test.getTxn().get(index).getTxn_date()+"%12%12%12"+test.getTxn().get(index).getTxn_id()+"%12%12%12"+
				 test.getTxn().get(index).getTxn_amt()+"%12%12%12"+test.getTxn().get(index).getTxn_pts());
					 
				 }
			 }
			 UserService.updateFinalDetails(displayUser);
			 
			 
		 }
		
	}
	
}



