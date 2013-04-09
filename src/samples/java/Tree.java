package samples.java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Tree{
	
	static Tree t1 = new Tree();
	static Node temp;
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//input of the format node, left, right
		// e.g B1, B2, 10 and B2, 5, 9
		String s = in.readLine();
		
		String[] input = s.split(",");
		
		//Constructing Root
		
		temp = t1.getNode(input);
		
		
		
	}
	
	public Node getNode(String[] input){
		Node newNode = new Node();
		
		for(int i=0;i<3;i++){
			
			if(input[i].matches("B(.*)")){
				newNode.setName(input[0]);
				newNode.setValue(1);
			}else{
				newNode.setName("leaf");
				newNode.setValue(Integer.parseInt(input[i]));
			}
			
		}
		
		return newNode;
		
	}
	
	class Node{
		int value=0;
		Node left, right;
		String name="leaf";
		
		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
		Node(){
			this.name=null;
			this.value=0;
			this.left=null;
			this.right=null;
		}
	}
	
}