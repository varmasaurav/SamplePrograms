package com.mettl.test.loyalty;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Loyalty {
	private static final String STATUS_G = "GOLD";
	private static final String STATUS_S = "SILVER";
	private static final String STATUS_N = "NORMAL";
	static List<UserTxnDetails> txn_list_of_the_day;
	static User user = new User();
	static Map<Integer, UserDisplayDetails> displayUser = new HashMap<Integer, UserDisplayDetails>();
	public static void main(String args[]){
		 getDataOfTheDay();
		 
		 for(Iterator<UserTxnDetails> txn = txn_list_of_the_day.iterator(); txn.hasNext();){
			 UserTxnDetails user_txn_details = (UserTxnDetails) txn.next();
			 String loyalty_card_no = user_txn_details.getLoyalty_card_no()+"";
			 int total_loyalty_points = user.getLoyaltyPoints();
			 String cus_name = user.getCustomerName();
			 String cus_email = user.getCustomerEmail();
			 String cus_class = user.getCustomerClass();
			 
			 
			 
			 if(loyalty_card_no!=null){
				 if(isExistingCustomer(Integer.parseInt(loyalty_card_no))){
					 if(cus_class.equals(STATUS_G)){
						 total_loyalty_points += (user_txn_details.getPurchase_amt()/500)*25; 
					 }
					 if(cus_class.equals(STATUS_S)){
						 total_loyalty_points += (user_txn_details.getPurchase_amt()/500)*2;
						 cus_class = (user.getCustomerYearlyPurchaseAmt() + user_txn_details.getPurchase_amt() > 50000)? STATUS_G:STATUS_S;
					 }
					 if(cus_class.equals(STATUS_N)){
						 total_loyalty_points += user_txn_details.getPurchase_amt()*0.01;
						 if((user.getCustomerYearlyPurchaseAmt() + user_txn_details.getPurchase_amt() > 25000) && (user.getCustomerYearlyPurchaseAmt() + user_txn_details.getPurchase_amt() < 50000))
							 cus_class = STATUS_S;
						 if(user.getCustomerYearlyPurchaseAmt() + user_txn_details.getPurchase_amt() > 50000)
							 cus_class = STATUS_G;
				 }
					 
					 displayUser.put(Integer.parseInt(loyalty_card_no), new UserDisplayDetails(cus_name, cus_email, cus_class, total_loyalty_points));
					 
				 }
			 }
			 
			 else {
				 System.out.println("Customer Name:"+user_txn_details.getName());
				 System.out.println("Customer Email:"+user_txn_details.getEmail());
				 System.out.println("Loyalty Points: Not Enrolled");
				 System.out.println("Customer Class: Not Enrolled");
				 System.out.println("Transactions: Not Enrolled");
			 }
			 
			 for(Iterator<Entry<Integer, UserDisplayDetails>> i = displayUser.entrySet().iterator(); i.hasNext();) {
				 
				 Map.Entry<Integer, UserDisplayDetails> printUser = (Map.Entry<Integer, UserDisplayDetails> ) i.next();
				 UserDisplayDetails test = printUser.getValue();
				 
				 System.out.println("Customer Name: "+ test.getCus_name());
				 System.out.println("Customer Email: "+test.getCus_email());
				 System.out.println("Loyalty Points: "+test.getTotal_loyalty_points());
				 System.out.println("Customer Class: "+test.getCus_class());
				 System.out.println("Transactions: ");
				 
			 }
			 
		 }
		
		
	}
	
	private static boolean isExistingCustomer(int loyalty_card_no) {
		
		//user = new User();
		// If the Customer is enrolled it creates an instance of User and fetch the it's all the previous details from its unique Loyalty Card No. and store if for reference and returns true
		return true;
	}

	//Just a mock data to insert. It can actually get the data from table as list
	public static void getDataOfTheDay(){
		txn_list_of_the_day = new ArrayList<UserTxnDetails>();
		
		txn_list_of_the_day.add(new UserTxnDetails("Abhay", "abhay@demo.com",11001, 7402, new Date(), 123456789));
	}
	

	

}



