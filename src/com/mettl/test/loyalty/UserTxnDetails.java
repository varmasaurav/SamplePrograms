package com.mettl.test.loyalty;

import java.util.Date;

/*
 * Basically UserTxnDetails class to bind with the table data. The data from the input table is mapped to this object
 */
class UserTxnDetails {
	private String name, email;
	private int loyalty_card_no, purchase_amt;
	private long txn_id;
	private Date purchase_date;
	
	UserTxnDetails(String name, String email, int loyalty_card_no, int purchase_amt, Date purchase_date, long txn_id ){
		this.name = name;
		this.email = email;
		this.loyalty_card_no = loyalty_card_no;
		this.purchase_amt = purchase_amt;
		this.purchase_date = purchase_date;
		this.txn_id = txn_id;
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLoyalty_card_no() {
		return loyalty_card_no;
	}
	public void setLoyalty_card_no(int loyalty_card_no) {
		this.loyalty_card_no = loyalty_card_no;
	}
	public int getPurchase_amt() {
		return purchase_amt;
	}
	public void setPurchase_amt(int purchase_amt) {
		this.purchase_amt = purchase_amt;
	}
	public long getTxn_id() {
		return txn_id;
	}
	public void setTxn_id(long txn_id) {
		this.txn_id = txn_id;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	
}
