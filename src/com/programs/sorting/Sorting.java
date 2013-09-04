package com.programs.sorting;

public class Sorting {
	
	private static void divider(){
		System.out.println("---------------------------------------------------------------");
	}
	
	private static void displayArray(int[] array){
		for(int i=0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	private static void swap(int x, int y){
		x = x+y;
		y = x-y;
		x = x-y;
	}
	
	public static void main(String arg[]){
		int[] unsorted = {5, 7, 1, 9, 4, 3, 0, 8};
		
		int a = 4, b = 6;
		//swap(a, b);
		System.out.print("Before Insertion Sorting: ");
		displayArray(unsorted);
		doInsertionSort(unsorted);
		System.out.print("After Insertion Sorting: ");
		displayArray(unsorted);
		
		divider();
		int[] unsorted2 = {5, 7, 1, 9, 4, 3, 0, 8};
		System.out.print("Before Selection Sorting: ");
		displayArray(unsorted2);
		doSelectionSort(unsorted2);
		System.out.print("After Selection Sorting: ");
		displayArray(unsorted2);
		
		divider();
		int[] unsorted3 = {5, 7, 1, 9, 4, 3, 0, 8};
		System.out.print("Before Bubble Sorting: ");
		displayArray(unsorted3);
		doBubbleSort(unsorted3);
		System.out.print("After Bubble Sorting: ");
		displayArray(unsorted3);
		
		divider();
		int[] unsorted4 = {5, 7, 1, 9, 4, 3, 0, 8};
		System.out.print("Before Bubble Sorting: ");
		displayArray(unsorted4);
		doBubbleSort(unsorted4);
		System.out.print("After Bubble Sorting: ");
		displayArray(unsorted4);
		
	}
	private static void doBubbleSort(int[] unsorted){
		for(int i=0; i < unsorted.length; i++){
			for(int j=0; j < unsorted.length-1; j++){
				if(unsorted[j] > unsorted[j+1]){
					//Swapping
					unsorted[j] = unsorted[j] + unsorted[j+1];
					unsorted[j+1] = unsorted[j] - unsorted[j+1];
					unsorted[j] = unsorted[j] - unsorted[j+1];
				}
			}
		}
		
	}
	private static void doSelectionSort(int[] unsorted){
		int index_min=0;
		
		for(int i=0; i < unsorted.length; i++){
			
			for(int j=i+1; j < unsorted.length; j++){
				if(unsorted[index_min] > unsorted[j]) {
					index_min = j;
				}
					
			}
			if(unsorted[i] > unsorted[index_min]) {
				unsorted[i] = unsorted[i] + unsorted[index_min];
				unsorted[index_min] = unsorted[i] - unsorted[index_min];
				unsorted[i] = unsorted[i] - unsorted[index_min];
			}
		}
	}
	private static void doInsertionSort(int[] unsorted) {
		int len = unsorted.length;
		for(int i=0; i<len;i++){
			for(int j=0; j<i; j++){
				if(unsorted[i] < unsorted[j]){
					//Do the swapping
					unsorted[i] = unsorted[i] + unsorted[j];
					unsorted[j] = unsorted[i] - unsorted[j];
					unsorted[i] = unsorted[i] - unsorted[j];
				}
				
			}
			
		}
	}
}
