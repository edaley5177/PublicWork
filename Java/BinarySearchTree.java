import java.util.Iterator;
import java.util.*;

/**
 * A Binary Search Tree is a binary tree that has the property that for any 
 * given node A in the tree, the value of the nodes in the left subtree are
 * less than the value of node A and the value of the nodes in the right subtree 
 * are greater than the value of node A.
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> extends AbstractBinarySearchTree<T> {

	//cunstructor that creates the tree
	public BinarySearchTree(){
		
	}
	
   /**  
    * Returns an iterator that represents an inorder traversal on this binary tree.  
    *
    * @return an iterator over the elements of this binary tree
    */
   @Override
   public Iterator<T> iteratorInOrder() {
		 Node curr = this.root;//current node 
		 //first declare a stack and array list
		 List retList = new ArrayList();
		 Stack<Node> s = new Stack<Node>();
		//a while loop to get all nodes into array list 
		 while(!s.empty() || curr!=null){
			 if(curr!=null){
				 //add curr to the stack
				 s.push(curr);
				 //move to the left
				 curr = curr.getLeft();
			 }
			 else{
				 //add whats on top of the stack to the array list
				 Node n = s.peek();
				 retList.add(n);
				 //debug
				// System.out.println(n.getElement() + " was just added to list");
				 s.pop();
				 //then go to the right
				 curr = n.getRight();
			 }
		 }
		 //then return that iterator
		 Iterator<T> ret = retList.iterator();
      return ret;
   }

   /**  
    * Returns an iterator that represents a preorder traversal on this binary tree. 
    *
    * @return an iterator over the elements of this binary tree
    */
   @Override
   public Iterator<T> iteratorPreOrder(){
		 
		 //Node curr = this.root; 
		 List proList = new ArrayList();
		 Stack<Node> preOrd = new Stack<Node>();//stack of nodes for the traversal
		 //add the root to it
		 preOrd.push(this.root);
		 
		 while(preOrd.empty() ==false){
			 //save the node on top 
			 //add it  to the iterator
			 Node top = preOrd.peek();
			 //ret.next(top);
			 proList.add(top);
			
			 preOrd.pop();
			 
			 //then push the right and left children onto the stack
			 if(top.getRight() !=null){
				 preOrd.push(top.getRight());
			 }
			 if(top.getLeft()!=null){
				 preOrd.push(top.getLeft());
			 }
		 }
		 Iterator ret = proList.iterator();
      // return the iterator
      return ret;
   }

   /**  
    * Returns an iterator that represents a postorder traversal on this binary tree. 
    *
    * @return an iterator over the elements of this binary tree
    */
   @Override
   public Iterator<T> iteratorPostOrder(){
		 ArrayList poal = new ArrayList();
		 Stack<Node> poor = new Stack<Node>();
		 Iterator porit = poal.iterator();//will need to redo at end too
		 Node curr = root;//start at the root
		 Node par = null;//will be the parent
		 poor.push(curr);//put the root on top of the stack
		 
		 while(poor.isEmpty() == false){
			 curr = poor.peek();
			 if(par ==null || par.getLeft() == curr || par.getRight() == curr){
				 if(curr.getLeft() != null){
					 poor.push(curr.getLeft());
				 }
				 else if(curr.getRight() != null){
					 poor.push(curr.getRight());
				 }
				 else{
					 poor.pop();
					 poal.add(curr);
				 }
			 }
			 else if(curr.getLeft()== par){
				 if(curr.getRight()  != null){
					 poor.push(curr.getRight());
				 }
				 else{
					 poor.pop();
					 poal.add(curr);
				 }
			 }
			 else if(curr.getRight() == par){
				 poor.pop();
				 poal.add(curr);
			 }
			
			 par = curr;
			 
		 }
		 porit = poal.iterator();
      // TODO Auto-generated method stub
      return porit;
   }

   /** 
    * Removes and returns the specified element from this tree. 
    *
    * @param targetElement the element to be removed from the tree
    * @return the element to be removed from the tree
    */
   @Override
   public T removeElement( T targetElement ) {
		 //set a node with its value = targetElement
		 Node te = findNode(targetElement);//just a default value
		 //use find node to get a reference to where that node is
		 //in a few steps remove the node from the tree
		 Node ri = te.getRight();
		 //first make the left and right null
		 te.right = null;
			 te.left = null;
		 //somehow set it's parent left or right to ri
		 addElement(ri.getElement());
		 //work out on paper
		 
		 //return that element
		 return te.getElement();
      // TODO Auto-generated method stub
      //return null;
   }

   /** 
    * Returns the node with the largest element in the subtree rooted at 
    * the given node. 
    * 
    * @return the node with the largest element in the subtree
    */
   @Override
   protected Node getMaxNode(Node node) {
		 //keep going to the right until there are no more right children then return that node
		 //do this recursively
		 //base case
		 if(node.right == null){
			 return node;
		 }
		 //recursive case
		 else{
			 return getMaxNode(node.right);
		 }
      // TODO Auto-generated method stub
      //return null;
   }

   /** 
    * Returns true if the binary tree contains an element that matches
    * the specified element and false otherwise. 
    *
    * @param targetElement the element being sought in the tree
    * @return true if the tree contains the target element
    */
   @Override
   public boolean contains(T targetElement) {
		 	Node currCont = this.root;//current node for the contains method

		 //start at root and wither return the current node,
		 //go to the left,
		 //or go tot the right
		
		 //use a while loop to do one of those 3 things
		 while(currCont != null){
		 	if(currCont.getElement().compareTo(targetElement) ==0){
				 return true;
		 	}
		 	else if(currCont.getElement().compareTo(targetElement)<0){
				currCont = currCont.getRight();
		 	}
			 else{
				 currCont = currCont.getLeft();
			 }
		 }
      return false;
   }

}