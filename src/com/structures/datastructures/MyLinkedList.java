package com.structures.datastructures;

public class MyLinkedList {
	
	static class SinglyLLNode {
		SinglyLLNode next = new SinglyLLNode();
		int value;
	}
	
	static class DoublyLLNode {
			DoublyLLNode next = new DoublyLLNode();
			DoublyLLNode prev = new DoublyLLNode();
			int value;
	}
	
	//Methods for Singly LL
	public void addNode(SinglyLLNode node){}
	public int findNode(SinglyLLNode head){
		//Returns the index of that node
		return 0;
	}
	public void deleteNode(SinglyLLNode node){}
	public void traverse(SinglyLLNode head){}
	public MyLinkedList getSampleSinglyLL(){
		return new MyLinkedList();
	}
	
	//Methods for Doubly LL
	public void addNode(DoublyLLNode node){}
	public void deleteNode(DoublyLLNode node){}
	public void traverse(DoublyLLNode head){}
	public int findNode(DoublyLLNode head){
		//Returns the index of that node
		return 0;
	}
	public MyLinkedList getSampleDoublyLL(){
		return new MyLinkedList();
	}
	
	

}
