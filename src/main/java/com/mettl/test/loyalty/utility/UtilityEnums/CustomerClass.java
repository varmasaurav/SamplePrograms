package com.mettl.test.loyalty.utility.UtilityEnums;

public enum CustomerClass {
	NORMAL{
		public double pointsPerRupee(){
			return 0.01; // 1% for txn == 0.01
		}
	}, 
	SILVER{
		public double pointsPerRupee(){
			return 0.02; // 2 point per 100
		}
	},
	GOLD{
		public double pointsPerRupee(){
			return 0.05; //25 points per 500
		}
	};
	public abstract double pointsPerRupee();
	
	}


