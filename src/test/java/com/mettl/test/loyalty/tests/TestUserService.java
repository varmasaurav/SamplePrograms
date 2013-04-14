package com.mettl.test.loyalty.tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import com.mettl.test.loyalty.DailyTxn;
import com.mettl.test.loyalty.model.UserFullDetails;
import com.mettl.test.loyalty.service.UserService;
import com.mettl.test.loyalty.utility.UtilityEnums.CustomerClass;


public class TestUserService {
	
	
@Test
public void testGetUserFullDetails(){
	//Data for the method 
	//isRegisteredCustomer(loyalty_no) == false, test for new customer
	DailyTxn test_txn = new DailyTxn();
	test_txn.setCus_email("abcd@gmail.com");
	test_txn.setCus_name("Abcd");
	test_txn.setLoyalty_card_no(12345); //isRegisteredCustomer(loyalty_no) == false, test for new customer
	test_txn.setPur_txn_id(1234567890);
	test_txn.setPurchase_amt(24555); //Class NORMAL
	test_txn.setPurchase_date(new Date());
	
	
	UserFullDetails temp_user_full = UserService.getUserFullDetails(test_txn, 12345);
	
		
	assertEquals(temp_user_full.getCus_email(),"abcd@gmail.com");
	assertEquals(temp_user_full.getTotal_loyalty_points(), 100);
	assertEquals(temp_user_full.getTotal_purchase_amt(), 24555);
	assertEquals(temp_user_full.getCus_class(), CustomerClass.NORMAL);
	
	test_txn.setPurchase_amt(28555); //Class SILVER
	temp_user_full = UserService.getUserFullDetails(test_txn, 12345);
	assertEquals(temp_user_full.getCus_class(), CustomerClass.SILVER);

	test_txn.setPurchase_amt(56789); //Class GOLD
	temp_user_full = UserService.getUserFullDetails(test_txn, 12345);
	assertEquals(temp_user_full.getCus_class(), CustomerClass.GOLD);
	
	test_txn.setLoyalty_card_no(1234); //isRegisteredCustomer(loyalty_no) == true, test for new customer
	temp_user_full = UserService.getUserFullDetails(test_txn, 1234);
	assertEquals(temp_user_full.getCus_class(), CustomerClass.GOLD);
	
	test_txn.setLoyalty_card_no(98765); //isRegisteredCustomer(loyalty_no) == true, test for new customer
	temp_user_full = UserService.getUserFullDetails(test_txn, 98765);
	assertEquals(temp_user_full.getCus_class(), CustomerClass.SILVER);
	
}
	

}