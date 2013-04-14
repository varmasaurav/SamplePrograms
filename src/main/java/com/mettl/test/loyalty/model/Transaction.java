package com.mettl.test.loyalty.model;

import java.util.Date;

public class Transaction {
	private long txn_id;
	private int txn_amt;
	private Date txn_date;
	private int txn_pts;

	

	public long getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(long txn_id) {
		this.txn_id = txn_id;
	}

	public int getTxn_amt() {
		return txn_amt;
	}

	public void setTxn_amt(int txn_amt) {
		this.txn_amt = txn_amt;
	}

	public Date getTxn_date() {
		return txn_date;
	}

	public void setTxn_date(Date txn_date) {
		this.txn_date = txn_date;
	}

	public int getTxn_pts() {
		return txn_pts;
	}

	public void setTxn_pts(int txn_pts) {
		this.txn_pts = txn_pts;
	}

}
