package com.programs.sample;

public class Test {
    
    public static int method1(){
        try {
            int i = 10/0;
            return 1;
        }
        catch(ArithmeticException e) {
        	return 0;
        }
        finally {
        	return 5;
        }
        
    }
    public static void main(String arg[]){
        System.out.println(method1());
    }
}
