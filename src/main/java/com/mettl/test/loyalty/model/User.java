package com.mettl.test.loyalty.model;

import java.util.ArrayList;
import java.util.List;

import com.mettl.test.loyalty.utility.UtilityEnums.CustomerClass;

/*
 * UserDisplayDetails used as model for displaying the output.
 * Also to update the table record for each unique loyalty card holder
 */

public class User{

	private String cus_name, cus_email;
	private int total_loyalty_points;
	private List<Transaction> txn = new ArrayList<Transaction>();
	private CustomerClass cus_class;
	private int loyalty_card_no;
	

	public String getCus_email() {
		return cus_email;
	}

	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}

	public CustomerClass getCus_class() {
		return cus_class;
	}

	public void setCus_class(CustomerClass cus_class) {
		this.cus_class = cus_class;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public int getTotal_loyalty_points() {
		return total_loyalty_points;
	}

	public void setTotal_loyalty_points(int total_loyalty_points) {
		this.total_loyalty_points = total_loyalty_points;
	}
	
	public static User getUser(int loyalty_card_no) {
		// TODO Auto-generated method stub
		//Finds the if the use is registered or not
		//Returns User details needed if found, else return a new user.
		return null;
	}

	public List<Transaction> getTxn() {
		return txn;
	}

	public void setTxn(List<Transaction> l) {
		this.txn = l;
	}

	public void updateLoyaltyPoints(int purchase_amt, UserFullDetails user_full_details, Transaction curr_txn) {
		int earned_points = (int) (purchase_amt * user_full_details.getCus_class().pointsPerRupee());
		
		//Add each txn to Current User
		curr_txn.setTxn_pts(earned_points);
		//user_full_details.setTxn();
		txn.add(curr_txn); 
		this.setTotal_loyalty_points(earned_points + user_full_details.getTotal_loyalty_points());
		
		updateCustomerClass(purchase_amt, user_full_details);
		
	}
	

	public void updateCustomerClass(int purchase_amt,
			UserFullDetails user_full_details) {
		if((user_full_details.getLastYearPurchaseAmt() + purchase_amt) > 50000)
			this.setCus_class(CustomerClass.GOLD);
		if((user_full_details.getLastYearPurchaseAmt() + purchase_amt) > 25000 && (user_full_details.getLastYearPurchaseAmt() + purchase_amt) < 50000)
			this.setCus_class(CustomerClass.SILVER);
		if((user_full_details.getLastYearPurchaseAmt() + purchase_amt) <= 25000)
			this.setCus_class(CustomerClass.NORMAL);	
		
		updateTotalPurchase(purchase_amt, user_full_details);
	}

	private void updateTotalPurchase(int purchase_amt, UserFullDetails user_full_details) {
		
		user_full_details.setTotal_purchase_amt(purchase_amt + user_full_details.getTotal_purchase_amt());
	}

	public int getLoyalty_card_no() {
		return loyalty_card_no;
	}

	public void setLoyalty_card_no(int loyalty_card_no) {
		this.loyalty_card_no = loyalty_card_no;
	}

		
	
	
}