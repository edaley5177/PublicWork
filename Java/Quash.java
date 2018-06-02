/**
 * --------------------------------------------------------------------------
 * CLASS: Quash<K extends Comparable<K>,V>
 * @author ureel
 * @see QuashAPI
 * DESCRIPTION:
 * Implements a Quash, which has the properties of both a Heap and a HashTable.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public class Quash<K extends Comparable<K>,V> extends QuashAPI<K,V> {
   
   ArrayHeap<K,V> heap = null;
   HashTable<K,V> hash = null;
	int size = 0;//the number of elements currently in the heap
   
   public Quash( int capacity ) {
      heap = new ArrayHeap<K,V>( capacity );
      hash = new HashTable<K,V>( capacity );
   }

   /** Number of entries in the Quash */
   @Override
   public int size() {
      // TODO Auto-generated method stub
		 //use global variable that starts and 0 and increases every time a node is inserted
		 //and is decremented every time a node is removed
		 //then return it here
      return size;
   }

   /** True if there are no entries in the Quash */
   @Override
   public boolean isEmpty() {
		 if(size==0){
			 return true;
		 }
    
		 else
		 {
			 return false;
		 }
      
   }

   /** Returns the value of the minimum entry in the Quash */
   @Override
   public V min( ) throws EmptyPriorityQueueException {
      // TODO Auto-generated method stub
		 //return the root of the min heap
		 //might need to add own array representaion
		 //or look up how to get root and get value
		 //just use get root in heap
      return heap.getRoot();
   }

   /** Removes the minimum entry in the Quash returning its value */
   @Override
   public V removeMin( ) throws EmptyPriorityQueueException {
      // TODO Auto-generated method stub
		 //remove the value at the root call remove(k) with value of min
		 //use min() to get that value
		 //use remove method in this class
		 K ret = this.min().getKey();
		 	//ret = heap.removeMin().getKey();
		 
      return this.remove(ret);//this will return the value of the key it removes so this is good
   }

   /** Puts a given value in the Quash. */
   @Override
   public V put(K key, V value) throws InvalidKeyException {
      // TODO Auto-generated method stub
		 //insert a node at bottom and bubble it up
		 //add to both 
		 //when adding to the heap, just use the insert method
		 EntryAPI ins = heap.insert(key,value);
		 V ret = hash.put(key,value);//just use the put method we worked on for the hash
      return ret;
   }

   /** Given a key, retrieves the associated value from the Quash. */
   @Override
   public V get( K key ) throws InvalidKeyException {
      // TODO Auto-generated method stub
		 //just return the value from here
      return hash.get(key);
   }

   /** Removes the entry identified by key from the Quash. */
   @Override
   public V remove( K key ) throws InvalidKeyException {
      // TODO Auto-generated method stub
		 //just call remove in hash!#@%$#@$
		 //$^@#$%&^might also havge to fix heap
		 EntryAPI<K,V> rem  = heap.remove(key);
      return hash.remove(key);
   }

   /** Prints, on two separate lines, the Heap and the HashTable from the Quash. */
   @Override
   public void print( ) {
      // TODO Auto-generated method stub
		 System.out.println(this.toString());
      
   }

   /**
    * Represents the Quash as a human readable string.
    * @return 
    */
   @Override
   public String toString( ) {
      return "<Quash:\n   heap:" +  heap + "\n   hash:" + hash + ">";
   }
}
