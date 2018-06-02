import java.util.*;
import java.io.*;
import java.lang.*;
/*
Name: Eamonn Daley
Username: edaley
Description: This program will implement and run a deque
*/
public class Deque<E> implements DequeInterface<E>{

	private E[] array = (E[]) new Object[100];//the array representation of the deque, will be used in almost every method
	private int first = 49;//the index of the first element of the deque
	private int last = 50;//the index of the last element of the deque
	private int numEls = 0;//the number of elements in the deque
	
	public Deque(){
		
	}

	@Override
	public E[] getArray(){
	//just return the array representation that is built up as the deque is built
	return array;
	}
	@Override
	public int size(){
		return numEls;
	}
	@Override
	public boolean isEmpty(){
		if(numEls>0)
			return false;
		
		else
			return true;
	}
	//this method is used to wrap around first and last
	public void reset(){
		if(first<0){
			first =99;
		}
		if(last>99){
			last = 0;
		}
	}
	@Override
	public E first(){
		//return the first element in the array
		//but first check if the deque is empty
		if(this.isEmpty()){
			return null;
		}
		//return first +1 because it is currently where to put an element
		//i want to add to the front
		if(first!=99){
		return array[first+1];
		}
		else{
			return array[0];
		}
	}
	@Override
	public E last(){
		//first check if the deque is empty 
		if(this.isEmpty()){
			return null;
		}
		//otherwise return the last element in the array
		//return last -1 because it is currently where to put an element
		//i want to add to the back
		if(last !=0)
			return array[last-1];
		
		else
			return array[99];
	}
	@Override
 public void addFirst(E e){
		//add e to the begining of the deque
		//first make sure we aren't exceeding the capacity of this array
	 if(numEls == array.length)
			throw new DequeFullException();
		//then if the deque is empty add it to the front
		if(isEmpty()){
			array[first] = e;
			first-=1;
			reset();
				
		}
		else{
			//other wise add it to the front and update
			array[first] = e;
			first-=1;
			reset();
		}
		//then update the size
	 // and the index of first
		numEls++;
	}
	public static class DequeFullException extends RuntimeException{
	
}
	@Override
	public void addLast(E e){
		//add it to the end
		//add it to the last position
		//first check if i can
		if(numEls == array.length)
			throw new DequeFullException();

	//then add it to the end and update
		array[last] = e;
		last +=1;
		reset();
		//update size
		numEls++;
	}
	@Override
	public E removeFirst(){
		
		//get what i need to return
		//first is where an element should go if i want to insert it
		//first+1 is where the actual element is
		E ret = array[first+1];
		//then set that spot to null
		array[first+1] = null;
		//update first
		first+=1;
		reset();
		//update size
		numEls--;
		//then return the element
		return ret;
	}
	@Override
	public E removeLast(){
		//first save the last element
		E ret = array[last-1];
		//then set that spot to null
		array[last-1] = null;
		//then update last
		last -=1;
		reset();
		//update size
		numEls--;
		//then return the last element
		return ret;
	}
	//to print out all the elements of the array
	public String toString() {
   String result = "[ ";
   for( int i = 0; i < array.length; i++ ) {
		 if(array[i] != null)
      result += array[i] + " ";
   }
   result += "]";
   return result;
}
	public static void main(String[] args){
		Deque<Integer> myDeek = new Deque<Integer>();
		myDeek.addFirst(4);
		myDeek.addLast(3);
		myDeek.addFirst(2);
		myDeek.addLast(6);
		myDeek.addLast(5);
		myDeek.addFirst(7);
		myDeek.addFirst(9);

		String print = myDeek.toString();
		System.out.println(print);
		int s = myDeek.size();
		System.out.println(s +" is number of elements in the array");
		int f = myDeek.first();
		int l = myDeek.last();
		System.out.println(f+" is the first and "+ l +" is the last element");
		int fi = myDeek.removeFirst();
		int la = myDeek.removeLast();
		System.out.println(fi+" " + la + " are first and last and were removed the new deek is on the next line");
		print = myDeek.toString();
		System.out.println(print);
		
	}
	
}