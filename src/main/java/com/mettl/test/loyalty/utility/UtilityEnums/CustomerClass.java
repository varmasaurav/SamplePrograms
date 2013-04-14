package com.mettl.test.loyalty.utility.UtilityEnums;

public enum CustomerClass {
	NORMAL{
		public double pointsPerRupee(){
			return 1/100;
		}
	}, 
	SILVER{
		public double pointsPerRupee(){
			return 2/100;
		}
	},
	GOLD{
		public double pointsPerRupee(){
			return 25/500;
		}
	};
	public abstract double pointsPerRupee();
	
	}


