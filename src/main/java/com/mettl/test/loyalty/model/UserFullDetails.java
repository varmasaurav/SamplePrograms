package com.mettl.test.loyalty.model;

public class UserFullDetails extends User {
	
	private int total_purchase_amt;
	private int lastOneYr_pur_amt;

	public UserFullDetails(int loyalty_no) {
		// TODO Auto-generated constructor stub
	}

	public UserFullDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getLastYearPurchaseAmt() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getLastOneYr_pur_amt() {
		return lastOneYr_pur_amt;
	}

	public void setLastOneYr_pur_amt(int lastOneYr_pur_amt) {
		this.lastOneYr_pur_amt = lastOneYr_pur_amt;
	}

	public int getTotal_purchase_amt() {
		return total_purchase_amt;
	}

	public void setTotal_purchase_amt(int total_purchase_amt) {
		this.total_purchase_amt = total_purchase_amt;
	}

}
