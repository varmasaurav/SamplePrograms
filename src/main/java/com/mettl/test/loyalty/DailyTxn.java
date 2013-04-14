package com.mettl.test.loyalty;

import java.util.Date;
import java.util.List;

import com.mettl.test.loyalty.model.Transaction;
import com.mettl.test.loyalty.model.User;
import com.mettl.test.loyalty.model.UserFullDetails;
import com.mettl.test.loyalty.service.UserService;

public class DailyTxn {
	private String cus_name;
	private String cus_email;
	private int loyalty_card_no;
	public int getLoyalty_card_no() {
		return loyalty_card_no;
	}

	private int purchase_amt;
	private Date purchase_date;
	private long pur_txn_id;
	
	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public int getPurchase_amt() {
		return purchase_amt;
	}

	public void setPurchase_amt(int purchase_amt) {
		this.purchase_amt = purchase_amt;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public long getPur_txn_id() {
		return pur_txn_id;
	}

	public void setPur_txn_id(long pur_txn_id) {
		this.pur_txn_id = pur_txn_id;
	}

	public void setLoyalty_card_no(int loyalty_card_no) {
		this.loyalty_card_no = loyalty_card_no;
	}

	

	public List<DailyTxn> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public User computeLoyaltyAndUpdateUserDetails() {
		int loyalty_no = this.getLoyalty_card_no();
		int purchase_amt = this.getPurchase_amt();
		User temp_user = new User();
		
		//Construct the transaction 
		Transaction curr_txn = new Transaction();
		curr_txn.setTxn_amt(this.getPurchase_amt());
		curr_txn.setTxn_date(this.getPurchase_date());
		curr_txn.setTxn_id(this.getPur_txn_id());
		
		//Get User full details
		UserFullDetails user_full_details = UserService.getUserFullDetails(this, loyalty_no);
		temp_user.updateLoyaltyPoints(purchase_amt, user_full_details, curr_txn);
		return temp_user;
	}

	public String getCus_email() {
		return cus_email;
	}

	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}

}
