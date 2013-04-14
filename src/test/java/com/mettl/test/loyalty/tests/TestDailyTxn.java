package com.mettl.test.loyalty.tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.mettl.test.loyalty.DailyTxn;
import com.mettl.test.loyalty.model.User;

public class TestDailyTxn {
	@Test
	public void testComputeLoyaltyAndUpdateUserDetails(){
		
		//Data for the method 
		
		DailyTxn test_txn = new DailyTxn();
		test_txn.setCus_email("abcd@gmail.com");
		test_txn.setCus_name("Abcd");
		test_txn.setLoyalty_card_no(12345);//isRegisteredCustomer(loyalty_no) == false, test for new customer
		test_txn.setPur_txn_id(1234567890);
		test_txn.setPurchase_amt(25000); //Class NORMAL
		test_txn.setPurchase_date(new Date());
		
		User test_user = test_txn.computeLoyaltyAndUpdateUserDetails();
		
		assertEquals(test_user.getTotal_loyalty_points(), 350);
		
		test_txn.setLoyalty_card_no(1234);//isRegisteredCustomer(loyalty_no) == true, test for new customer
		test_user = test_txn.computeLoyaltyAndUpdateUserDetails();
		
		assertEquals(test_user.getTotal_loyalty_points(), 7250);
	}

}
