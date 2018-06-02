import java.util.*;
import java.io.*;

//the test file for binary search tree
public class BinarySearchTreeTest extends BinarySearchTree{
	public static void main(String[] args){
		
	
	//first build a small tree
BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();
		testTree.addElement(5);
		testTree.addElement(4);
		testTree.addElement(6);
		testTree.addElement(1);
		testTree.addElement(3);
		testTree.addElement(45);
		testTree.addElement(17);
		testTree.addElement(20);
		
//then call methods to test them
		boolean pri = testTree.contains(6);
		boolean con = testTree.contains(2);
		Node mn = testTree.getMaxNode(testTree.root);
		int re = testTree.removeElement(1);
		
//if they pass print a message if they fail print a different message
	if(pri && !con){
		System.out.println("Contains works!!!");
	}
		else{
			System.out.println("Contains needs to be fixed:(");
		}
		if(mn.getElement() == 6){
			System.out.println("Get max node works");
		}
		else{
			System.out.println("Get max node needs to be fixed:(");
		}
		
		if(re == 1){
			System.out.println("Remove element works!!!");
		}
		else{
						System.out.println("Remove needs to be fixed:(");

		}
		
		//test the inorder traversal
		Iterator ioti = testTree.iteratorInOrder();
		while(ioti.hasNext()){
						System.out.println(ioti.next());

		}
								System.out.println("In order is done");
								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("Preorder is below");

		//test preorder traversal
		Iterator proti = testTree.iteratorPreOrder();
		while(proti.hasNext()){
									System.out.println(proti.next());

		}
		
								System.out.println("Pre order is done");
								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("Post order is below");
		//test out post order
		Iterator poti = testTree.iteratorPostOrder();
		while(poti.hasNext()){
			System.out.println(poti.next());
		}
		
	}
}