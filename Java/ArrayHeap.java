import java.util.*;
/**
 * --------------------------------------------------------------------------
 * CLASS:  ArrayHeap<K,V>
 * @author ureel
 * @see AbstractArrayHeap
 * @see HeapEntry
 * DESCRIPTION:
 * An Array-based implementation of Heap.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public class ArrayHeap<K extends Comparable<K>, V> extends AbstractArrayHeap<K,V> {
  	//ArrayHeap<K,V> heap = null;//make this array representation of the heap a global variable
   /**
    * --------------------------------------------------------------------------
    * Constructor:  ArrayHeap( int capacity )
    * @author ureel
    * DESCRIPTION: Initialize the Heap array.
    * @param capacity - the initial capacity of the heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public ArrayHeap(int capacity) {
      super(capacity);
		 //heap = new AbstractArrayHeap<K,V>(capacity);
		 //this.capacity = capacity;
		 //heap = new ArrayHeap<K,V>(capacity);
   }
   
   /**
    * --------------------------------------------------------------------------
    * METHODS: remove( K key)
    * @author ureel
    * DESCRIPTION:
    * Removes and returns an entry from the Heap then fixes the heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public EntryAPI<K,V> remove(K key) throws EmptyPriorityQueueException {
      // Your Code Here
		 //first throw the exception 
		 /*if(heap.isEmpty()){
			 throw EmptyPriorityQueueException();
		 }*/
		 		//next search through the array to find the index of the key that is to be removed
		 //encase the entire method in a try block and catch exception any time
		 try{
		 int i =0;
			 //search through the array and get the index of the element i need to remove
		 while(heapArray.get(i).getKey() != key){
			 i++;
		 }
		 //once that loop is done, i = the index of the entry we need to remove, so chek if it is in a few special places
			 //HeapEntryAPI<K,V>[] arr = new HeapEntry<K,V> [heapArray.size()];//used to pass to swap
		 //sarr = heapArray.toArray(arr);
			 if(i ==0){
			 return removeMin();
		 }
		 
		  int rc = 2*i +2;
		 int lc = 2*i +1;
		 //get index of its parent
		 int pi = (i-1)/2;
		 if(rc > this.size() && lc >this.size()){
			 //if it is on the bottom of the tree, swap it with it's closest neighbor
			 //until it is in last spot, and then set that to null and update size
			 int j=i+1;
			 while(i < this.size()){
				 swap(i,j);
				 i++;
				 j++;
			 }
			 //before completely destroying it, save the entry so i can return it later
			// EntryAPI<K,V> ret = heapArray(i);
				//heapArray(i) = null;
			 
			 this.decrementNextEntryIndex();
			 return heapArray.remove(i);	 
		 }
			 //remove the element with the key of key,
			 //draw out using white board!!!!!!!!!@%@#&^$%^%^&*@$
			 //use down heap
			 //first swap with highest element
			 //will need to get index of key
			 //swap(heap,)
			int last = this.getNextEntryIndex() -1;
		 	swap(i,last);
		 	/*EntryAPI<K,V> save = heapArray.get(last);
		 heapArray(last) = null;*/
		 decrementNextEntryIndex();
		 downHeap(i);
      return heapArray.remove(last); 
		 }
		 catch(EmptyPriorityQueueException e){
			 System.out.println("Queue was empty when removing");
		 }
		 return null;//if this is returned, then exception was caught
   }

	//return the root of the heap
	public EntryAPI<K,V> getRoot(){
		return heapArray.get(0);
	}
   /**
    * --------------------------------------------------------------------------
    * METHODS: downHeap( int indexOfEntry )
    * @author ureel
    * DESCRIPTION:
    * Bubbles the indexed entry down the Heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   protected void downHeap(int indexOfEntry) {
		 /*System.out.println("Before down heap index to move down is " + indexOfEntry);
		 System.out.println(this.toString());*/
      // Your Code Here
		 //do this recursively
		 int rc = 2*indexOfEntry+2;
		 int lc = 2*indexOfEntry+1;
		 //HeapEntryAPI<K,V>[] arr = new HeapEntry<K,V> [heapArray.size()];//used to pass to swap
		// arr = heapArray.toArray(arr);
		 
		 if((rc > this.size() && lc>this.size()))
		 {
			 //System.out.println("Left and right were out of bounds");
			 return;
		 }
		 boolean swlc = heapArray.get(indexOfEntry).getKey().compareTo(heapArray.get(lc).getKey()) >=0; //weather or not i should swap with the left child
		 boolean swrc = heapArray.get(indexOfEntry).getKey().compareTo(heapArray.get(rc).getKey()) >=0; //weather or not i should swap with the right child
		 if(!swrc && !swlc){
			 
		//	System.out.println("Had a left and didn't swap");
			//System.out.println("Left kid index is " + lc);
			 
			 return;
		 }
		 //the base case
		 //has no children, or is less than both the left and right child
		 
		 
		 //recursive case
		 
			 //if it should be swapped with its left child, do that and restart the recursion
			 if(swlc){
				 
				 swap(lc,indexOfEntry);
				 indexOfEntry = lc;
				 downHeap(indexOfEntry);
			 }
			 //otherwise swap with the right child
			 else if(swrc){
				 swap(rc,indexOfEntry);
				 indexOfEntry = rc;
				 downHeap(indexOfEntry);
			 }
		 
		 //swap the element at indexs of entry with one of its children 
		 //this will look like down heap in heap utils
		 /*
		 //draw on whiteboard$#@^#$%*&*%^*&!!!!!!!!!!!!
		 //due to this returning void, i will use a while loop
		 //keep running as long as current is greater than both its children
		 while(heap[indexOfEntry].getValue().compareTo(heap[2*(indexOfEntry+1)]) >0 
					&& heap[indexOfEntry].getValue().compareTo(heap[2*(indexOfEntry+2)]) >0){
			 // check to see if */
		 }
		 
   
	
				//my own swap method used for bubbling down
	public void swap(int indexa,int indexb){
		//data[indexa]
		HeapEntryAPI<K,V> aspot =heapArray.get(indexa);
		HeapEntryAPI<K,V> bspot = heapArray.get(indexb);
		//now we have the entries saved to variables
		heapArray.set(indexa,bspot);
		heapArray.set(indexb,aspot);
		//data[indexa] = bspot;
		//data[indexb] = aspot;
	}
	
	public static void main(String[] args){
		ArrayHeap test = new ArrayHeap(7);
		HeapEntry<Integer,Object> a = new HeapEntry<Integer,Object>(1,"A");
		HeapEntry<Integer,Object> b = new HeapEntry<Integer,Object>(2,"B");
		HeapEntry<Integer,Object> c = new HeapEntry<Integer,Object>(3,"C");
		HeapEntry<Integer,Object> d = new HeapEntry<Integer,Object>(4,"D");
		HeapEntry<Integer,Object> e = new HeapEntry<Integer,Object>(5,"E");
		HeapEntry<Integer,Object> f = new HeapEntry<Integer,Object>(6,"F");
		HeapEntry<Integer,Object> g = new HeapEntry<Integer,Object>(7,"G");
		HeapEntry<Integer,Object> h = new HeapEntry<Integer,Object>(8,"H");
		HeapEntry<Integer,Object> i = new HeapEntry<Integer,Object>(9,"I");
		HeapEntry<Integer,Object> j = new HeapEntry<Integer,Object>(10,"J");
						


		test.insert(a);
		test.insert(b);
		test.insert(c);
		test.insert(d);
		test.insert(e);
		test.insert(f);
		test.insert(g);
		test.insert(h);
		test.insert(i);
		test.insert(j);
		//System.out.println("Before removal of anything");
		//System.out.println(test.toString());
		EntryAPI<Integer,Object> remC = test.remove(3);
		EntryAPI<Integer,Object> remB = test.remove(2);
		//System.out.println("After removal of everything");
		//System.out.println(test.toString());
	}
}
