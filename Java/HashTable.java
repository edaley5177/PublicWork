
import java.util.ArrayList;

/**
 * --------------------------------------------------------------------------
 * CLASS:  HashTable<K,V>
 * @author ureel
 * @see HashAPI
 * @see HashEntry
 * DESCRIPTION:
 * An implementation of Hash Table.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public class HashTable<K extends Comparable<K>, V> implements HashAPI<K, V> {
	//for the array representaion, make an arraylist of array lists
	//Arr
  ArrayList<ArrayList<HashEntryAPI<K,V>>> hashArray;
	int size;//total number of entries i am allowed to put in
	int numEnts = 0;//number of entries in right now is updated whenever i add or remove
   /**
    * --------------------------------------------------------------------------
    * Constructor:  HashTable( int capacity )
    * @author ureel
    * DESCRIPTION: Initialize the HashTable.
    * @param capacity - the capacity of the Hash Table (number of buckets.)
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public HashTable(int capacity) {
      // Your Code Here
		  hashArray= new ArrayList<ArrayList<HashEntryAPI<K,V>>>();
		 size = capacity;
   }

   /** return the number of nodes in the hash table */
   @Override
   public int size() {
      // TODO Auto-generated method stub
		 //maybe try to have a global variable that is updated every time i insert or delete a node
		 //just return the size of the table that was created in the constructor
      return numEnts;
   }

   /** return true of there are no nodes in the hash table */
   @Override
   public boolean isEmpty() {
		 if(size==0){
			 return true;
		 }
      // TODO Auto-generated method stub
      else{
				return false;
			}
   }

	//returns where in the bucket key is stored, or if it is not in the bucket, then it returns the index of
	//the next available bucket
	public int findSpot(int bucket,K key){
		int av = -1;//right now there is no spot available
		int i = 0;
		//check the key of every entry in the bucket, and if we find one htat matches what we are looing for,
		//return that, otherwise i will be = size of bucket so the index of the next available spot
		//first if bucket is a new one, then just return 0
		if(bucket>=hashArray.size()){
			return 0;
		}
		while(i<hashArray.get(bucket).size()){
			if(hashArray.get(bucket).get(i).getKey().compareTo(key) == 0){
				break;
			}
			i++;
		}
		return i;
	}
	//given a key,get the value
	public V get(K key){
		int i =0;
		int g;
		//search through every bucket in the table
		while(i<numEnts){
			 g = findSpot(i,key);
			//if g is the next spot, then move on to the next bucket 
			//if g is = the size of that bucket, then key is not in that bucket
			if(g== hashArray.get(i).size()){
				i++;
			}
			//otherwise break because we have found where key is
			else{
				break;
			}
		}
		
		//i is the bucket and g is the spot in that bucket
		return hashArray.get(i).get(g);
	}
   /** add the value to the hashTable */
   @Override
   public V put(K key, V value) throws InvalidKeyException {
		 //first throw exception if necessary
		 if (key == null) {
         throw new InvalidKeyException();
      }
		 ArrayList<HashEntryAPI<K,V>> bucket;
		  int ind = this.hashFn(key);
		 if(ind>=hashArray.size()){
			bucket = new ArrayList<HashEntryAPI<K,V>>();
		 }
		 else{
			 bucket = hashArray.get(ind);
		 }
		/* ArrayList<HashEntryAPI<K,V>> bucket = hashArray.get(ind);
		 if(bucket == null){
			 bucket = new ArrayList<HashEntryAPI<K,V>>();
		 }*/
		 int i = findSpot(ind,key);
		 System.out.println("find spot is " + i);
		 if(i>=bucket.size()){
			 //this should happen almost every time
			 //set the key and value of what is in that spot
			 bucket.get(i).setValue(value);
			 bucket.get(i).setKey(key);
		 }
		//HashEntryAPI<K,V> next = bucket.get(i);
		 
		 //at the next available spot add the value
		 //bucket.set(i,next);
		 if(ind>=hashArray.size()){
			hashArray.add(bucket);
		 }
		 
			 numEnts++;
      // TODO Auto-generated method stub
		 //HeapEntryAPI<K, V> newEntry= new HeapEntry<K, V>( key, value);
		 
		 //return insert( newEntry );
			//hashArray.add()
      return value;
   }

   /** add the hashEntry to the hashTable */
   @Override
   public V put( HashEntryAPI< K, V > entry ) throws InvalidKeyException {
      // TODO Auto-generated method stub
		 //just add the entry to the array using the hash code as its index
		if ( entry.getKey() == null ) {
         throw new InvalidKeyException( );
      }
      return put(entry.getKey(),entry.getValue());
   }

   /** return the value if an entry with key is found in the hash table */
   @Override
   public V get( K key ) throws InvalidKeyException {
      // TODO Auto-generated method stub
		 if ( key == null ) {
         throw new InvalidKeyException( );
      }
		 //return the value at the index of key after it goes through the hash function
		 int bn = this.hashFn(key);//the bucket number
		 ArrayList<HashEntryAPI<K,V>> bucket = hashArray.get(bn);
		 //first get the index of the key 
		 int ki = findSpot(bn, key);
		 //check if that had something in it
		 if(bucket.get(ki) == null){
			 throw new InvalidKeyException();
		 }
		 V ret = bucket.get(ki).getValue();
		 
		 //HashEntryAPI<K,V> ret = 
      return ret;
   }

   /** remove the entry with key and return the value */
   @Override
   public V remove(K key) throws InvalidKeyException {
      // TODO Auto-generated method stub
		 //find the bucket with that key
		 if ( key == null ) {
         throw new InvalidKeyException( );
      }
		 int bn = this.hashFn(key);
		 ArrayList<HashEntryAPI<K,V>> bucket = hashArray.get(bn);
		 //first find the index in this bukcet that contains the entry with this key
		int r = findSpot(bn,key);
		 
		 //ArrayList<K,V> bucket = heapArray.get(this.hashFn(key));
		 //first get index of the 
		 //remove the element from that bucket
		V ret = bucket.remove(r).getValue();
		 numEnts--;
		 //use the remove method and return the V of what that method returns
      return ret;
   }

   /** convert the key to an integer using the hash function, e.g. abs(key) mod 43 */
   @Override
   public int hashFn(K key) {
      // Something like:
      // return( Math.abs( key.hashCode( ) ) % buckets.size( ) );
		 return (Math.abs(key.hashCode())%size);
     // return 0;
   }

   /** Represent the HashTable as a string. */
   public String toString( ) {
      // Something like:
      // return "<HashTable: " + buckets + ">";
      return "<HashTable: " + hashArray + ">";
   }
	
	public static void main (String[] args){
		HashTable test = new HashTable(10);
		Object x = test.put(1,"yes");
		System.out.println(test.toString());
		
	}

}
