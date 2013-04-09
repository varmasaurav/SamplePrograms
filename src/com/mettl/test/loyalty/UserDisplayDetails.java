package com.mettl.test.loyalty;

/*
 * UserDisplayDetails used as model for displaying the output.
 * Also to update the table record for each unique loyalty card holder
 */

class UserDisplayDetails{
	
	private String cus_name, cus_email, cus_class;
	private int total_loyalty_points;

	public UserDisplayDetails(String cus_name, String cus_email,
			String cus_class, int total_loyalty_points) {
		// TODO Auto-generated constructor stub
	}

	public String getCus_email() {
		return cus_email;
	}

	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}

	public String getCus_class() {
		return cus_class;
	}

	public void setCus_class(String cus_class) {
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
}
/*
 * User class used to keep the customer details if it is found existing in table so avoid frequent calls
 * First call made to DB fetches the details from isExistingCustomer() method in main class file and
 * stores in a User object. Same object used for each iteration
 */
class User{

	public String getCustomerClass() {
		// TODO Auto-generated method stub
		return "CLASS";
	}
	//At a time keeps the detail of one User

	public int getCustomerYearlyPurchaseAmt() {
		// TODO Auto-generated method stub
		return 1;
	}

	public String getCustomerEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCustomerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLoyaltyPoints() {
		// TODO Auto-generated method stub
		return 0;
	}
}